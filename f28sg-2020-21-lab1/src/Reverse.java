
public class Reverse {

	// Part 2
	/**
	 * This method reverse the order a given input String[] array 
	 * @param arr is the given array.
	 */
	public static void reverse(String[] arr){ 
		Stack stk = new Stack(arr.length);
		
		for(int i = 0; i < arr.length; i++){
			stk.push(arr[i]);
		}
		for(int i = 0; i < arr.length; i++) {		
			arr[i] = (String)stk.pop();
		}
	}
	
}
