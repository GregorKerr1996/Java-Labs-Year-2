package game;

import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 
 * Author 2139619k Gregor Kerr
 *
 */
public class ComputerPlayer extends GamePlayer {

	/**
	 * 
	 * @param name
	 *            The computer players name
	 */
	public ComputerPlayer(String name) {

		// Call the parent class to set name
		super(name);
	}

	String[] randomSymbols = { "ROCK", "PAPER", "SCISSORS", "LIZARD", "SPOCK" };

	/**
	 * @return the computers chosen symbol
	 */
	public Symbol chooseSymbol() {

		// public Symbol chooseSymbol() throws IllegalArgumentException {

		// create a map where key is symbol and value is frequency
		Map<Symbol, Long> frequencyMap = otherPlayer.stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));

		Long greatestFrequency = 1L;
		Symbol frequentSymbol = null;

		// find most frequent symbol
		for (Map.Entry<Symbol, Long> entry : frequencyMap.entrySet()) {
			if (entry.getValue() > 1) {
				if (entry.getValue() > greatestFrequency) {
					greatestFrequency = entry.getValue();
					frequentSymbol = entry.getKey();
				}
			}
		}
		if (frequentSymbol != null) {
			switch (frequentSymbol) {
			case ROCK:
				return Symbol.PAPER;
			case PAPER:
				return Symbol.SCISSORS;
			case SCISSORS:
				return Symbol.ROCK;
			case LIZARD:
				return Symbol.SCISSORS;
			case SPOCK:
				return Symbol.PAPER;
			default:
				return null;
			}
		} else { // return a random symbol
			Random rand = new Random();
			int i = rand.nextInt(4) + 0;
			return Symbol.valueOf(randomSymbols[i]);
		}
	}
}