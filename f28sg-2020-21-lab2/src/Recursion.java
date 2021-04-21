public class Recursion {

	/**
	 * @param n is the number that will be summed up to, such that 1+2+3+...+n
	 * @return the returned value is the sum of all numbers up to n.
	 */
	public static int sum(int n) {

		if (n == 1) {
			return 1;
		}
		return n + sum(n - 1);
	}

	/**
	 * This method computes m * n through addition and recursion
	 * 
	 * @param m the first number in the multiplication
	 * @param n the second number in the multiplication
	 * @return The return value is the product of m*n through addition
	 */
	public static int multiply(int m, int n) {
		if (n == 0) {
			return 0;

		}
		return m + (m * (n - 1));
	}

	/**
	 * This method goes through the fibonacci sequeunce through recursion
	 * 
	 * @param n is the Fibonacci number
	 * @return is the sum of the previous two numbers in the fibonacci sequence
	 */
	public static int Fibonacci(int n) {
		if (n == 0 || n == 1) { // two base cases as 0 = 0 and 1 = 1 in the Fibonacci sequence.
			return n;
		}
		return Fibonacci(n - 2) + Fibonacci(n - 1);
	}

}