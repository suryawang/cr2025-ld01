package banking.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import banking.model.Customer;

public class Database {
	private int rows = 0;

	private Customer records[] = new Customer[500];

	public int length() {
		return rows;
	}

	public Customer get(int i) {
		return records[i];
	}

	public void add(Customer value) throws IOException {
		rows++;
		set(rows - 1, value);
	}

	public void set(int index, Customer value) throws IOException {
		records[index] = value;
		save();
	}

	public int findByNo(String no) {
		for (int x = 0; x < rows; x++)
			if (records[x].getNo().equals(no))
				return x;
		return -1;
	}

	public int findByName(String name) {
		for (int x = 0; x < rows; x++)
			if (records[x].getName().equalsIgnoreCase(name))
				return x;
		return -1;
	}

	public void read() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			rows = 0;
			fis = new FileInputStream("Bank.dat");
			dis = new DataInputStream(fis);
			while (true) {
				var d = new String[6];
				for (int i = 0; i < 6; i++) {
					d[i] = dis.readUTF();
				}
				records[rows] = new Customer(d[0], d[1], d[2], Integer.parseInt(d[3]), Integer.parseInt(d[4]),
						Integer.parseInt(d[5]));
				rows++;
			}
		} catch (Exception ex) {
			try {
				dis.close();
				fis.close();
			} catch (Exception exp) {
			}
		}

	}

	public void save() throws IOException {
		FileOutputStream fos = new FileOutputStream("Bank.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		if (records != null) {
			for (int i = 0; i < rows; i++) {
				var d = records[i].toRecord();
				for (int c = 0; c < 6; c++) {
					dos.writeUTF(d[c]);
				}
			}
			dos.close();
			fos.close();
		}
	}

	public void delete(int index) throws IOException {
		if (records != null) {
			for (int i = index; i < rows - 1; i++)
				records[i] = records[i + 1];
			rows--;
			save();
		}
	}

}
