package binPacking;

import java.util.List;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public class BinPackingProblem implements Runnable {

	private final int maxCapacity;
	private final List<Integer> currentWeights;
	private static List<Bin> currentBin;

	/**
	 * 
	 * @param weights
	 *            weight to be added to bin
	 * @param capacity
	 *            capacity of bin
	 */
	public BinPackingProblem(List<Integer> weights, int capacity) {

		currentWeights = weights;
		maxCapacity = capacity;

	}

	/**
	 * run method for current bin
	 */
	@Override
	public void run() {

		currentBin = PackingStrategy.packBestFit(currentWeights, maxCapacity);
		// TODO Auto-generated method stub

	}

	/**
	 * 
	 * @return current Bin
	 */
	public static List<Bin> getBins() {
		// TODO Auto-generated method stub
		return currentBin;
	}

}
