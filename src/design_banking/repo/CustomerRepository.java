package design_banking.repo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import design_banking.model.Customer;

public class CustomerRepository {
	private Vector<Customer> data = new Vector<>();
	private static CustomerRepository instance = null;

	private CustomerRepository() {
		read();
	}

	public static CustomerRepository getInstance() {
		if (instance == null)
			instance = new CustomerRepository();
		return instance;
	}

	public Customer find(String id) {
		for (var c : data)
			if (c.getId().equals(id))
				return c;
		return null;
	}

	public Customer findByName(String name) {
		for (var c : data)
			if (c.getName().equalsIgnoreCase(name))
				return c;
		return null;
	}

	public List<Customer> getData() {
		return Collections.unmodifiableList(data);
	}

	public void add(Customer customer) throws IOException {
		data.add(customer);
		save();
	}

	public void change(Customer old, Customer customer) throws IOException {
		var i = data.indexOf(old);
		data.set(i, customer);
		save();
	}

	public void remove(Customer customer) throws IOException {
		data.remove(customer);
		save();
	}

	private void read() {
		FileInputStream fis = null;
		DataInputStream dis = null;
		try {
			fis = new FileInputStream("Bank.dat");
			dis = new DataInputStream(fis);
			var s = new String[6];
			while (true) {
				for (int i = 0; i < 6; i++) {
					s[i] = dis.readUTF();
				}
				data.add(Customer.fromDb(s));
			}
		} catch (Exception ex) {
			try {
				dis.close();
				fis.close();
			} catch (Exception exp) {
			}
		}
	}

	private void save() throws IOException {
		var fos = new FileOutputStream("Bank.dat");
		var dos = new DataOutputStream(fos);
		for (var d : data)
			for (var s : d.toDb())
				dos.writeUTF(s);
		dos.close();
		fos.close();
	}
}
