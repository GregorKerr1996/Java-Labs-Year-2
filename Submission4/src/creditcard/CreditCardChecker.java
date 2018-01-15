package creditcard;

/**
 * 
 * @author 2139619k Gregor Kerr Assessment exercise 4
 *
 */
public class CreditCardChecker {
	/**
	 * 
	 * @param cardNo
	 *            this is the credit card number as a string to be checked
	 * @return true or false depending on if card is valid or not
	 * @throws IllegalCardLengthException
	 *             if the card length is invalid
	 * @throws IllegalCardFormatException
	 *             if the card format is invalid
	 */
	public boolean validate(String cardNo) throws IllegalCardLengthException, IllegalCardFormatException {
		// checks initial valid lengths
		if (cardNo.length() < 13 || cardNo.length() > 19) {
			// throws exception as card length is invalid
			throw new IllegalCardLengthException("Invalid card length of " + cardNo.length());
		}
		// checks for no characters in string
		for (int i = 0; i < cardNo.length(); i++) {
			if (Character.isDigit(cardNo.charAt(i)) == false) {
				// throws exception as char has been found is invalid
				throw new IllegalCardFormatException("Illegal Character: " + cardNo.charAt(i));
			}
		}

		// set valid len to true
		// change if card len is not valid
		boolean validLen = true;
		while (!validLen) {

			// check if credit card is American express
			if (cardNo.startsWith("34") || cardNo.startsWith("37")) {
				// if = 15 is valid
				validLen = (cardNo.length() == 15);

				// check if credit card is visa
			} else if (cardNo.startsWith("4")) {
				// if = 13 or 16 or 19 is valid
				validLen = (cardNo.length() == 13 || cardNo.length() == 16 || cardNo.length() == 19);

				// check if credit card is master card
			} else if (cardNo.startsWith("5")) {

				// check if between required range
				int checkNum = Integer.valueOf(cardNo.substring(0, 2));
				if (checkNum >= 51 && checkNum <= 55) {
					// if length is 16 is valid
					validLen = (cardNo.length() == 16);
				}

				// else card length is not valid
				else {
					validLen = false;
				}
			}

		}
		// luhn algorithm
		// checks if string id divisible by 10 with no remainders this is a valid
		// card if not then not valid
		int sum = 0;
		boolean alternate = false;
		for (int i = cardNo.length() - 1; i >= 0; i--) {
			int n = Integer.parseInt(cardNo.substring(i, i + 1));
			// operates on alternative numbers (every second)
			if (alternate) {
				n *= 2;
				if (n > 9) {
					n = (n % 10) + 1;
				}
			}
			sum += n;
			alternate = !alternate;
		}
		// checks if divisible by 10
		if (sum % 10 == 0) {
			return true;
		} else {
			return false;
		}

	}

}
