package exercise;
public class ExtractSubClass {
// todo: extract subclass PartsItem & LaborItem from JobItem
	class JobItem {
	  private int quantity;
	  private int unitPrice;
	  private Employee employee;
	  private boolean isLabor;

	  public JobItem(int quantity, int unitPrice, boolean isLabor, Employee employee) {
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.isLabor = isLabor;
		this.employee = employee;
	  }
	  public int getTotalPrice() {
		return quantity * getUnitPrice();
	  }
	  public int getQuantity() {
		return quantity;
	  }
	  public int getUnitPrice() {
		return (isLabor) ? employee.getRate() : unitPrice;
	  }
	  public Employee getEmployee() {
		return employee;
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
		JobItem j1 = new JobItem(5, 0, true, kent);
		JobItem j2 = new JobItem(15, 10, false, null);
		int total = j1.getTotalPrice() + j2.getTotalPrice();
		System.out.println(total);
	}
	public static void main(String[] args) {
		new ExtractSubClass().action();
	}
}