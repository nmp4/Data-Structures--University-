/**
 * @author npreg
 *
 */
public class LinkedList {

	private class Node {
		private int value;
		private Node nextNode;

		public Node(int i) {
			value = i;
			nextNode = null;
		}

		// returns the value stored in the node
		public int getValue() {
			return value;
		}

		// sets the value stored in the node
		public void setValue(int i) {
			value = i;
		}

		// Returns the Node that this Node links to
		// Note this may return null
		public Node getNextNode() {
			return nextNode;
		}

		// Sets the NextNode to the given Node
		public void setNextNode(Node n) {
			nextNode = n;
		}

		// adds Node n to the tail of the list
		public void addNodeAtTail(Node n) {
			if (this.nextNode == null) {
				this.nextNode = n;
			} else {
				this.nextNode.addNodeAtTail(n);
			}
		}

		public Node removeAtTail(Node valueAtTail) {
			if (this.nextNode == null) { // if this is the last node
				valueAtTail.setValue(this.getValue()); // copy out the value
				return null; // return null
			} else { // move onto the next Node
				this.nextNode = this.nextNode.removeAtTail(valueAtTail);
				return this;
			}

		}
	} // End of Node Class implementation

	private Node headNode; // Holds a reference to the head of the list

	public LinkedList() {
		headNode = null;
	}

	public void addAtHead(int i) {
		Node newNode = new Node(i);
		newNode.setNextNode(headNode);
		headNode = newNode;
	}

	public void addAtTail(int i) {
		Node newNode = new Node(i);
		if (headNode == null) {
			headNode = newNode;
		} else {
			headNode.addNodeAtTail(newNode);
		}
	}

	/*
	 * removes and returns the value at the head of the list note, this may return
	 * -1 if the list is empty
	 */
	public int removeAtHead() {
		if (headNode == null) {
			return -1; // return -1 if the list is empty
		} else {
			Node returnedNode = headNode;
			headNode = headNode.getNextNode();
			return returnedNode.getValue();
		}
	}

	public int removeAtTail() {
		if (headNode == null) {
			return -1;
		} else {
			Node returnedNode = new Node(-1);
			headNode = headNode.removeAtTail(returnedNode);
			return returnedNode.getValue();
		}
	}

	/*
	 * PART 2: complete the following methods
	 */

	/**
	 * gets the size of the linked list using a while loop that iterates only if the Node n's reference is not null, 
	 * meaning it hasn't gotten to the end of the list.
	 * @return the return value is the size of the list after counter is added to every iteration.
	 */
	public int size() {
		int counter = 0;
		Node n = headNode;
		while (n != null) {
			n = n.getNextNode(); //sets the Node n to the next node in the list.
			counter++;
		}

		return counter;
	}

	/**
	 * This method gets the sum of all the values inside of the linked list going from the head to the tail.
	 * @return the sum of all the nodes' values.
	 */
	public int total() {
		int total = 0;

		Node n = headNode;

		while (n != null) {
			total = total + n.getValue(); //sets total to total + the current nodes value.
			n = n.getNextNode();
		}

		return total;
	}

	/*
	 * Optional: reverse the linked lists so that the first element becomes the
	 * last, the second becomes the second last, and so on.
	 */
	public void reverse() {

	}

}
