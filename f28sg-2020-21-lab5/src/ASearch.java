public class ASearch {

	private Entry[] catalogue;
	private int current;

	/*
	 * Assume 10 entries
	 */
	public ASearch() {
		catalogue = new Entry[10];
		current = 0;
	}

	/*
	 * Ignores adding if full (should really be handled by exception...)
	 */
	public void addEntry(Entry e) {
		if (current < 10) {
			catalogue[current++] = e;
		}
	}

	/*
	 * Part 2: complete implementation
	 */
	/**
	 * This method linearly searches through an array to determine whether a name is present and, if it is, the 
	 * number associated with that name is returned.
	 * 
	 * @param name : is the name of the person that will be looked up.
	 * @return : the number of the person if they are found.
	 */
	public int linearSearch(String name) {

		for (int i = 0; i < current; i++) {

			if (catalogue[i].getName().equals(name)) {

				return catalogue[i].getNumber();
			}
		}
		return -1;
	}

	/*
	 * Part 4: complete implementation
	 */
	/**
	 * This method searches through an array using a binary method by going into the middle of the array and then, based
	 * on the value of the given name to search, it halves the array and searches the top or bottom half.
	 * 
	 * @param first : the first indices in the array, of the new first when the array has been split in half
	 * @param last : the last value in the array, or the middle if the array has been halved.
	 * @param name : the name to search within the entrys.
	 * @return : the number associated with the name in the same entry, or -1 if there is no such entry.
	 */
	private int binarySearch(int first, int last, String name) {
		if (first > last) {
			return -1;
		} else {
			int middle = (first + last) / 2;

			if (catalogue[middle].getName().equals(name)) {
				return catalogue[middle].getNumber();
				
			} else if (catalogue[middle].getName().compareTo(name) > 0) {
				return binarySearch(first, middle - 1, name);
				
			} else {
				return binarySearch(middle + 1, last, name);
			}
		}
	}

	// helper method exposed to the programmer
	/**
	 * This method utilises the private binarySearch method so as to avoid other classes being able to access it.
	 * @param name : the name of the person to be searched
	 * @return The returned value of using the other binarySearch method
	 */
	public int binarySearch(String name) {
		return binarySearch(0, current - 1, name);
	}

}
