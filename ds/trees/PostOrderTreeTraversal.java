package ds.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PostOrderTreeTraversal implements TreeTraversal{

	@Override
	public void recursiveTraversal(BinaryTreeNode root) {
		if(root != null)
		{
			recursiveTraversal(root.left);
			recursiveTraversal(root.right);
			System.out.println(root.data+" ");
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
		nodeStack.push(root);
		BinaryTreeNode previousNode = null;
		while(!nodeStack.isEmpty())
		{
			BinaryTreeNode currentNode = nodeStack.peek();
			if(previousNode == null || previousNode.left == currentNode || previousNode.right == currentNode)
			{
				if(currentNode.left != null)
				{
					nodeStack.push(currentNode.left);
				}
				else if(currentNode.right != null)
				{
					nodeStack.push(currentNode.right);
				}
			}
			else if(currentNode.left==previousNode)
			{
				if(currentNode.right!= null)
				{
					nodeStack.push(currentNode.right);
				}
			}
			else
			{
				result.add(currentNode.data);
				nodeStack.pop();
			}
			previousNode=currentNode;
		}
		return result;
	}

}
