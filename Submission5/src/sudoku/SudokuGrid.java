package sudoku;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public class SudokuGrid {
	// create public variables including the 2D grid Array
	public String filename;
	public int[][] gridArray;

	/**
	 * 
	 * @param filename
	 *            takes in the grid files
	 * @throws IOException
	 *             THrows IOException if filename causes an exception
	 */

	public SudokuGrid(String filename) throws IOException {
		// sets new grid array with given dimensions (9x9)
		gridArray = new int[Utils.SIZE][Utils.SIZE];
		int position = 0;
		// loads file and stores it as string
		String input = Utils.loadGrid(filename);
		// splits string and removes whitespace and saves as values
		String[] values = input.split(",", 81);

		for (int i = 0; i < 9; i++) {
			for (int pos = 0; pos < 9; pos++) {
				// if value is not 0 parse it to an integer
				// if not make 0
				gridArray[i][pos] = (values[position].length() > 0) ? Integer.parseInt(values[position]) : 0;
				// increment position
				position++;

			}
		}

	}

	/**
	 * 
	 * @return VALID,INCOMPLETE or INVALID depending on outcome
	 */
	public String check() {
		// creates an empty array list for each row
		// if number is already in list then return invalid
		// if number is not in list then add it to the list

		// checks row validity
		for (int row = 0; row < Utils.SIZE; row++) {
			List<Integer> check = new ArrayList<Integer>();
			for (int col = 0; col < Utils.SIZE; col++) {
				if (gridArray[row][col] == 0) {
					continue;
				}
				// if already in list returns invalid
				if (check.contains(gridArray[row][col])) {
					return Utils.INVALID;
				} else {
					// adds to array list
					check.add(gridArray[row][col]);
				}
			}

		}

		// checks column validity
		// similar to above but checks columns instead of rows for repeated numbers
		for (int row = 0; row < Utils.SIZE; row++) {
			List<Integer> check = new ArrayList<Integer>();
			for (int col = 0; col < Utils.SIZE; col++) {
				if (gridArray[col][row] == 0) {
					continue;
				}
				if (check.contains(gridArray[col][row])) {
					return Utils.INVALID;
				} else {
					check.add(gridArray[col][row]);
				}
			}

		}

		// 3x3 check
		for (int row = 0; row < Utils.SIZE; row += 3) {

			for (int col = 0; col < Utils.SIZE; col += 3) {

				List<Integer> checklist = new ArrayList<Integer>();
				// adds current value in gridAray to checkList
				checklist.add(gridArray[row][col]);
				checklist.add(gridArray[row + 1][col]);
				checklist.add(gridArray[row + 2][col]);
				checklist.add(gridArray[row][col + 1]);
				checklist.add(gridArray[row + 1][col + 1]);
				checklist.add(gridArray[row + 2][col + 1]);
				checklist.add(gridArray[row][col + 2]);
				checklist.add(gridArray[row + 1][col + 2]);
				checklist.add(gridArray[row + 2][col + 2]);

				List<Integer> tempList = new ArrayList<Integer>();

				for (int pos = 0; pos < Utils.SIZE; pos++) {
					// If value = 0 then continue so it adds to list
					if (checklist.get(pos) == 0) {
						continue;
					}
					// if the tempory list contains the value in checklist
					// then return invlaid

					if (tempList.contains(checklist.get(pos))) {
						return Utils.INVALID;
					} else {
						// add current value to the tempory list
						tempList.add(checklist.get(pos));
					}
				}
			}
		}

		// checks if any number in grid is less than or equal to 0
		// if so then returns incomplete
		for (int row = 0; row < Utils.SIZE; row++) {
			for (int col = 0; col < Utils.SIZE; col++) {
				if (gridArray[row][col] <= 0) {
					return Utils.INCOMPLETE;
				}
			}
		}

		// if passes all the above then return valid
		return Utils.VALID;

	}

	// this function converts the array into a nice string formatted display
	@Override
	public String toString() {
		String aa = "";
		String bb = "";
		for (int row = 0; row < gridArray.length; row++) {
			for (int column = 0; column < gridArray[row].length; column++) {
				// takes integers and converts to string
				aa = Integer.toString(gridArray[row][column]);
				// concat strings
				bb = bb + aa;
			}
		}
		bb = bb + "\n";
		// add a new line comment after every 9 characters
		String newString = bb.replaceAll("(.{9})(?!$)", "$1\n");
		// returns the nice new formatted string
		return newString;
	}
}
