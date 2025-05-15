package design_banking.repo;

import java.io.DataInputStream;
import java.io.FileInputStream;
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

	public List<Customer> getData() {
		return Collections.unmodifiableList(data);
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
}
