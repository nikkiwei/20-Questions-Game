package datastructures;

/**
 * List interface for simplest ADT of sequentially stored data with changing length.
 * 
 * @author astjohn
 * @version 1
 * @param <T> generics type
 */

public interface List<T> {
	
	/**
	 * Add (insert) data at specific index in list,
	 * e.g., add( 0, data ) inserts data to front/head of list
	 * @param index the index of the list to add the node
	 * @param data the value to store at the node
	 **/
	public void add( int index, T data );
 
	/**
	 * Get data stored at specific index in list.
	 * @param index the index of the node to get the data from
	 * @return the data at the node
	 **/
	public T get( int index );
 
	/**
	 * Delete data at specific index in list,
	 * e.g., delete( 0 ) removes the first element from the list
	 * @param index the index of the list to delete the node
	 **/
	public void delete( int index );
 
	/**
	 * Get the number of elements in this list.
	 * @return the size of the list
	 **/
	public int size();
 
	/**
	 * Check if the list is empty.
	 * @return true if the list doesn't have any nodes
 	 **/
	public boolean isEmpty();
	
}
