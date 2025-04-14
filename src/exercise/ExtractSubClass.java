package exercise;

public class ExtractSubClass {

	public static void main(String[] args) {
		new ExtractSubClass().execute();
	}

	public void execute() {
		Employee kent = new Employee(50);
		JobItem labor = createLaborItem(5, kent);
		JobItem parts = createPartsItem(15, 10);

		int totalPrice = calculateTotalPrice(labor, parts);
		displayTotal(totalPrice);
	}

	private JobItem createLaborItem(int quantity, Employee employee) {
		return new LaborItem(quantity, employee);
	}

	private JobItem createPartsItem(int quantity, int unitPrice) {
		return new PartsItem(quantity, unitPrice);
	}

	private int calculateTotalPrice(JobItem... items) {
		int total = 0;
		for (JobItem item : items) {
			total += item.getTotalPrice();
		}
		return total;
	}

	private void displayTotal(int total) {
		System.out.println(total);
	}

	abstract class JobItem {
		private int quantity;

		protected JobItem(int quantity) {
			this.quantity = quantity;
		}

		public int getTotalPrice() {
			return quantity * getUnitPrice();
		}

		public int getQuantity() {
			return quantity;
		}

		protected abstract int getUnitPrice();
	}

	class PartsItem extends JobItem {
		private int unitPrice;

		public PartsItem(int quantity, int unitPrice) {
			super(quantity);
			this.unitPrice = unitPrice;
		}

		@Override
		protected int getUnitPrice() {
			return unitPrice;
		}
	}

	class LaborItem extends JobItem {
		private Employee employee;

		public LaborItem(int quantity, Employee employee) {
			super(quantity);
			this.employee = employee;
		}

		@Override
		protected int getUnitPrice() {
			return employee.getRate();
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
}
