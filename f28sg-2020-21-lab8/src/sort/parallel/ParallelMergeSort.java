package sort.parallel;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import sort.sequential.SequentialMergeSort;
import sort.sequential.SortingCommon;
import utils.Benchmark;

/*
 * Merge Sort results
 * ~~~~~~~~~~~~~~~~~~
 * 
 * Before parallelisation: TODO
 * - 1 threads	runtime=3236ms	
 * - 2 threads	runtime=2972ms	
 * - 4 threads	runtime=2833ms	
 * - 8 threads	runtime=2811ms
 * 
 * After parallelisation: TODO
 * - 1 threads	runtime=3305ms
 * - 2 threads	runtime=2458ms
 * - 4 threads	runtime=2230ms
 * - 8 threads	runtime=2328ms
 */

public class ParallelMergeSort extends RecursiveTask<LinkedList<Integer>> {
	LinkedList<Integer> arr;

	public ParallelMergeSort(LinkedList<Integer> arr) {
		this.arr = arr;
	}

	/**
	 *This method computes and does the majority of the work in merge sorting a Linked List.
	 *It has a base case where the length of the list is less than 2, and a recursive block in the else statement.
	 *
	 *
	 *return : The sorted list.
	 */
	@Override
	protected LinkedList<Integer> compute() {
		int length = arr.size();
		// base case
		if (length < 2) {
			return arr;
		}
		// step case
		else {
			/* compute the size of the two sub arrays */
			int halfSize = length / 2;

			/* declare these as `left` and `right` arrays */
			LinkedList<Integer> left = new LinkedList<Integer>();
			LinkedList<Integer> right = new LinkedList<Integer>();

			/* populate the left array with values */
			Iterator<Integer> it = arr.iterator();
			int index = 0;
			while (index < halfSize) {
				left.add(it.next());
				index++;
			}

			/* populate the right array with values */
			index = 0;
			while (index < length - halfSize) {
				right.add(it.next());
				index++;
			}

			/*
			 * Q1A: profile this sequential implementation.
			 * 
			 * Q1B: replace this with a parallel fork/join approach.
			 */
			// LinkedList<Integer> resultLeft = SequentialMergeSort.mergeSort(left);
			// LinkedList<Integer> resultRight = SequentialMergeSort.mergeSort(right);

			//This creates a new Instance of the ParallelMergeSort class using the linked list provided
			//The same is done for the other half of the list in resultRight
			ParallelMergeSort resultLeft = new ParallelMergeSort(left);
			
			//
			ParallelMergeSort resultRight = new ParallelMergeSort(right);

			resultLeft.fork(); //This forks the list that has been assigned to the left.

			LinkedList<Integer> sortedRight = resultRight.compute(); //this recursively computes the right list to sort it.

			//
			LinkedList<Integer> sortedLeft = resultLeft.join(); //this waits for the result from the fork above then assigns it to sortedLeft.

			/* merge the sorted sub arrays */
			return merge(sortedLeft, sortedRight);
		}

	}

	// to assist mergeSort
	public static LinkedList<Integer> merge(LinkedList<Integer> left, LinkedList<Integer> right) {
		int lindex = 0;
		int rindex = 0;
		LinkedList<Integer> mergedList = new LinkedList<Integer>();

		/*
		 * step 1: compare elementwise left and right lists and write the smaller of the
		 * two values into the mergedList list
		 */
		while (lindex < left.size() && rindex < right.size()) {
			if (left.get(lindex) <= right.get(rindex)) {
				mergedList.add(left.get(lindex));
				lindex++;
			} else {
				mergedList.add(right.get(rindex));
				rindex++;
			}
		}

		// step 2: write any remaining values in the left list into the mergeList list
		while (lindex < left.size()) {
			mergedList.add(left.get(lindex));
			lindex++;
		}

		// step 3: write any remaining values in the right list into the mergeList list
		while (rindex < right.size()) {
			mergedList.add(right.get(rindex));
			rindex++;
		}
		return mergedList;
	}

	/**
	 * Parallel merge sort
	 * 
	 * @param numbers     the list of numbers to be sorted
	 * @param parallelism how many CPU cores to use
	 * @return the sorted list
	 */
	public static LinkedList<Integer> parallelMergeSort(LinkedList<Integer> numbers, int parallelism) {
		ForkJoinPool pool = new ForkJoinPool(parallelism);
		ParallelMergeSort mergeSortTask = new ParallelMergeSort(numbers);
		LinkedList<Integer> result = pool.invoke(mergeSortTask);
		return result;
	}

	/**
	 * Benchmarks parallel merge sort
	 */
	public static void main(String[] args) {
		/* generates a random list */
		LinkedList<Integer> numbers = SortingCommon.randomList(50000);

		/* gets the number of cores in this computer's CPU */
		int cpuCores = Runtime.getRuntime().availableProcessors();

		/*
		 * benchmarks the parallel merge sort for Q2 on 1, 2, 4, .. CPU cores
		 */
		for (int threads = 1; threads <= cpuCores; threads *= 2) {
			Benchmark.parallel(new ParallelMergeSort(numbers), threads);
		}
	}

}