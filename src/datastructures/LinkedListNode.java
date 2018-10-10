package datastructures;

/**
 * Class for the node of linked list
 * 
 * @author Nikki Wei
 * @version 1
 * @param <T> generics type
 */

public class LinkedListNode<T> {
	
	// the value stored at the node
	private T data;
	
	// the pointer to the next node
	private LinkedListNode<T> next;
	
	/**
	 * Constructor for the LinkedListNode
	 */
	public LinkedListNode() {}
	
	/**
	 * Set the data stored at this node.
	 * @param data the value we want to store at this node
	 */
	public void setData( T data ) {
		this.data = data;
	}
	 
	/**
	 * Get the data stored at this node.
	 * @return the data stored at this node
	 */
	public T getData() {
		return data;
	}
	 
	/**
	 * Set the next pointer to passed node.
	 * @param node the node that this node points to
	 */
	public void setNext( LinkedListNode<T> node ) {
		next = node;
	}
	 
	/**
	 * Get (pointer to) next node.
	 * @return the node that this node points to
	 */
	public LinkedListNode<T> getNext() {
		return next;
	}
	 
	/**
	 * Returns a String representation of this node.
	 * @return if it points to another node, return the data and the pointer, if it doesn't, return only the data
	 */
	public String toString() {
		if (next == null && data != null) {
			return data.toString();
		}
		return data.toString() + "->";
	}
	
}
