package sort.parallel;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import sort.sequential.SequentialMergeSort;
import sort.sequential.SortingCommon;
import utils.Benchmark;

/*
 * Merge Sort results with thresholding
 * ~~~~~~~~~~~~~~~~~~
 *
 *	- 1 thread
 *	no threshold		1 threads	runtime=3311ms	
 *	threshold=128		1 threads	runtime=3139ms	
 *	threshold=512		1 threads	runtime=3098ms	
 *	threshold=2048		1 threads	runtime=3095ms	
 *	threshold=8192		1 threads	runtime=3107ms	
 *
 *	- 2 thread
 *	no threshold		2 threads	runtime=2398ms	
 *	threshold=128		2 threads	runtime=2387ms	
 *	threshold=512		2 threads	runtime=2409ms	
 *	threshold=2048		2 threads	runtime=2380ms	
 *	threshold=8192		2 threads	runtime=2386ms	
 *
 *	- 4 thread
 *	no threshold		4 threads	runtime=2222ms	
 *	threshold=128		4 threads	runtime=2518ms	
 *	threshold=512		4 threads	runtime=2630ms	
 *	threshold=2048		4 threads	runtime=2639ms	
 *	threshold=8192		4 threads	runtime=2858ms	
 *
 * Parameters of the shortest runtime:
 * - runtime:
 * - how many threads:
 * - threshold value:
 * 
 * Best parallel speedup:	1.39117647059
* - runtime: 2380ms	
* - how many threads: 2
* - threshold value: 2048
* 
* 
* 
* Parallelism efficiency: 0.34779411765 or 34.8%
* 
*/

public class ParallelMergeSortThreshold extends RecursiveTask<LinkedList<Integer>> {
	LinkedList<Integer> arr;
	int threshold;

	public ParallelMergeSortThreshold(LinkedList<Integer> arr, int threshold) {
		this.arr = arr;
		this.threshold = threshold;
	}

	/**
	 *This method performs merge sort on a linked list where a threshold is taken in to better runtimes on longer lists.
	 *return: The sorted linked list.
	 */
	@Override
	protected LinkedList<Integer> compute() {
		int length = arr.size();

		// Q2: rewrite the base case condition and body of this if statement,
		// so that you run:
		//
		// sequential merge sort for small inputs (the "base case")
		// by using SequentialMergeSort.mergeSort(..)
		//
		// or run
		//
		// parallel merge sort in parallel for large inputs (the "recursive" case)
		
		//This if condition checks if the length of the list is smaller than the threshold, and if it is it performs
		//a sequential merge sort.
		if (length < threshold) {

			return SequentialMergeSort.mergeSort(arr);
		}
		//This is the recursive case.
		else { // parallel case

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

			// TODO replace this to use the parallel fork/join approach but this
			// time using this ParallelMergeSoftThreshold class to create the two tasks,
			// rather than the ParallelMergeSort class that you used in Q1B. Remember
			// that this time you also need to pass the threshold as the 2nd argument
			// to the constructor.

			//This creates a new Instance of the ParallelMergeSort class using the linked list provided
			//The same is done for the other half of the list in resultRight
			ParallelMergeSortThreshold resultLeft = new ParallelMergeSortThreshold(left, threshold);

			ParallelMergeSortThreshold resultRight = new ParallelMergeSortThreshold(right, threshold);

			//This forks the list that has been assigned to the left.
			resultLeft.fork();

			 //this recursively computes the right list to sort it.
			LinkedList<Integer> sortedRight = resultRight.compute();

			//this waits for the result from the fork above then assigns it to sortedLeft.
			LinkedList<Integer> sortedLeft = resultLeft.join();

			/* merge the sorted sub arrays */
			return ParallelMergeSort.merge(sortedLeft, sortedRight);//return the sorted list.
		}
	}

	/**
	 * Threshold based parallel merge sort
	 * 
	 * @param numbers     the input list
	 * @param threshold   when to switch from parallel divide-and-conquer to
	 *                    sequential divide-and-conquer
	 * @param parallelism how many threads to use in the ForkJoin workpool
	 * @return the sorted list
	 */
	public static LinkedList<Integer> parallelMergeSortThreshold(LinkedList<Integer> numbers, int threshold,
			int parallelism) {
		ForkJoinPool pool = new ForkJoinPool(parallelism);
		ParallelMergeSortThreshold mergeSortTask = new ParallelMergeSortThreshold(numbers, threshold);
		LinkedList<Integer> result = pool.invoke(mergeSortTask);
		return result;
	}

	/**
	 * Benchmarks threshold based parallel merge sort
	 */
	public static void main(String[] args) {
		/* generates a random list */
		LinkedList<Integer> numbers = SortingCommon.randomList(50000);

		/* gets the number of cores in this computer's CPU */
		int cpuCores = Runtime.getRuntime().availableProcessors();

		/*
		 * 1. prints the runtime for the parallel merge sort from Q1B.
		 * 
		 * 2. prints the runtime for the threshold based parallel merge sort for the
		 * implementation in Q2.
		 */
		for (int threads = 1; threads <= cpuCores; threads *= 2) {
			System.out.print("mergeSort\t no threshold\t\t");
			Benchmark.parallel(new ParallelMergeSort(numbers), threads);
			for (int threshold = 128; threshold <= 8192; threshold *= 4) {
				System.out.print("mergeSort\t threshold=" + threshold + "\t\t");
				Benchmark.parallel(new ParallelMergeSortThreshold(numbers, threshold), threads);
			}
		}
	}

}