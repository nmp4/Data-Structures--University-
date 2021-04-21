// exception used for Q5
class CalculateException extends RuntimeException{    
	public CalculateException(String err) {
		super(err);
	}
}

public class Calculator {

	/**
	 * Method performs a polish notation calculation by reversing the input cmds and iterating through checking what 
	 * each element is, using the isNumber method, to get the final result.
	 * @param cmds is an array of string numbers and operands in polish notation.
	 * @return result which is the number left after performing all possible calculations on the stack provided.
	 */
	public static int calculate(String [] cmds){
		
		Stack pstack = new Stack(100);
		
		Reverse.reverse(cmds);
		
		int result = 0;
		
		for(int i = 0; i < cmds.length; i++) {

			if(isNumber((String) cmds[i])) {
				pstack.push(cmds[i]);
			}
			else {
				
				String frst = (String) pstack.pop();
				String snd = (String) pstack.pop();
				result = applyOp(frst, (String) cmds[i], snd);
				pstack.push(Integer.toString(result));
			}
		}
		
		return result; 
	}	

	/**
	 * This method converts a given input string s into an integer to be used in a calculation.
	 * @param s is the input string taken in
	 * @return returns the strings when it has been converted to an integer if possible
	 * @throws NumberFormatException thrown if the string cannot be turned into an integer.
	 */
	public static int convert(String s) throws NumberFormatException{
		
		int i = Integer.parseInt(s);
		
		return i; 	
	}

	/**
	 * This method checks whether or not the given input is a number. If the given input is not a number it catches a
	 * NumberFormatException.
	 * @param s is the input string that will be checked to see if it is a number
	 * @return returns true or false depending on whether the argument s is a number or not.
	 */
	public static boolean isNumber(String s){
		try {
			Integer.parseInt(s);
		}
		catch(NumberFormatException e) {
			return false;
		}
		return true; 
	}

	/**
	 * This method applies the operand present onto the input strings
	 * @param fst the first number of left most number in an operation
	 * @param op the operand
	 * @param snd the last or right most number in an operation
	 * @return result which is the result of the operation performed based on which operand was present.
	 */
	public static int applyOp(String fst,String op,String snd){
		
		int first = convert(fst);
		int second = convert(snd);
		int result = 0;
		
		switch(op) {
		case "-": 
			result = first - second;
			break;
		case "+":
			result = first + second;
			break;
		case "/": 
			result = first / second;
			break;
		case "*": 
			result = first * second;
			break;
		default:
			System.out.println("There is no valid operand present.");
		}
		
		
		return result; // dummy value
	}

	/* main operation to calculate using Polish notation directly
    public static int calculatePolish(String [] cmds){
    	return -1; // dummy value
    }*/
}