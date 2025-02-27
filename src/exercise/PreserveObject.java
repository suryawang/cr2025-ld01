package exercise;

public class PreserveObject {
	class Room {
		private int lowest, highest;

		public Room(int lowest, int highest) {
			this.lowest = lowest;
			this.highest = highest;
		}

		// TODO: replace low & high in this withinPlan with preserve whole object
		public boolean withinPlan(HeatingPlan plan) {
			
			int low = getLowestTemp();
			int high = getHighestTemp();
			TempRange temp = new TempRange(low, high);
			return plan.withinRange(temp);
		}

		private int getHighestTemp() {
			return highest;
		}

		private int getLowestTemp() {
			return lowest;
		}

	}

	class HeatingPlan {
		private TempRange range;

		public HeatingPlan(int from, int to) {
			range = new TempRange(from, to);
		}

		public boolean withinRange(TempRange temp) {
			return (temp.low >= range.getLow() && temp.high <= range.getHigh());
		}
	}

	class TempRange {
		private int low;
		private int high;

		public TempRange(int low, int high) {
			this.low = low;
			this.high = high;
		}

		public int getLow() {
			return low;
		}

		public int getHigh() {
			return high;
		}
	}

	public static void main(String[] args) {
		PreserveObject p = new PreserveObject();
		p.test();
	}

	private void test() {
		Room r = new Room(15, 34);
		System.out.println("Within 20-30: " + r.withinPlan(new HeatingPlan(20, 30)));
		System.out.println("Within 25-34: " + r.withinPlan(new HeatingPlan(25, 34)));
		System.out.println("Within 10-40: " + r.withinPlan(new HeatingPlan(10, 40)));
	}

}
