package switch_statement;

public class BillingPlan {
	private String detail;

	public BillingPlan(String detail) {
		this.detail = detail;
	}

	public String getDetail() {
		return detail;
	}
	public static BillingPlan basic() {
		return new BillingPlan("basic");
	}
}
