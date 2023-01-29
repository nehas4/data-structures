package ds.trees;

import java.util.ArrayList;
import java.util.Stack;

public class PreOrderTreeTraversal implements TreeTraversal
{
	@Override
	public void recursiveTraversal(BinaryTreeNode root) {
		if(root != null)
		{
			System.out.println(root.data+" ");
			recursiveTraversal(root.left);
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
		nodeStack.push(root);
		while(!nodeStack.isEmpty())
		{
			BinaryTreeNode temp = nodeStack.pop();
			result.add(temp.data);
			if(temp.right!=null)
			{
				nodeStack.push(temp.right);
			}
			
			if(temp.left!=null)
			{
				nodeStack.push(temp.left);
			}
		}
		
		return result;
	}
}
