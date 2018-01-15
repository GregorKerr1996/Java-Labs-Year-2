package creditcard;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public class CreditCardMain {
	/**
	 * 
	 * @param args
	 *            takes in a string(credit card)
	 */
	public static void main(String[] args) {

		java.util.Scanner stdin = new java.util.Scanner(System.in);
		System.out.println("Enter the credit card number: ");
		String creditCard = stdin.next();

		CreditCardChecker Checker = new CreditCardChecker();
		try {
			// check if valid
			Checker.validate(creditCard);
			//catches exceptions below
			// e is error message
		} catch (IllegalCardLengthException e) {
			System.out.println(e.getMessage());

		} catch (IllegalCardFormatException e) {
			System.out.println(e.getMessage());

		}
		
		stdin.close();
	}
}
