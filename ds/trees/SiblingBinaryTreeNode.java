package ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class SiblingBinaryTreeNode {
	public int data;
	public SiblingBinaryTreeNode left;
	public SiblingBinaryTreeNode right;
	public SiblingBinaryTreeNode nextSibling;
	public SiblingBinaryTreeNode(int data) {
		super();
		this.data = data;
		this.left = null;
		this.right = null;
		this.nextSibling = null;
	}
	public SiblingBinaryTreeNode(int data, SiblingBinaryTreeNode left, SiblingBinaryTreeNode right,
			SiblingBinaryTreeNode nextSibling) {
		super();
		this.data = data;
		this.left = left;
		this.right = right;
		this.nextSibling = nextSibling;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public SiblingBinaryTreeNode getLeft() {
		return left;
	}
	public void setLeft(SiblingBinaryTreeNode left) {
		this.left = left;
	}
	public SiblingBinaryTreeNode getRight() {
		return right;
	}
	public void setRight(SiblingBinaryTreeNode right) {
		this.right = right;
	}
	public SiblingBinaryTreeNode getNextSibling() {
		return nextSibling;
	}
	public void setNextSibling(SiblingBinaryTreeNode nextSibling) {
		this.nextSibling = nextSibling;
	}
	
	public boolean isLeaf()
	{
		return (this.left == null && this.right == null);
	}
	
	/**
	 * Method to fill next sibling for each node in a given Binary Tree using Level Order traversal
	 * 
	 * @param root
	 */
	public void fillNextSiblings(SiblingBinaryTreeNode root)
	{
		if(root == null)
			return;
		Queue<SiblingBinaryTreeNode> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		while(!q.isEmpty())
		{
			SiblingBinaryTreeNode temp = q.poll();
			if(temp!=null)
			{
				temp.setNextSibling(q.peek());
				if(temp.getLeft() != null)
					q.offer(temp.getLeft());
				if(temp.getRight() != null)
					q.offer(temp.getRight());
			}
			else
			{
				if(!q.isEmpty())
				{
					q.offer(null);
				}
			}
		}
	}
	
	/**
	 * Method to fill next sibling for each node in a given Binary Tree using recursion
	 * 
	 * @param root
	 */
	public void fillnextSiblingsRecursive(SiblingBinaryTreeNode root)
	{
		if(root == null)
			return;
		if(root.getLeft() != null)
			root.getLeft().setNextSibling(root.getRight());
		if(root.getRight() != null)
		{
			if(root.getNextSibling() != null)
				root.getRight().setNextSibling(root.getNextSibling().getLeft());
			else
				root.getRight().setNextSibling(null);
		}
		fillnextSiblingsRecursive(root.getLeft());
		fillnextSiblingsRecursive(root.getRight());
	}
}
