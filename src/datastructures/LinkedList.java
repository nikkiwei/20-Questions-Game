package datastructures;

/**
 * Store all the methods that a linked list can implement
 * 
 * @author Nikki Wei
 * @version 1
 * @param <T> generics type
 */

public class LinkedList<T> implements List<T> {
	
	// the head node of the list
	private LinkedListNode<T> head;
	
	/**
	 * Constructor for the LinkedList
	 */
	public LinkedList() {}
	
	/**
	 * Helper method to access the node at index. 
	 * If the index is invalid (negative or >= size of list), return null pointer.
	 * @param index of the list
	 * @return the node at the index
	 */
	public LinkedListNode<T> getNode(int index) {
		
		// the index has to be greater than or equal to 0
		if (index >= 0) {
			
			// start at the head node and loop till we get to the node at the index
			LinkedListNode<T> currentNode = head;
			int counter = 0;
			while (counter < index) {
				currentNode = currentNode.getNext();
				counter ++;
			}
			return currentNode;
		}
		return null;
	}

	@Override
	public void add(int index, T data) {
		
		// create a new node and store the data in it
		LinkedListNode<T> node = new LinkedListNode<T>();
		node.setData(data);
		
		// if insert it to the beginning of the list
		if (index == 0) {
			node.setNext(head);
			head = node;
		}
		
		// if insert at any other place within the list
		else {
			LinkedListNode<T> prevNode = getNode(index - 1);
			if (prevNode != null) {
				node.setNext(prevNode.getNext());
				prevNode.setNext(node);
			}
		}
	}

	@Override
	public T get(int index) {
		
		// if get the beginning node
		if (index == 0 && head != null) {
			return head.getData();
		}
		
		// if get any other node
		else {
			LinkedListNode<T> node = getNode(index);
			if (node != null) {
				return node.getData();
			}
		}
		return null;
	}

	@Override
	public void delete(int index) {
		
		// if delete the beginning node
		if (index == 0 && head != null) {
			head = head.getNext();
		}
		
		// if delete any other node
		else {
			LinkedListNode<T> prevNode = getNode(index - 1);
			if (prevNode != null) {
				prevNode.setNext(getNode(index + 1));
			}
		}
	}

	@Override
	public int size() {
		
		// start at the head node and loop until reaching the tail
		LinkedListNode<T> currentNode = head;
		int size = 0;
		while (currentNode != null) {
			currentNode = currentNode.getNext();
			size ++;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {

		if (head != null) {
			return false;
		}
		return true;
	}
}
