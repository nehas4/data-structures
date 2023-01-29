package ds.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTreeTraversal {

	public ArrayList<ArrayList<Integer>> levelOrderTraversal(BinaryTreeNode root) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(root == null)
		{
			return result;
		}
		Queue<BinaryTreeNode> nodeQ = new LinkedList<BinaryTreeNode>();
		nodeQ.offer(root);
		nodeQ.offer(null);
		ArrayList<Integer> current = new ArrayList<Integer>();
		while(!nodeQ.isEmpty())
		{
			BinaryTreeNode temp = nodeQ.poll();
			if(temp != null)
			{
				current.add(temp.data);
				if(temp.left != null)
				{
					nodeQ.offer(temp.left);
				}
				if(temp.right != null)
				{
					nodeQ.offer(temp.right);
				}
			}
			else
			{
				ArrayList<Integer> new_current = new ArrayList<Integer>(current);
				result.add(new_current);
				current.clear();
				if(!nodeQ.isEmpty())
				{
					nodeQ.offer(null);
				}
			}
		}
		return result;
	}

}
