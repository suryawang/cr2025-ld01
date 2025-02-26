package exercise;
public class ExtractSubClass {
// todo: extract subclass PartsItem & LaborItem from JobItem
	abstract class JobItem {
	  private int quantity;
	  protected int unitPrice;
	  protected Employee employee;


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
	  
	  public abstract int getUnitPrice() ;
	  
	  public Employee getEmployee() {
		return employee;
	  }
	}
	
	class PartsItem extends JobItem{
		public PartsItem(int quantity, int unitPrice, Employee employee) {
			super(quantity, unitPrice, employee);
		}
		public int getUnitPrice() {
			return this.unitPrice;
		}
	}
	
	class LaborItem extends JobItem{
		public LaborItem(int quantity, int unitPrice, Employee employee) {
			super(quantity, unitPrice, employee);
		}
		public int getUnitPrice() {
			return employee.getRate();
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
		JobItem j1 = new LaborItem(5, 0, kent);
		JobItem j2 = new PartsItem(15, 10,  null);
		int total = j1.getTotalPrice() + j2.getTotalPrice();
		System.out.println(total);
	}
	public static void main(String[] args) {
		new ExtractSubClass().action();
	}
}
