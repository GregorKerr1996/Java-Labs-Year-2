
public class BrickSet {

	/** the ID of this new toy */
	private int id;

	/** the name of this new toy */
	private String name;

	/** the theme of this new toy */
	private String theme;

	/** the number of pieces in this new toy */
	private int nPieces;

	/** the retail price of this new toy */
	private int retailPrice;

	/** Static field used to ensure unique toy IDs */
	private static int NEXT_ID = 0;

	/**
	 * 
	 * Creates a new toy with the given fields below and gives the toy a unique ID
	 * 
	 * @param name
	 * @param theme
	 * @param nPieces
	 * @param retailPrice
	 * 
	 * 
	 */
	public BrickSet(String name, String theme, int nPieces, int retailPrice) {

		this.name = name;
		this.theme = theme;
		this.nPieces = nPieces;
		this.retailPrice = retailPrice;
		this.id = NEXT_ID++;

	}

	/**
	 * 
	 * @return the new unique ID for the toy
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * 
	 * @return the name for the new toy
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * 
	 * @return the theme for the new toy
	 */
	public String getTheme() {
		return this.theme;
	}

	/**
	 * 
	 * @return the number of pieces in the set
	 */
	public int getnPieces() {
		return this.nPieces;
	}

	/**
	 * 
	 * @return the retail price for the new toy
	 */
	public int getRetailPrice() {
		return this.retailPrice;
	}

	/**
	 * 
	 * @param retailPrice
	 *            updates the retail price
	 */
	public void setRetailPrice(int retailPrice) {
		this.retailPrice = retailPrice;
	}

	/**
	 * 
	 * @return the price per piece by getting cost and dividing by number of pieces
	 *         returns as a double
	 */
	public double getPricePerPiece() {
		double pricePP = (this.retailPrice * 1.0) / (this.nPieces * 1.0);
		return pricePP;

	}
}