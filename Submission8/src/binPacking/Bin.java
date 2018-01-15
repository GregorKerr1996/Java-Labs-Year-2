package binPacking;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author 2139619k Gregor Kerr
 *
 */
public class Bin {

	List<Integer> weights = new ArrayList<Integer>();
	int capacity;

	/**
	 * 
	 * @param binCapacity
	 *            capacity of this bin instance
	 */
	public Bin(int binCapacity) {
		this.capacity = binCapacity;
	}

	/**
	 * 
	 * @param weight
	 *            weight to be added to Bin
	 * @throws IllegalArgumentException
	 *             if weight can't fit, throw exception
	 */
	public void store(int weight) throws IllegalArgumentException {
		// gets remaining space
		int remainingSpace = getSpace();

		if (weight <= remainingSpace) {
			// adds weight to space
			weights.add(weight);
		} else {
			throw new IllegalArgumentException();
		}
	}

	/**
	 * 
	 * @return the remaining space in bin
	 */
	public int getSpace() {

		int remainingSpace;
		int total = 0;

		if (weights.size() == 0) {
			return this.capacity;
		} else {
			for (int i = 0; i < weights.size(); i++) {
				
				total += weights.get(i);
			}
			// take away total of weights from capacity of this current bin
			remainingSpace = this.capacity - total;

			return remainingSpace;

		}
	}

	/**
	 * returns the same integer consistently
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + capacity;
		result = prime * result + ((weights == null) ? 0 : weights.hashCode());
		return result;
	}

	/**
	 * determines if two objects are equal
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bin other = (Bin) obj;
		if (capacity != other.capacity)
			return false;
		if (weights == null) {
			if (other.weights != null)
				return false;
		} else if (!weights.equals(other.weights))
			return false;
		return true;
	}
}