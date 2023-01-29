package ds.trees;

import java.util.ArrayList;
import java.util.Stack;

public class InOrderTreeTraversal implements TreeTraversal
{

	@Override
	public void recursiveTraversal(BinaryTreeNode root) {
		if(root!=null)
		{
			recursiveTraversal(root.left);
			System.out.println(root.data+" ");
			recursiveTraversal(root.right);
		}
	}

	@Override
	public ArrayList<Integer> iterativeTraversal(BinaryTreeNode root) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if(root == null)
		{
			return result;
		}
		Stack<BinaryTreeNode> nodeStack = new Stack<BinaryTreeNode>();
		boolean done = false;
		BinaryTreeNode currentNode = root;
		if(!done)
		{
			if(currentNode != null)
			{
				nodeStack.push(currentNode);
				currentNode=currentNode.left;
			}
			else
			{
				if(nodeStack.isEmpty())
				{
					done = true;
				}
				else
				{
					currentNode=nodeStack.pop();
					result.add(currentNode.data);
					currentNode=currentNode.right;
				}
			}
		}
		return result;
	}

}
