package design_banking.model;

import java.util.Arrays;
import java.util.List;

public class Customer {
	private String id;
	private String name;
	private String month;
	private int day;
	private int year;
	private int balance;

	public Customer(String id, String name, String month, int day, int year, int balance) {
		this.id = id;
		this.name = name;
		this.month = month;
		this.day = day;
		this.year = year;
		setBalance(balance);
	}

	public static Customer fromDb(String[] s) {
		return new Customer(s[0], s[1], s[2], Integer.parseInt(s[3]), Integer.parseInt(s[4]), Integer.parseInt(s[5]));
	}

	public List<String> toDb() {
		return Arrays.asList(id, name, month, "" + day, "" + year, "" + balance);
	}

	public String getDate() {
		return String.format("%s, %02d, %04d", month, day, year);
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public void setBalance(int value) {
		if (value < 0)
			value = 0;
		balance = value;
	}

	public int getBalance() {
		return balance;
	}

}
