package creditcard;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public class IllegalCardLengthException extends Exception {
	/**
	 * 
	 * @param message
	 *            takes in a message as a string which will give user indication
	 *            that the credit card length is invalid
	 */
	public IllegalCardLengthException(String message) {
		super(message);
	}

}
