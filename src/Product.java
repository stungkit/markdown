public class Product {
	private static final int MAX_OUNCE = 8;
	private static final double FIRST_CLASS_BASE = 0.98;
	private static final double FIRST_CLASS_RATE = 0.22;
	private static final double MEDIA_BASE = 2.72;
	private static final double MEDIA_RATE = 0.5;
	private static final double AMAZON_FEE = 0.07;

	private String name, asin;
	private double weight; // positive = pounds, negative = ounces
	private double shippingRate;

	public Product() {
		// empty code block
	}

	public Product(String name, String asin, double weight) {
		this.name = name;
		this.asin = asin;
		this.weight = weight;
		this.shippingRate = calculateShippingRate(weight);
	}

	public static double calculateShippingRate(double weight) {
		if (weight >= 0.0) {
			int lbs = (int) Math.round(Math.ceil(weight));
			return MEDIA_BASE + (lbs - 1) * MEDIA_RATE + AMAZON_FEE;
		} else {
			int oz = (int) Math.round(Math.ceil(-weight));
			if (oz > MAX_OUNCE) {
				return MEDIA_BASE + AMAZON_FEE;
			} else {
				return FIRST_CLASS_BASE + (oz - 1) * FIRST_CLASS_RATE
						+ AMAZON_FEE;
			}
		}
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setASIN(String asin) {
		this.asin = asin;
	}

	public void setWeight(double weight) {
		this.weight = weight;
		this.shippingRate = calculateShippingRate(weight);
	}

	public String getName() {
		return name;
	}

	public String getASIN() {
		return asin;
	}

	public double getWeight() {
		return weight;
	}

	public double getShippingRate() {
		return shippingRate;
	}
	
	@Override
	public String toString() {
		return name + ": " + asin;
	}
}
