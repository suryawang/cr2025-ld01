package exercise;

public class TempToQuery {
	class Product {
		private int quantity;
		private int itemPrice;
		public Product(int quantity, int price) {
			this.quantity = quantity;
			this.itemPrice = price;
		}
		
		double basePrice(int quantity, int itemPrice) {
			return quantity * itemPrice;
		}
		
		// TODO: change this method to using replace temp with query
		public double getPrice() {
			double discountFactor;
			if (basePrice(quantity, itemPrice) > 1000) {
				discountFactor = 0.95;
				}
			else {
				discountFactor = 0.98;
				}
			return basePrice(quantity, itemPrice) * discountFactor;
		}
	}
	public void Test() {
		Product p1 = new Product(100, 200);
		Product p2 = new Product(10, 50);
		System.out.println("Price 1 = " + p1.getPrice());
		System.out.println("Price 2 = " + p2.getPrice());
	}
	public static void main(String[] args) {
		TempToQuery t = new TempToQuery();
		t.Test();
	}
}
