import java.util.ArrayList;
import java.util.Iterator;

public class ArraySort {

	/**
	 * Insertion sort of an array
	 * 
	 * @param arr the array to be sorted in-place
	 */
	public static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int cur = arr[i];
			int j = i - 1;
			while (j >= 0 && arr[j] > cur) {
				arr[j + 1] = arr[j--];
				arr[j + 1] = cur;
			}
		}
	}

	/**
	 * Insertion sort of an array
	 * 
	 * This is Question 3
	 * 
	 * This method implements the bubble sort algorithms on an array of type int.
	 * It uses a boolean called swaps that is set to true if a swap occurred inside the array. 
	 * The swap only happens when the current indexed value is larger than the one in front of it so i+1.
	 * 
	 * Swaps is set to false inside the while loop so that the while loop only keeps happening if a swap occurs.
	 * 
	 * @param arr the array to be sorted in-place
	 */
	public static void bubbleSort(int[] arr) {

		boolean swaps = true;

		while (swaps) {
			swaps = false;

			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i + 1] < arr[i]) {
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;

					swaps = true;
				}
			}
		}
	}

	// Part 5 : complete implementation
	/**
	 * This method implements the quick sort algorithms which separates one list into 3. It uses a pivot value, which in this
	 * case is the first element in the ArrayList S, as a marker for the lists created. Larger than, equal to, and greater than
	 * the pivot value.
	 * 
	 * After dividing it recursively sorts the lists.
	 * 
	 * It then adds all the sublists back into the original list in order.
	 * @param S Is the ArrayList which will be sorted using quickSort
	 * @return The fully sorted list S.
	 */
	public static ArrayList<Integer> quickSort(ArrayList<Integer> S) {

		if (S.size() <= 1) {
			return S;
		}

		int pivot = S.get(0);

		ArrayList<Integer> L = new ArrayList<>(); //less than
		ArrayList<Integer> E = new ArrayList<>(); // equal to
		ArrayList<Integer> G = new ArrayList<>(); // greater than

		while (S.size() != 0) {

			if (S.get(0) < pivot) {
				L.add(S.get(0));
				S.remove(0);
			}
			if (S.get(0) == pivot) {
				E.add(S.get(0));
				S.remove(0);
			} else if (S.get(0) > pivot) {
				G.add(S.get(0));
				S.remove(0);
			}

		}
		quickSort(L);
		quickSort(G);

		S.addAll(L);
		S.addAll(E);
		S.addAll(G);

		return S;
	}

	/**
	 * predicate to check if array is sorted
	 * 
	 * @param arr the array to be checked
	 * @return true if the array is sorted, false otherwise
	 */
	public static boolean isSorted(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++)
			if (arr[i] > arr[i + 1])
				return false;
		return true;
	}

	/**
	 * predicate to check if arrayList is sorted. Useful for checking
	 * ArrayList<Integer> lists returned from Quick Sort.
	 * 
	 * @param arr the array to be checked
	 * @return true is the aray is sorted, flalse otherwise
	 */
	public static boolean isSorted(ArrayList<Integer> arr) {
		Iterator i = arr.iterator();
		int val;
		if (i.hasNext())
			val = (int) i.next();
		else
			return true;
		while (i.hasNext()) {
			int nv = (int) i.next();
			if (val > nv)
				return false;
			val = nv;
		}
		return true;
	}

	/**
	 * Helper printing methods for testing
	 * 
	 * @param arr the array to print
	 */
	private static void printIntArray(int[] arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	private static void printIntArrayList(ArrayList<Integer> arr) {
		System.out.print("[ ");
		for (Integer i : arr) {
			System.out.print(i + " ");
		}
		System.out.println(" ]");
	}

	public static void main(String[] args) {
		// testing part1
		int[] arr1 = { 5, 4, 3, 2, 1 };
		bubbleSort(arr1);
		printIntArray(arr1);

		// testing part2
		ArrayList<Integer> arr2 = new ArrayList<Integer>();
		arr2.add(3);
		arr2.add(1);
		arr2.add(6);
		arr2.add(5);
		ArrayList<Integer> arr2_sorted = quickSort(arr2);
		printIntArrayList(arr2_sorted);
		// {5,4,3,5,1};

	}

}
