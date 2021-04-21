public class ReverseStack {

	/*
	 * 1: complete implementation
	 */
	/**
	 * This method takes in one stack as a parameter and then reverses it through a Queue and while loop using pop and push.
	 * Pop is used to enqueue into the Queue q, which reverses the stack.
	 * Push then takes the returned value of calling dequeue on Queue q.
	 * @param st is the stack taken in.
	 */
	public static void reverseStack(Stack<String> st) {
		Queue q = new Queue();

		while (!st.isEmpty()) {
			q.enqueue(st.pop());
		}
		while (!q.isEmpty()) {
			st.push(q.dequeue().toString());

		}
	}

}
