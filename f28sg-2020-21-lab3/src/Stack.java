class StackException extends RuntimeException {
	public StackException(String err) {
		super(err);
	}
}

public class Stack {

	private class Node {
		int element;
		Node next;

		public Node(int e, Node n) {
			element = e;
			next = n;
		}

		public int getValue() {
			return element;
		}

		public Node getNext() {
			return next;
		}
	}

	// this is a reference to the head node of the linked list
	private Node top;

	// keep track of the number of elements in the stack
	private int size;

	public Stack() {
		top = null;
		size = 0;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public int size() {
		return size;
	}

	// part 3: complete
	/**
	 * adds a node to the top of the stack and also increases the size of stack
	 * @param o the value of the new node
	 */
	public void push(int o) {
		top = new Node(o, top);
		size++;
	}

	// part 3: complete
	/**
	 * This method removes the top element from the stack and also returns what it was.
	 * @return returns the value of popped element
	 * @throws StackException if the stack is empty
	 */
	public int pop() throws StackException {
		if (isEmpty()) {
			throw new StackException("The stack is empty");
		}

		int r = top.getValue();
		top = top.getNext();
		size--;
		return r;
	}

	// part 3: complete
	/**
	 * gets the value of the top node of the stack
	 * @return the value of the top node.
	 * @throws StackException if the stack is empty
	 */
	public int top() throws StackException {
		if (isEmpty()) {
			throw new StackException("The stack is empty");
		}
		return top.getValue();
	}

}
