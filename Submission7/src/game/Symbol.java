package game;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public enum Symbol {

	// Create Enum possibilites for symbol
	ROCK, PAPER, SCISSORS, LIZARD, SPOCK;

	/**
	 * 
	 * @param symbol
	 * @return The result of the game, either WIN, LOSE or DRAW (the constant values
	 *         of GameResult)
	 */

	public GameResult getResult(Symbol symbol) {

		// If both symbols are the same
		if (this == symbol) {
			return GameResult.DRAW;
		}

		// If rock is chosen, evaluate whether if it beats symbol
		if (this == ROCK) {
			if (symbol == LIZARD || symbol == SCISSORS) {
				return GameResult.WIN;

			}
		}

		// If paper is chosen, evaluate whether if it beats symbol
		if (this == Symbol.PAPER) {
			if (symbol == ROCK || symbol == SPOCK) {
				return GameResult.WIN;
			}
		}

		// If scissors is chosen, evaluate whether if it beats symbol
		if (this == SCISSORS) {
			if (symbol == PAPER || symbol == LIZARD) {
				return GameResult.WIN;

			}

		}

		// If lizard is chosen, evaluate whether if it beats symbol
		if (this == LIZARD) {
			if (symbol == SPOCK || symbol == PAPER) {
				return GameResult.WIN;
			}
		}

		// If spock is chosen, evaluate whether if it beats symbol
		if (this == SPOCK) {
			if (symbol == SCISSORS || symbol == ROCK) {
				return GameResult.WIN;
			}
		}

		// If the player does win or draw, then they lose
		return GameResult.LOSE;
	}
}