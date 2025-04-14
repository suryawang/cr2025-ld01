package exercise;
public class ExtractSubClass {
// todo: extract subclass PartsItem & LaborItem from JobItem
	class JobItem {
	  private int quantity;
	  private int unitPrice;
	  private Employee employee;
	  

	  public JobItem(int quantity, int unitPrice, Employee employee) {
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.employee = employee;
	  }
	  
	  public int getTotalPrice() {
		return quantity * getUnitPrice();
	  }
	  
	  public int getQuantity() {
		return quantity;
	  }
	  
	  public int getUnitPrice() {
		return (employee.isLabor) ? employee.getRate() : unitPrice;
	  }
	  
	  public Employee getEmployee() {
		return employee;
	  }
	}

	class Employee {
	  private int rate;
	  private boolean isLabor;
	  
	  public Employee(int rate, boolean isLabor) {
		this.rate = rate;
		this.isLabor = isLabor;
	  }
	  public int getRate() {
		return rate;
	  }
	  
	  public boolean getLabor() {
		  return isLabor;
	  }
	}
	
	public void action() {
		Employee kent = new Employee(50, true);
		JobItem j1 = new JobItem(5, 0, kent);
		JobItem j2 = new JobItem(15, 10, null);
		int total = j1.getTotalPrice() + j2.getTotalPrice();
		System.out.println(total);
	}
	public static void main(String[] args) {
		new ExtractSubClass().action();
	}
}
