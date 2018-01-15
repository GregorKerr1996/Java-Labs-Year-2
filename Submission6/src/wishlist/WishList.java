package wishlist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public class WishList {

	ArrayList<BrickSet> temp;

	public WishList() {
		// creates new array list called temp
		temp = new ArrayList<BrickSet>();

	}

	/**
	 * 
	 * @return a sorted wish list
	 */
	public Collection<BrickSet> getSets() {
		// sorts list
		Collections.sort(temp);

		return temp;

	}

	/**
	 * 
	 * @param set
	 * @return false if set is already in the list if not in list, add set to list
	 *         and return true
	 */
	public boolean addSet(BrickSet set) {
		// check if set in list
		if (temp.contains(set)) {
			return false;

		} else {
			// adds set to list
			temp.add(set);
		}

		return true;

	}

	/**
	 * 
	 * @param set
	 * @return false if set is not in the list, if in list , set is removed and
	 *         returns true
	 */
	public boolean removeSet(BrickSet set) {
		// check is set in list
		if (temp.contains(set)) {
			// removes set from list
			temp.remove(set);
			return true;
		}

		return false;
	}

	/**
	 * 
	 * @param filename
	 * @throws IOException
	 *             if file can't be loaded
	 * 
	 *             saves the current wish list to filename
	 */
	public void saveToFile(String filename) throws IOException {

		PrintWriter pw = new PrintWriter(new FileWriter(filename));
		for (BrickSet line : temp) {
			// adds to file
			pw.append(line.toString());
			// adds a new line
			pw.append("\n");
		}

		pw.close();

	}

	/**
	 * 
	 * @param filename
	 * @return the wish list
	 * @throws IOException
	 *             if file can't be loaded
	 * 
	 *             loades a wish list from file and returns it
	 */
	public static WishList loadFromFile(String filename) throws IOException {

		WishList temp = new WishList();
		// read in file
		FileReader in = new FileReader(filename);
		BufferedReader br = new BufferedReader(in);
		String line;
		while ((line = br.readLine()) != null) {
			// loops through each line in file
			for (int i = 0; i < line.length(); i++) {
				// splits by comma's
				String[] wishList = line.split(",");
				// loops through wishlist
				for (String s : wishList) {
					// get variables to create a new brickset
					String setNumber = wishList[0];
					String name = wishList[1];
					String theme = wishList[2];

					String numPieces = wishList[3];

					String retailPrice = wishList[4];
					// change strings to int so can be passed
					int nSetNum = Integer.parseInt(setNumber);
					int nNumPieces = Integer.parseInt(numPieces);
					int nRetailprice = Integer.parseInt(retailPrice);
					// create brickset and store in list
					temp.addSet(new BrickSet(nSetNum, name, theme, nNumPieces, nRetailprice));

				}

			}

		}
		// close buffered reader
		br.close();
		// close file reader
		in.close();

		return temp;
	}
}
