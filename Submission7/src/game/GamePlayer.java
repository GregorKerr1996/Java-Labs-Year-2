package game;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public abstract class GamePlayer {

	String name;

	// Create lists to store players symbols
	List<Symbol> otherPlayer = new ArrayList<Symbol>();
	List<Symbol> computerPlayer = new ArrayList<Symbol>();

	/**
	 * 
	 * @param name
	 *            Constructor used to get and set the players name
	 */

	public GamePlayer(String name) {
		this.name = name;
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @return name The current players name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @param name
	 *            Set the players name to current one
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param player1Symbol
	 *            Symbol used by Player 1 during game
	 * @param player2Symbol
	 *            Symbol used by Player 2 during game
	 */
	public void addHistory(Symbol player1Symbol, Symbol player2Symbol) {

		// Add players symbols to each list
		computerPlayer.add(player1Symbol);
		otherPlayer.add(player2Symbol);
	}

	/**
	 * 
	 * @return Symbol This is an abstract class so the value will be overridden in
	 *         subclasses
	 */
	public abstract Symbol chooseSymbol();

}