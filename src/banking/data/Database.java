package banking.data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JOptionPane;

public class Database {
	private int rows = 0;

	private String records[][] = new String[500][6];

	public int length() {
		return rows;
	}

	public String[] get(int i) {
		return records[i];
	}

	public void add(String... args) throws IOException {
		rows++;
		set(rows - 1, args);
	}

	public void set(int index, String... args) throws IOException {
		for (int i = 0; i < 6; i++)
			records[index][i] = args[i];
		save();
	}

	public int findByNo(String no) {
		for (int x = 0; x < rows; x++)
			if (records[x][0].equals(no))
				return x;
		return -1;
	}

	public int findByName(String name) {
		for (int x = 0; x < rows; x++)
			if (records[x][1].equalsIgnoreCase(name))
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
				for (int i = 0; i < 6; i++) {
					records[rows][i] = dis.readUTF();
				}
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
				for (int c = 0; c < 6; c++) {
					dos.writeUTF(records[i][c]);
					if (records[i][c] == null)
						break;
				}
			}
			dos.close();
			fos.close();
		}
	}

	public void delete(int index) throws IOException {
		if (records != null) {
			for (int i = index; i < rows - 1; i++) {
				for (int r = 0; r < 6; r++) {
					records[i][r] = records[i + 1][r];
					if (records[i][r] == null)
						break;
				}
			}
			rows--;
			save();
		}
	}

}
