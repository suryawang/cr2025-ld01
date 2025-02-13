package long_parameter_list;

public class MethodCall {
	class Store{
		double getSeasonalDiscount() {
			return 1.0;
		}
		double getFees() {return 2.0;}
	}
	void test() {
		int quantity =10;
		int itemPrice = 20;
		Store store = new Store();
		int basePrice = quantity * itemPrice;
		double seasonDiscount = store.getSeasonalDiscount();
		double fee = store.getFees();
		double total = discountedPrice(basePrice, seasonDiscount, fee);
		
		double newTotal = discountedPrice(basePrice, store);
	}
	double discountedPrice(int basePrice, double seasonDiscount, double fee) {
		return basePrice - (basePrice*seasonDiscount) + fee;
	}
	double discountedPrice(int basePrice, Store store) {
		return basePrice - (basePrice*store.getSeasonalDiscount()) + store.getFees();
	}

}
