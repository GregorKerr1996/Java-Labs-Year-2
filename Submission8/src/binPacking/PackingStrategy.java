package binPacking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public class PackingStrategy {
	/**
	 * 
	 * @param weights
	 *            weights to be allocated to Bins
	 * @param capacity
	 *            capacity of bins
	 * @return what's in bin as a list
	 */
	public static List<Bin> packBestFit(List<Integer> weights, int capacity) {
		// sort weights in reverse order
		Collections.sort(weights, Collections.reverseOrder());

		List<Bin> binList = new ArrayList<Bin>();
		// check if bin is empty
		if (binList.isEmpty()) {
			Bin firstBin = new Bin(capacity);
			// add to binList
			binList.add(firstBin);
		}
		// iterate through weights
		for (int weight : weights) {

			boolean fits = false;
			int minBinDif = capacity;
			Bin binToAdd = null;
			// iterate through bins
			for (Bin b : binList) {
				// if bin has space and can fit weight
				if (b.getSpace() - weight >= 0 && b.getSpace() - weight < minBinDif) {

					minBinDif = b.getSpace() - weight;
					binToAdd = b;
					fits = true;
				}

			}
			// if weight doesnt fit, add to binList
			if (!fits) {

				binToAdd = new Bin(capacity);
				binToAdd.store(weight);
				binList.add(binToAdd);

			}

			else {
				// if weight fits, store weight
				binToAdd.store(weight);
			}
		}

		return binList;
	}

	/**
	 * 
	 * @param weights
	 *            weights to be allocated to Bins
	 * @param capacity
	 *            capacity of bins
	 * @param numThreads
	 *            number of threads to split program into
	 * @return
	 */
	public static List<Bin> packBestFitParallel(List<Integer> weights, int capacity, int numThreads) {
		// TODO Auto-generated method stub

		int numItems = 0;

		// increment number of items per weight size
		for (int i = 0; i < weights.size(); i++) {
			numItems++;
		}

		int itemPerBin = weights.size() / numThreads;
		// iterate through threads
		for (int j = 0; j < numThreads; j++) {

			List<Integer> tempBin = new ArrayList<Integer>();
			// iterate through number of items
			for (int k = 0; k < numItems; k++) {
				// iterate through each item in the bin
				for (int l = 0; l < itemPerBin; l++) {
					tempBin.add(weights.get(l));
				}
			}
			// new thread
			Thread t = new Thread(new BinPackingProblem(tempBin, capacity));
			// start thread
			t.start();

			try {
				// join threads
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}

		List<Bin> bins = new ArrayList<Bin>();
		// get all bins
		bins = BinPackingProblem.getBins();
		return bins;
	}
}