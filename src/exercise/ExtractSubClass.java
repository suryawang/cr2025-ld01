package exercise;
public class ExtractSubClass {

	class JobItem {
	  private int quantity;
	  private int unitPrice;
	  
	  public JobItem(int quantity, int unitPrice) {
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	  }
	  public int getTotalPrice() {
		return quantity * getUnitPrice();
	  }
	  public int getQuantity() {
		return quantity;
	  }
	  public int getUnitPrice() {
		return unitPrice;
	  }
	}

	class PartsItem extends JobItem {
	  public PartsItem(int quantity, int unitPrice) {
		  super(quantity, unitPrice);
	  }
	}

	class LaborItem extends JobItem {
	  private Employee employee;

	  public LaborItem(int quantity, Employee employee) {
		  super(quantity, employee.getRate());
		  this.employee = employee;
	  }
	}

	class Employee {
	  private int rate;
	  public Employee(int rate) {
		this.rate = rate;
	  }
	  public int getRate() {
		return rate;
	  }
	}
	public void action() {
		Employee kent = new Employee(50);
		JobItem j1 = new LaborItem(5, kent);
		JobItem j2 = new PartsItem(15, 10);
		int total = j1.getTotalPrice() + j2.getTotalPrice();
		System.out.println(total);
	}
	public static void main(String[] args) {
		new ExtractSubClass().action();
	}
}
