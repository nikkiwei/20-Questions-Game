package datastructures;

/**
 * Store all the methods that a binary tree can implement
 * 
 * @author Nikki Wei
 * @version 1
 * @param <T> generics type
 */

public class DefaultBinaryTree<T> implements BinaryTree<T> {

	// the root node of the binary tree
	protected BinaryTreeNode<T> root;

	// the index of each node in the linked list
	private int index;

	/**
	 * Recursively insert every node of the binary tree into a linked list in order
	 * @param node the current node
	 * @param traversal the linked list to insert the nodes into
	 */
	private void inorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {

		// base case 1
		if (node == null) {
			return;
		}

		// base case 2
		else if (node.isLeaf()) {
			traversal.add(index, node.getData());
			index++;
		}

		// recursive case
		else {
			inorderTraversal(node.getLeftChild(), traversal);
			traversal.add(index, node.getData());
			index++;
			inorderTraversal(node.getRightChild(),traversal);
		}
	}

	/**
	 * Recursively insert every node of the binary tree into a linked list in preorder
	 * @param node the current node
	 * @param traversal the linked list to insert the nodes into
	 */
	private void preorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {

		// base case 1
		if (node == null) {
			return;
		}

		// base case 2
		else if (node.isLeaf()) {
			traversal.add(index, node.getData());
			index++;
		}

		// recursive case
		else {
			traversal.add(index, node.getData());
			index++;
			preorderTraversal(node.getLeftChild(), traversal);
			preorderTraversal(node.getRightChild(),traversal);
		}
	}

	/**
	 * Recursively insert every node of the binary tree into a linked list in postorder
	 * @param node the current node
	 * @param traversal the linked list to insert the nodes into
	 */
	private void postorderTraversal(BinaryTreeNode<T> node, LinkedList<T> traversal) {

		// base case 1
		if (node == null) {
			return;
		}

		// base case 2
		else if (node.isLeaf()) {
			traversal.add(index, node.getData());
			index++;
		}

		// recursive case
		else {
			postorderTraversal(node.getLeftChild(), traversal);
			postorderTraversal(node.getRightChild(),traversal);
			traversal.add(index, node.getData());
			index++;
		}
	}
	
	/**
	 * Recursively visit each node in the binary tree and find all leaf nodes
	 * @param node the starting node
	 * @param leafList the list to store all leaf nodes
	 */
	public void findLeafNodes(BinaryTreeNode<T> node, LinkedList<T> leafList) {	
		
		// base case
		if (node.isLeaf()) {
			leafList.add(leafList.size(), node.getData());
		}
		
		// recursive case
		else {

			if (node.getLeftChild() != null) {
				findLeafNodes(node.getLeftChild(), leafList);
			}

			if (node.getRightChild() != null) {
				findLeafNodes(node.getRightChild(), leafList);
			}
		}
	}

	@Override
	public BinaryTreeNode<T> getRoot() {
		return root;
	}

	@Override
	public void setRoot(BinaryTreeNode<T> root) {
		this.root = root;
	}

	@Override
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	@Override
	public LinkedList<T> inorderTraversal() {
		LinkedList<T> traversal = new LinkedList<T>();
		index = 0;
		inorderTraversal(root, traversal);

		// loop through the list and print it out
		System.out.println("Inorder Traversal is:");
		int i = 0;
		while (i < traversal.size() - 1) {
			System.out.print(traversal.get(i) + "->");
			i ++;
		}
		System.out.print(traversal.get(i) + "\n");

		return traversal;
	}

	@Override
	public LinkedList<T> preorderTraversal() {
		LinkedList<T> traversal = new LinkedList<T>();
		index = 0;
		preorderTraversal(root, traversal);

		// loop through the list and print it out
		System.out.println("Preorder Traversal is:");
		int i = 0;
		while (i < traversal.size() - 1) {
			System.out.print(traversal.get(i) + "->");
			i ++;
		}
		System.out.print(traversal.get(i) + "\n");

		return traversal;
	}

	@Override
	public LinkedList<T> postorderTraversal() {
		LinkedList<T> traversal = new LinkedList<T>();
		index = 0;
		postorderTraversal(root, traversal);

		// loop through the list and print it out
		System.out.println("Postorder Traversal is:");
		int i = 0;
		while (i < traversal.size() - 1) {
			System.out.print(traversal.get(i) + "->");
			i ++;
		}
		System.out.print(traversal.get(i) + "\n");

		return traversal;
	}

}
