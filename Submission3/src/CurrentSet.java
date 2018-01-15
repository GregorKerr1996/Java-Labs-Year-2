/**
 * 
 * @author 2139619k Gregor Kerr
 */
public class CurrentSet extends BrickSet {
	/**
	 * set to private so can only be accessed in this subclass
	 */
	private int retailPrice;

	public CurrentSet(int setNumber, String name, String theme, int numPieces, int retailPrice) {
		/**
		 * Calls public and protected methods in super class(BrickSet)
		 */
		super(setNumber, name, theme, numPieces);

		/**
		 * used as a reference to the current object
		 */
		this.retailPrice = retailPrice;

	}

	public int getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(int retailPrice) {
		this.retailPrice = retailPrice;
	}

	/**
	 * 
	 * @return price per piece as a double
	 */
	public double getPricePerPiece() {
		return (double) retailPrice / numPieces;
	}

	public String getDetails() {

		return retailPrice + "";

	}
}
