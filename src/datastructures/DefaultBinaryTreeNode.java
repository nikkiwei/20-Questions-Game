package datastructures;

/**
 * Class for the node of Binary Tree
 * 
 * @author Nikki Wei
 * @version 1
 * @param <T> generics type
 */

public class DefaultBinaryTreeNode<T> implements BinaryTreeNode<T> {
	
	// the value stored at the node
	private T data;
	
	// the pointer to the left child
	private BinaryTreeNode<T> leftChild;
	
	// the pointer to the right child
	private BinaryTreeNode<T> rightChild;

	@Override
	public T getData() {
		return data;
	}

	@Override
	public void setData(T data) {
		this.data = data;
	}

	@Override
	public BinaryTreeNode<T> getLeftChild() {
		return leftChild;
	}

	@Override
	public BinaryTreeNode<T> getRightChild() {
		return rightChild;
	}

	@Override
	public void setLeftChild(BinaryTreeNode<T> left) {
		leftChild = left;
	}

	@Override
	public void setRightChild(BinaryTreeNode<T> right) {
		rightChild = right;
	}

	@Override
	public boolean isLeaf() {
		if (leftChild == null && rightChild == null) {
			return true;
		}
		return false;
	}

}
