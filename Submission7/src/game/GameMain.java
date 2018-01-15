package game;

import java.util.Scanner;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public class GameMain {

	/**
	 * asks the users for the tournament paramters and with that information runs
	 * the tournament
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// read in user input
		Scanner stdin = new Scanner(System.in);

		// set first player to computer
		GamePlayer player1 = new ComputerPlayer("Computer");

		// second player may be a human or a computer
		GamePlayer player2;
		System.out.println("Enter name of human player, or empty string for two computer players");
		String name = stdin.nextLine();
		if (name.length() == 0) {
			System.out.println("Using two computer players");
			player2 = new ComputerPlayer("Computer2");
		} else {
			player2 = new HumanPlayer(name, stdin);
		}

		// checks if positive integer. if yes then that is the number of games
		// required to win
		int numGames = -1;
		while (numGames <= 0) {
			System.out.println("Enter number of games to win: ");
			try {
				numGames = stdin.nextInt();
			} catch (NumberFormatException ex) {
				System.out.println("Invalid input!");
			}
			if (numGames <= 0) {
				System.out.println("Invalid input!");
			}
		}

		// Run the tournament with the given parameters
		GamePlayer winner = playTournament(player1, player2, numGames);

		System.out.println("------------------");
		System.out.println("Overall winner is: " + winner.getName());

		stdin.close();
	}

	/**
	 * 
	 * @param player1
	 *            this is the computer player
	 * @param player2
	 *            this is the Computer or human player
	 * @param numGames
	 *            this is the Number of games to win
	 * @return The winning player
	 */

	private static GamePlayer playTournament(GamePlayer player1, GamePlayer player2, int numGames) {

		int games = 0;
		int player1Score = 0;
		int player2Score = 0;

		// While the players scores do not match the value to win, iterate through loop
		while ((player1Score < numGames) && (player2Score < numGames)) {

			// Get players symbol
			Symbol player1Symbol = player1.chooseSymbol();
			Symbol player2Symbol = player2.chooseSymbol();

			// Print out symbols chosen
			System.out.println(player1.getName() + " chose the symbol : " + player1Symbol);
			System.out.println(player2.getName() + " chose the symbol : " + player2Symbol);

			// Call addHistory method to add players symbols
			// GamePlayer.addHistory(player1Symbol, player2Symbol)

			// Determine the result of the game
			GameResult result = player1Symbol.getResult(player2Symbol);

			// Add 1 to score of the player that won and display this or play next game if a
			// draw
			if (result == GameResult.WIN) {
				player1Score++;
				System.out.println("The winner of this game is" + player1.getName());
			} else if (result == GameResult.LOSE) {
				player2Score++;
				System.out.println("The winner of this game is" + player2.getName());
			} else {
				System.out.println("The game is a draw, please choose another symbol");
				continue;
			}

			// output tournament score
			System.out.println(player1Score + " : " + player2Score);

		}

		// Find which user has won and return the player
		if (player1Score == numGames) {
			return player1;
		} else
			return player2;

	}
}