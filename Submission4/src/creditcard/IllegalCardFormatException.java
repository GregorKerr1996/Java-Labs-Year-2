package creditcard;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public class IllegalCardFormatException extends Exception {
	/**
	 * 
	 * @param message
	 *            takes in a message in form of a string which will give user
	 *            indication that credit card format is invalid
	 */
	public IllegalCardFormatException(String message) {
		super(message);
	}
}
