package exercise;
import java.util.Date;

public class DecomposeConditional {

	class Stadium {
		  private final Date SUMMER_START = new Date(1500);
		  private final Date SUMMER_END = new Date(2500);
		  public double summerRate;
		  public double winterRate;
		  public double winterServiceCharge;
		  
		  public Stadium(double summer, double winter, double service) {
			  this.summerRate = summer;
			  this.winterRate = winter;
			  this.winterServiceCharge = service;
		  }
		  
		  // Helper method to check if the date is in winter
		  private boolean isWinter(Date date) {
			  return date.before(SUMMER_START) || date.after(SUMMER_END);
		  }

		  // Calculate ticket price for winter
		  private double calculateWinterCharge(int quantity) {
			  return quantity * winterRate + winterServiceCharge;
		  }

		  // Calculate ticket price for summer
		  private double calculateSummerCharge(int quantity) {
			  return quantity * summerRate;
		  }

		  // Refactored method
		  public double getTicketPrice(Date date, int quantity) {
			  if (isWinter(date)) {
				  return calculateWinterCharge(quantity);
			  } else {
				  return calculateSummerCharge(quantity);
			  }
		  }
	}

	public void test() {
		Stadium s = new Stadium(100, 90, 25);
		System.out.println(s.getTicketPrice(new Date(1000), 10));  // Winter case
		System.out.println(s.getTicketPrice(new Date(2000), 10));  // Summer case
		System.out.println(s.getTicketPrice(new Date(3000), 10));  // Winter case
	}

	public static void main(String[] args) {
		new DecomposeConditional().test();
	}
}
