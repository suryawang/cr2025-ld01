package long_parameter_list;

public class Wallet {
	private int balance;
	
	public Wallet() {
		super();
		balance = 0;
	}

	public void add(int amount) {
		balance += amount;
	}
	
	public void reduce(int amount) {
		balance -= amount;
	}

	public int getBalance() {
		return balance;
	}
}
