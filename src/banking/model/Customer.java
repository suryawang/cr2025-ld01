package banking.model;

public class Customer {
	private String no;
	private String name;
	private String month;
	private int day;
	private int year;
	private int balance;

	public Customer(String no, String name, String month, int day, int year, int balance) {
		super();
		this.no = no;
		this.name = name;
		this.month = month;
		this.day = day;
		this.year = year;
		this.balance = balance;
	}

	public String getNo() {
		return no;
	}

	public String getName() {
		return name;
	}

	public int getBalance() {
		return balance;
	}

	public String getDate() {
		return month + ", " + day + ", " + year;
	}

	public String[] toRecord() {
		return new String[] { no, name, month, "" + day, "" + year, "" + balance };
	}
}
