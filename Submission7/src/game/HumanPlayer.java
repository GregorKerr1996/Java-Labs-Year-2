package game;

import java.util.Scanner;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public class HumanPlayer extends GamePlayer {

	Scanner s;

	/**
	 * 
	 * @param name
	 *            current players name
	 * @param s
	 *            current scanner
	 */
	public HumanPlayer(String name, Scanner s) {

		// Call the parent class to set name
		super(name);

		this.s = s;
	}

	/**
	 * User Choose symbol they wish
	 */
	@Override
	public Symbol chooseSymbol() {
		// choose symbol
		boolean validSymbol = false;
		while (validSymbol != true) {
			System.out.println("Enter a Symbol");
			String userSymbol = s.next();
			if (userSymbol.equals("ROCK")) {
				validSymbol = true;
				return Symbol.ROCK;
			} else if (userSymbol.equals("PAPER")) {
				validSymbol = true;
				return Symbol.PAPER;
			} else if (userSymbol.equals("SCISSORS")) {
				validSymbol = true;
				return Symbol.SCISSORS;
			} else if (userSymbol.equals("LIZARD")) {
				validSymbol = true;
				return Symbol.LIZARD;
			} else if (userSymbol.equals("SPOCK")) {
				validSymbol = true;
				return Symbol.SPOCK;
			}

		}
		// default rock
		return Symbol.ROCK;

	}
}