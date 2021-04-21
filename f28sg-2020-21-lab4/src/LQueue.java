//import LinkedList.Node;  Import didn't work so methods for linked lists were implemented in node class.

public class LQueue {

	private class Node {
		Object element;
		Node next;

		public Node(Object e, Node n) {
			element = e;
			next = n;
		}

		public Node(Object e) {
			element = e;
			next = null;
		}

		/**
		 * method to get the element.
		 * @return returns the element of the given Node.
		 */
		public Object getValue() {
			return element;
		}

		/**
		 * Sets the next node of a given Node
		 * @param n the node that will be set to be next.
		 */
		public void setNextNode(Node n) {
			next = n;
		}

		/**
		 * Gets the next node of a given Node.
		 * @return the next Node
		 */
		public Node getNextNode() {
			return next;
		}

	}

	private Node head;
	private Node tail;
	private int size;

	public LQueue() {
		head = null;
		tail = null;
	}

	/*
	 * Part 3: complete the following methods
	 */

	// Part 3: complete
	/**
	 * This method checks if the Queue is empty by checking if head and tail are null.
	 * @return true if empty, false if non-empty.
	 */
	public boolean isEmpty() {
		if (head == null && tail == null) {
			return true;
			
		}
		
		return false;
	}

	// Part 3: complete
	/**
	 * Gives the size of the queue.
	 * @return the size of the queue.
	 */
	public int size() {
		return size; // dummy value
	}

	// Part 3: complete
	/**
	 * This method adds an object to the queue and has a special case if the queue is empty.
	 * 
	 * @param o the element of the new Node.
	 */
	public void enqueue(Object o) {
		Node newNode = new Node(o);

		if (isEmpty()) {
			head = newNode;
			tail = newNode;
			size++;
		} else {
			tail.setNextNode(newNode);
			tail = newNode;
			size++;
		}
	}

	// Part 3: complete
	/**
	 * 
	 * Removes an element from the queue and throws a QueueException if the queue is empty.
	 * 
	 * @return the value of the Node removed.
	 * @throws QueueException
	 */
	public Object dequeue() throws QueueException {

		if (isEmpty()) {
			throw new QueueException("The Queue is empty.");
		}

		Object valueToReturn = head.getValue();
		head = head.getNextNode();

		return valueToReturn; // dummy value
	}

	// Part 3: complete
	/**
	 * returns the value of the node at the front of the queue.
	 * @return heads value.
	 * @throws QueueException
	 */
	public Object front() throws QueueException {
		if (isEmpty()) {
			throw new QueueException("The Queue is empty.");
		}
		return head.getValue();
	}

}
