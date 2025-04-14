package exercise;
import java.util.Enumeration;

public class ExtractMethod {
    public static void main(String[] args) {
        ExtractMethod test = new ExtractMethod("Andi");
        test.printOwing();
    }

    private Order orders;
    private String name;

    public ExtractMethod(String name) {
        this.name = name;
        this.orders = new Order();
    }

    public String getName() {
        return name;
    }

    void printOwing() {
        printBanner();
        double outstanding = calculateOutstanding();
        printDetails(outstanding);
    }

    private void printBanner() {
        System.out.println("*****************************");
        System.out.println("****** Customer totals ******");
        System.out.println("*****************************");
    }

    private double calculateOutstanding() {
        double outstanding = 0.0;
        Enumeration<Order> elements = orders.elements();
        while (elements.hasMoreElements()) {
            outstanding += elements.nextElement().getAmount();
        }
        return outstanding;
    }

    private void printDetails(double outstanding) {
        System.out.println("name: " + name);
        System.out.println("amount: " + outstanding);
    }

    class Order implements Enumeration<Order> {
        private double[] amounts;
        private int currentIndex;

        public Order() {
            amounts = new double[]{12.0, 2.5, 3.2, 7.05, 6.0};
            currentIndex = 0;
        }

        @Override
        public boolean hasMoreElements() {
            return currentIndex < amounts.length;
        }

        @Override
        public Order nextElement() {
            return new Order(amounts[currentIndex++]);
        }

        private double amount;

        private Order(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }

        public Enumeration<Order> elements() {
            return new OrderEnumeration();
        }

        private class OrderEnumeration implements Enumeration<Order> {
            private int index = 0;

            @Override
            public boolean hasMoreElements() {
                return index < amounts.length;
            }

            @Override
            public Order nextElement() {
                return new Order(amounts[index++]);
            }
        }
    }
}
