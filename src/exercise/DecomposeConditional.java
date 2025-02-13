package exercise;
import java.util.Date;

public class DecomposeConditional {

    class Stadium {
        private final Date SUMMER_START = new Date(1500);
        private final Date SUMMER_END = new Date(2500);
        private double summerRate;
        private double winterRate;
        private double winterServiceCharge;

        public Stadium(double summer, double winter, double service) {
            this.summerRate = summer;
            this.winterRate = winter;
            this.winterServiceCharge = service;
        }

        public double getTicketPrice(Date date, int quantity) {
            if (isWinter(date)) {
                return calculateWinterCharge(quantity);
            }
            return calculateSummerCharge(quantity);
        }

        private boolean isWinter(Date date) {
            return date.before(SUMMER_START) || date.after(SUMMER_END);
        }

        private double calculateWinterCharge(int quantity) {
            return quantity * winterRate + winterServiceCharge;
        }

        private double calculateSummerCharge(int quantity) {
            return quantity * summerRate;
        }
    }

    public void test() {
        Stadium s = new Stadium(100, 90, 25);
        System.out.println(s.getTicketPrice(new Date(1000), 10));
        System.out.println(s.getTicketPrice(new Date(2000), 10));
        System.out.println(s.getTicketPrice(new Date(3000), 10));
    }

    public static void main(String[] args) {
        new DecomposeConditional().test();
    }
}
