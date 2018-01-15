public class CreditCardChecker {
	public static void main(String[] args) {

		java.util.Scanner stdin = new java.util.Scanner(System.in);
		System.out.println("Enter the credit card number: ");
		String creditCard = stdin.next();

		// if card length less than 2 then is invalid for substring purposes
		if (creditCard.length() < 2) {
			System.out.println("Unknown Card Type");
			System.exit(0);
		}
		// takes first character and first 2 characters and saves under variable names
		String oneDigit = creditCard.substring(0, 1);
		String twoDigit = creditCard.substring(0, 2);
		// parse string to integer so can be used in if and Switch Statements
		int fNum = Integer.parseInt(oneDigit);
		int tNum = Integer.parseInt(twoDigit);
		// set boolean to true to make sure it loops atleast once until state is
		// changed
		boolean validCard = true;

		if (validCard) {
			if (fNum == 4) {
				visaCheck(creditCard);
			} else {
				// switch statement on first 2numbers
				// aside
				// multiple if statement's could have been used with multiple
				// or's (||)
				// however as getting taught switch so used this for my own
				// benefit
				switch (tNum) {
				case 34:
					aExpressCheck(creditCard);
					break;
				case 37:
					aExpressCheck(creditCard);
					break;
				case 51:
					mCardCheck(creditCard);
					break;
				case 52:
					mCardCheck(creditCard);
					break;
				case 53:
					mCardCheck(creditCard);
					break;
				case 54:
					mCardCheck(creditCard);
					break;
				case 55:
					mCardCheck(creditCard);
					break;
				default:
					System.out.println("Invalid number");
					break;
				}
				// no valid card so set to false
				validCard = false;
			}
		}
		// no valid numbers, exit program
		if (validCard = false) {
			System.out.println("Unknown Card Type");
			System.exit(0);
		}
		stdin.close();
	}

	/**
	 * 
	 * @param creditCard
	 *            card number passed in from main and checked for valid length if
	 *            valid pass it on to luhn algorithm
	 * @return
	 */
	public static void visaCheck(String creditCard) {
		System.out.println("Visa");
		int cardLen = creditCard.length();
		// System.out.println(cardLen);

		if (cardLen == 13 || cardLen == 16 || cardLen == 19) {
			LuhnAlg(creditCard);
		}

		else {
			exitProgram();
		}
	}

	/**
	 * 
	 * @param creditCard
	 *            card number passed in from main and checked for vaild length if
	 *            valid pass it on to luhn algorithm
	 */
	public static void aExpressCheck(String creditCard) {
		System.out.println("American Express");
		int cardLen = creditCard.length();
		// System.out.println(cardLen);

		if (cardLen == 15) {
			LuhnAlg(creditCard);
		}

		else {
			exitProgram();
		}

	}

	/**
	 * 
	 * @param creditCard
	 *            card number passed in from main and checked for vaild length if
	 *            valid pass it on to luhn algorithm
	 */
	public static void mCardCheck(String creditCard) {
		System.out.println("Master Card");
		int cardLen = creditCard.length();
		// System.out.println(cardLen);

		if (cardLen == 16) {
			LuhnAlg(creditCard);
		}

		else {
			exitProgram();
		}

	}

	/**
	 * 
	 * @param creditCard
	 *            credit card is passed and luhn algorithm is tested if matches
	 *            criteria and is divisible by 10 with no remainders this is a valid
	 *            card if not then not valid is displayed
	 */
	public static void LuhnAlg(String creditCard) {
		int sum = 0;
		boolean alternate = false;
		for (int i = creditCard.length() - 1; i >= 0; i--) {
			int n = Integer.parseInt(creditCard.substring(i, i + 1));
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
			System.out.println("Valid");
		} else {
			System.out.println("Not valid");
		}

	}
	// valid card to check when testing
	// 371449635398431

	/**
	 * method for exiting program instead of repetitive code
	 */
	public static void exitProgram() {
		System.out.println("Invalid");
		System.exit(0);

	}
}