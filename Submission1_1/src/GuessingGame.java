/**
 * Starter code for JP2 Laboratory 1, Submission 1.
 * 
 * @author Mary Ellen Foster <MaryEllen.Foster@glasgow.ac.uk>
 *
 */

public class GuessingGame {
	public static void main(String[] args) {
		// Initialise the scanner and choose the target value (a random number between 1
		// and 20)
		java.util.Scanner stdin = new java.util.Scanner(System.in);
		int target = 1 + (int) (Math.random() * 20);

		// Put your solution to Submission 1 here
		int guess = 0;
		boolean found = false;
		int c = 0;

		while (found != true) {
			System.out.println("Please enter your guess between 1 and 20");
			guess = stdin.nextInt();
			// condition to compare guess with target
			while (guess > 0 && guess <= 20) {
				if (guess < target) {
					System.out.println("Too Low!");
					c++;
					break;
				} else if (guess > target) {
					System.out.println("Too High");
					c++;
					break;
				} else if (guess == target) {
					System.out.println("Just right");
					c++;
					found = true;
					break;
				}

			}
		}
		// display guesses took
		System.out.println("You took" + c + " guesses");
		stdin.close();
	}
}
