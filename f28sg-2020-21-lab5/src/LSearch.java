public class LSearch {


	private class Node {
		private Entry value;
		private Node nextNode;

		public Node(Entry v) {
			value = v;
			nextNode = null;
		}

		public Entry getValue() {
			return value;
		}

		public Node getNextNode() {
			return nextNode;
		}

		// Sets the NextNode to the given Node
		public void setNextNode(Node n) {
			nextNode = n;
		}
	}

	// Holds a reference to the head of the list
	private Node headNode;

	public LSearch() {
		headNode = null;
	}

	public void addAtHead(Entry e) {
		Node newNode = new Node(e); 
		newNode.setNextNode(headNode); 
		headNode = newNode; 
	}
	
	/*
	 * Part 3: complete
	 */	
	/**
	 * This method linearly searches through a linked list using a while loop to find a specific name within and entry
	 * inside the list.
	 * @param name : the name of the person to be found inside an entry
	 * @return : the number of the person if they are found inside an entry. It also returns -1 if the person is 
	 * not found.
	 */
	public int linearSearch(String name){
		
		Node curr = headNode;
		
		while(curr != null) {
			
			if(curr.getValue().getName().equals(name)){
				
				return curr.getValue().getNumber();
			}
			curr = curr.getNextNode();
		}
		return -1; 
	}
}
