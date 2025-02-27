package switch_statement;

public class IntroduceNullObject {
	class Company {
		// …
		private Customer customer;

		public Customer getCustomer() {
			return customer == null ? new NullCustomer() : customer;
		}
	}

	class Customer {
		private String name;
		private BillingPlan plan;
		private PaymentHistory history;
		
		public Customer(String name, BillingPlan plan, PaymentHistory history) {
			super();
			this.name = name;
			this.plan = plan;
			this.history = history;
		}

		public String getName() {
			return name;
		}

		public BillingPlan getPlan() {
			return plan;
		}

		public PaymentHistory getHistory() {
			return history;
		}
	}
	class NullCustomer extends Customer {
		public NullCustomer() {
			super("N/A", BillingPlan.basic(), new NullPaymentHistory());
		}		
	}

	class PaymentHistory {
		private int delay;
		public void setDelay(int delay) {
			this.delay = delay;
		}
		public int getWeeksDelinquentInLastYear() {
			return delay;
		}
	}
	class NullPaymentHistory extends PaymentHistory {
		public int getWeeksDelinquentInLastYear() {
			return 0;
		}
	}

	void test() {
		// Somewhere in client code
		Company site = new Company();
		Customer customer = site.getCustomer();
		System.out.println(customer.getName());
		System.out.println(customer.getPlan().getDetail());
		System.out.println(customer.getHistory().getWeeksDelinquentInLastYear());
	}

	public static void main(String[] a) {
		new IntroduceNullObject().test();
	}
}
