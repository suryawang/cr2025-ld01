package exercise;
import java.util.Date;
import java.util.Enumeration;
import java.util.Vector;


public class ParameterizeObject {
    
    class Account {
        private Vector transactions = new Vector();

        public Account() {
            transactions.add(new Transaction(1000, new Date(1000)));
            transactions.add(new Transaction(1200, new Date(1100)));
            transactions.add(new Transaction(1500, new Date(1200)));
            transactions.add(new Transaction(1300, new Date(1300)));
        }

        // Refactored to use DateRange
        public double getFlowBetween(DateRange dateRange) {
            double result = 0;
            Enumeration e = transactions.elements();
            while (e.hasMoreElements()) {
                Transaction each = (Transaction) e.nextElement();
                if (dateRange.includes(each.getDate())) {
                    result += each.getValue();
                }
            }
            return result;
        }
    }

    // New class to encapsulate start and end dates
    class DateRange {
        private Date start;
        private Date end;

        public DateRange(Date start, Date end) {
            this.start = start;
            this.end = end;
        }

        public boolean includes(Date date) {
            return date.compareTo(start) >= 0 && date.compareTo(end) <= 0;
        }
    }

    class Transaction {
        private Date chargeDate;
        private double value;

        public Transaction(double value, Date chargeDate) {
            this.value = value;
            this.chargeDate = chargeDate;
        }

        public Date getDate() {
            return chargeDate;
        }

        public double getValue() {
            return value;
        }
    }

    private void test() {
        Account account = new Account();
        DateRange dateRange = new DateRange(new Date(1050), new Date(1250));
        double flow = account.getFlowBetween(dateRange);
        System.out.println(flow);
    }

    public static void main(String[] args) {
        ParameterizeObject p = new ParameterizeObject();
        p.test();
    }
}
