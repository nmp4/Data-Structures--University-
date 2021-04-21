
public class Sort {

	/*
	 * Part 4: complete method
	 */
	/**
	 * This method takes in an array and sorts it by inserting every element in the array into a priority queue. 
	 * The array then has its indices reassigned to the new values by removeMin being called on the queue.
	 * Meaning the array is sorted into ascending order.
	 * @param arr the array to be sorted into ascending order.
	 */
	public static void sort(int[] arr){	
		
		PriorityQueue queue = new PriorityQueue(arr.length);
		for(int i = 0; i < arr.length; i++) {
			
			queue.insert(arr[i]);
		}
		for(int i = 0; i < arr.length; i++) {
			arr[i] = queue.removeMin();
		}
	}
	
	public static void main(String[] args){
		int[] arr = {53,3,5,2,4,67};
		Sort.sort(arr);
		// should be printed in order
		System.out.println(arr[0]);
		System.out.println(arr[1]);	
		System.out.println(arr[2]);
		System.out.println(arr[3]);	
		System.out.println(arr[4]);	
		System.out.println(arr[5]);	
	}
	
}
