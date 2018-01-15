/**
 * 
 * @author 2139619k Gregor Kerr
 */
public class RetiredSet extends BrickSet {
	/**
	 * set to private so can only be accessed in this subclass
	 */
	private int retiredYear;

	public RetiredSet(int setNumber, String name, String theme, int numPieces, int retiredYear) {
		/**
		 * Calls public and protected methods in super class(BrickSet)
		 */
		super(setNumber, name, theme, numPieces);
		/**
		 * used as a reference to the current object
		 */
		this.retiredYear = retiredYear;

	}

	/**
	 * 
	 * @return retired Year
	 */
	public int getRetiredYear() {
		return retiredYear;

	}

	/**
	 * returns retired year as a string representation
	 */
	protected String getDetails() {
		return retiredYear + "";

	}
}