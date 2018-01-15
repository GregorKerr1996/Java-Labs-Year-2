/**
 * Starter code for JP2 lab 3. Gregor Kerr 2139619k
 */
public abstract class BrickSet {
	/** Fields */
	/** changed to public so can be accessed in subclasses */

	public int setNumber;
	public String name;
	public String theme;
	public int numPieces;

	/** Creates a new BrickSet object with the given parameters */
	public BrickSet(int setNumber, String name, String theme, int numPieces) {
		this.setNumber = setNumber;
		this.name = name;
		this.theme = theme;
		this.numPieces = numPieces;

	}

	/** Getters and setters */
	public int getSetNumber() {
		return setNumber;
	}

	public String getName() {
		return name;
	}

	public String getTheme() {
		return theme;
	}

	public int getNumPieces() {
		return numPieces;
	}

	/**
	 * Override toString() to return a nicer string representation of the BrickSet
	 */
	public String toString() {
		return setNumber + ": " + name + " (" + theme + "), " + numPieces + " pieces: current price £" + getDetails();

	}

	/**
	 * 
	 * provides string representation of the fields specific to each subclass
	 */
	protected abstract String getDetails();

}
