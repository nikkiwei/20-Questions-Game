package datastructures;

/**
 * BinaryTree.java
 * CS 201
 * Heather Pon-Barry
 */

/**
 * BinaryTree is the interface for a basic binary tree. 
 */
public interface BinaryTree<T>
{

	/**
	 * Get the root node for this tree.
	 * 
	 * @return root or null if tree is empty.
	 */
	public BinaryTreeNode<T> getRoot();

	/**
	 * Set the root node for this tree.
	 * @param root the root node of the tree
	 */
	public void setRoot(BinaryTreeNode<T> root);

	/**
	 * Test if the tree is empty.
	 * 
	 * @return true if tree has no data.
	 */
	public boolean isEmpty();

	/**
	 * Get the data of this tree using inorder traversal.
	 * 
	 * @return inorder List.
	 */
	public LinkedList<T> inorderTraversal();

	/**
	 * Get the data of this tree using preorder traversal.
	 * 
	 * @return preorder List.
	 */
	public LinkedList<T> preorderTraversal();

	/**
	 * Get the data of this tree using postorder traversal.
	 * 
	 * @return postorder List.
	 */
	public LinkedList<T> postorderTraversal();

	/**
	 * Recursively visit each node in the binary tree and find all leaf nodes
	 * @param node the starting node
	 * @param leafList the list to store all leaf nodes
	 */
	public void findLeafNodes(BinaryTreeNode<T> node, LinkedList<T> leafList);

}
