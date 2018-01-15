/**
 * Starter code for JP2 Laboratory 1, Submission 2.
 * 
 * @Grgeor Kerr 2139619K
 * @author Mary Ellen Foster <MaryEllen.Foster@glasgow.ac.uk>
 *
 */
public class GuessingGame2 {

	public static void main(String[] args) {
	
		// Initialise the scanner
		java.util.Scanner stdin = new java.util.Scanner(System.in);

		// Put your solution to Submission 2 here
		// initilise all local variables
		int guess = 0;
		int maxGuess = 0;
		int maxNum = 0;
		boolean found = false;
		int c = 0;
		int zero = 0;

		System.out.println("Enter maximum number(limit)");
		maxNum = stdin.nextInt();
		System.out.println("Eneter maximum number of guesses");
		maxGuess = stdin.nextInt();
		// Randomise number using users defined limit
		int target = 1 + (int) (Math.random() * maxNum);

		while (found != true && maxGuess != zero) {
			System.out.println("enter your guess");
			guess = stdin.nextInt();
			// increase counter
			c++;
			// compares guess and continue's on conditions
			if (guess < 1 || guess > maxNum) {
				System.out.println("Out of range!");
			}

			if (guess < target) {
				System.out.println("Too Low!");
				// reduced guess limit by 1
				maxGuess--;
				continue;

			} else if (guess > target) {
				System.out.println("Too High");

				maxGuess--;
				continue;

			} else if (guess == target) {
				System.out.println("Just right");
				found = true;
				System.out.println("You took " + c + " guesses");
				break;
			}
		}
		// statement if max guesses reached
		// display guesses took/ target num

		if (maxGuess == zero) {
			System.out.println("You used up all your Guesses, the correct answer is " + target + "");
			System.out.println("You took " + c + " guesses");
		}

		// Close the scanner
		stdin.close();
	}
}
