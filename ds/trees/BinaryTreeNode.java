package ds.trees;

public class BinaryTreeNode {
	public int data;
	public BinaryTreeNode left, right;
	
	public BinaryTreeNode() {
		super();
	}
	public BinaryTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public BinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(BinaryTreeNode left) {
		this.left = left;
	}
	public BinaryTreeNode getRight() {
		return right;
	}
	public void setRight(BinaryTreeNode right) {
		this.right = right;
	}
	
	
}
