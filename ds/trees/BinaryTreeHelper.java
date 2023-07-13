package ds.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author neha46
 *
 */
public class BinaryTreeHelper {
	
	
	/**
	 * Method to return maximum element in binary tree using recursion
	 * 
	 * @param root
	 * @return maximum element
	 */
	public int maxInBTRecursive(BinaryTreeNode root)
	{
		int maxValue = Integer.MIN_VALUE;
		if(root != null)
		{
			int leftMax = maxInBTRecursive(root.left);
			int rightMax = maxInBTRecursive(root.right);
			
			if(maxValue < leftMax)
			{
				maxValue = leftMax;
			}
			else
			{
				maxValue = rightMax;
			}
			
			if(root.data > maxValue)
			{
				maxValue = root.data;
			}
		}
		return maxValue;
	}
	
	/**
	 * Method to return maximum element in binary tree using Level Order Traversal
	 * 
	 * @param root
	 * @return maximum element
	 */
	public int maxInBTLevelOrder(BinaryTreeNode root)
	{
		if(root == null)
		{
			return Integer.MIN_VALUE;
		}
		int max = Integer.MIN_VALUE;
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			if(temp.getData() > max)
			{
				max = temp.getData();
			}
			if(temp != null)
			{
				if(temp.getLeft() != null)
				{
					q.offer(temp.getLeft());
				}
				if(temp.getRight() != null)
				{
					q.offer(temp.getRight());
				}
			}
		}
		
		return max;
	}
	
	/**
	 * Method to return true if given data found in Binary tree, else false
	 * 
	 * @param root
	 * @param data
	 * @return boolean flag
	 */
	public boolean findInBTRecursive(BinaryTreeNode root, int data)
	{
		if(root == null)
		{
			return false;
		}
		if(root.getData() == data)
		{
			return true;
		}
		
		return findInBTRecursive(root.getLeft(), data) || findInBTRecursive(root.getRight(), data);
	}
	
	/**
	 * Method to return true if given data found in Binary tree, else false
	 * 
	 * @param root
	 * @param data
	 * @return boolean flag
	 */
	public boolean findInBTLevelOrder(BinaryTreeNode root, int data)
	{
		if(root == null)
		{
			return false;
		}
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			if(temp.getData() == data)
			{
				return true;
			}
			if(temp != null)
			{
				if(temp.getLeft() != null)
				{
					q.offer(temp.getLeft());
				}
				if(temp.getRight() != null)
				{
					q.offer(temp.getRight());
				}
			}
		}
		return false;
	}
	
	/**
	 * Method to insert in Binary Tree using Level Order Traversal
	 * 
	 * @param root
	 * @param data
	 * @return root node
	 */
	public BinaryTreeNode insertInBTLevelOrder(BinaryTreeNode root, int data)
	{
		if(root == null)
		{
			return new BinaryTreeNode(data);
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			if(temp != null)
			{
				if(temp.getLeft() == null)
				{
					temp.setLeft(new BinaryTreeNode(data));
					return root;
				}
				else
				{
					q.offer(temp);
				}
				if(temp.getRight() == null)
				{
					temp.setRight(new BinaryTreeNode(data));
					return root;
				}
				else
				{
					q.offer(temp);
				}
			}
		}	
		return root;
	}
	
	/**
	 * Method to insert in Binary Tree using recursive helper method 
	 * 
	 * @param root
	 * @param data
	 */
	public void insertInBTRecursive(BinaryTreeNode root, int data)
	{
		if(root == null)
		{
			root =  new BinaryTreeNode(data);
		}
		else
		{
			insertInBTHelper(root, data);
		}
	}
	
	/**
	 * Helper method to insert in Binary Tree using recursion
	 * 
	 * @param root
	 * @param data
	 */
	public void insertInBTHelper(BinaryTreeNode root, int data)
	{
		if(root.getData() >= data)
		{
			if(root.getLeft() == null)
			{
				root.setLeft(new BinaryTreeNode(data));
			}
			else
			{
				insertInBTHelper(root.getRight(), data);
			}
		}
		else
		{
			if(root.getRight() == null)
			{
				root.setRight(new BinaryTreeNode(data));
			}
			else
			{
				insertInBTHelper(root.getRight(), data);
			}
		}
	}
	
	/**
	 * Method to return size (number of nodes) of Binary Tree using Recursion
	 * 
	 * @param root
	 * @return size
	 */
	public int sizeOfBTRecursive(BinaryTreeNode root)
	{
		int leftCount = root.getLeft() == null ? 0 : sizeOfBTRecursive(root.getLeft());
		int rightCount = root.getRight() == null ? 0 : sizeOfBTRecursive(root.getRight());
		return 1 + leftCount + rightCount;
	}

	/**
	 * Method to return size (number of nodes) of Binary Tree using Level Order Traversal
	 * 
	 * @param root
	 * @return size
	 */
	public int sizeOfBTLevelOrder(BinaryTreeNode root)
	{
		int count = 0;
		if(root == null)
		{
			return 0;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			count++;
			if(temp.getLeft() != null)
			{
				q.offer(temp.getLeft());
			}
			if(temp.getRight() != null)
			{
				q.offer(temp.getRight());
			}
		}
		return count;
	}
	
	/**
	 * Method to delete Binary Tree
	 * 
	 * @param root
	 */
	public void deleteBinaryTree(BinaryTreeNode root)
	{
		root = null;
	}
	
	/**
	 * Method to print traverse and print Binary Tree in reverse level order
	 * 
	 * @param root
	 */
	public void levelOrderTraversalInReverse(BinaryTreeNode root)
	{
		if(root == null)
		{
			return;
		}
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			if(temp.getLeft() != null)
			{
				q.offer(temp.getLeft());
			}
			if(temp.getRight() != null)
			{
				q.offer(temp.getRight());
			}
			s.push(temp);
		}
		while(!s.isEmpty())
		{
			System.out.println(s.pop().getData()+" ");
		}
	}
	
	/**
	 * Method to calculate height/max depth using recursion
	 * 
	 * @param root
	 * @return max depth value
	 */
	public int maxDepthRecursive(BinaryTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		int leftDepth=maxDepthRecursive(root.getLeft());
		int rightDepth=maxDepthRecursive(root.getRight());
		return (leftDepth>rightDepth) ? leftDepth + 1 : rightDepth + 1;
	}
	
	/**
	 * Method to calculate height/max depth without using recursion using Post Order Traversal 
	 * 
	 * @param root
	 * @return maximum depth in integer
	 */
	public int maxDepthIterativePostOrder(BinaryTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		Stack<BinaryTreeNode> s = new Stack<BinaryTreeNode>();
		s.push(root);
		int maxDepth = 0;
		BinaryTreeNode prev = null;
		while(!s.isEmpty())
		{
			BinaryTreeNode curr = s.peek();
			if(prev == null || prev.getLeft() == curr || prev.getRight() == curr)
			{
				if(curr.getLeft() != null)
				{
					s.push(curr.getLeft());
				}
				else if(curr.getRight() != null)
				{
					s.push(curr.getRight());
				}
			}
			else if(curr.getLeft() == prev)
			{
				if(curr.getRight() != null)
				{
					s.push(curr.getRight());
				}
			}
			else
			{
				s.pop();
			}
			prev = curr;
			if(s.size() > maxDepth)
			{
				maxDepth = s.size();
			}
		}
		return maxDepth;
	}
	
	/**
	 * Method to calculate height/max depth without using recursion using Level Order Traversal 
	 * 
	 * @param root
	 * @return maximum depth in integer
	 */
	public int maxDepthIterativeLevelOrder(BinaryTreeNode root)
	{
		if(root ==null)
		{
			return 0;
		}
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		int count = 1;
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			if(temp != null)
			{
				if(temp.getLeft() == null && temp.getRight() == null)
				{
					return count;
				}
				if(temp.getLeft() != null)
				{
					q.offer(temp.getLeft());
				}
				if(temp.getRight() != null)
				{
					q.offer(temp.getRight());
				}
			}
			else
			{
				if(!q.isEmpty())
				{
					count++;
					q.offer(null);
				}
			}
		}
		return count;
	}
	
	/**
	 * Method to calculate minimum depth without using recursion using Level Order Traversal
	 * 
	 * @param root
	 * @return minimum depth in integer
	 */
	public int minDepthIterativeLevelOrder(BinaryTreeNode root)
	{
		if(root ==null)
		{
			return 0;
		}
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		HashMap<BinaryTreeNode, Integer> depthMap = new HashMap<>();
		q.offer(root);
		q.offer(null);
		depthMap.put(root, 1);
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			int depth = depthMap.get(temp);
			if(temp != null)
			{
				if(temp.getLeft() == null && temp.getRight() == null)
				{
					return depth;
				}
				if(temp.getLeft() != null)
				{
					q.offer(temp.getLeft());
					depthMap.put(temp.getLeft(), depth+1);
				}
				if(temp.getRight() != null)
				{
					q.offer(temp.getRight());
					depthMap.put(temp.getRight(), depth+1);
				}
			}
		}
		return 0;
	}
	
	/**
	 * Method to return deepest node in Binary Tree using Level order traversal
	 * Last node processed from queue in level order is the deepest node in Binary Tree
	 * 
	 * @param root
	 * @return deepest node BinaryTreeNode object
	 */
	public BinaryTreeNode deepestNodeInBT(BinaryTreeNode root)
	{
		if(root ==null)
		{
			return null;
		}
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		BinaryTreeNode temp=null;
		while(!q.isEmpty())
		{
			temp = q.poll();
			if(temp != null)
			{
				if(temp.getLeft() != null)
				{
					q.offer(temp.getLeft());
				}
				if(temp.getRight() != null)
				{
					q.offer(temp.getRight());
				}
			}
		}
		return temp;
	}
	
	/**
	 * Method to delete particular node in Binary Tree
	 * Get the required node to delete and swap it to deepest node, then delete the deepest node
	 * 
	 * @param root
	 * @param data
	 */
	public void deleteNodeInBinaryTree(BinaryTreeNode root, int data)
	{
		if(root ==null)
		{
			return;
		}
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		BinaryTreeNode deepestNode=null;
		BinaryTreeNode toDelete=null;
		while(!q.isEmpty())
		{
			deepestNode = q.poll();
			if(deepestNode.getData() == data)
			{
				toDelete = deepestNode;
			}
			if(deepestNode != null)
			{
				if(deepestNode.getLeft() != null)
				{
					q.offer(deepestNode.getLeft());
				}
				if(deepestNode.getRight() != null)
				{
					q.offer(deepestNode.getRight());
				}
			}
		}
		
		if(toDelete != null)
		{
			toDelete = deepestNode;
			deepestNode = null;
		}
	}
	
	/**
	 * Method to return total no of leaves in a Binary Tree using Level Order Traversal
	 * 
	 * @param root
	 * @return number of leaves in integer
	 */
	public int noOfLeavesUsingLevelOrder(BinaryTreeNode root)
	{
		if(root ==null)
		{
			return 0;
		}
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		int count = 0;
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			if(temp != null)
			{
				if(temp.getLeft() == null && temp.getRight() == null)
				{
					count++;
				}
				if(temp.getLeft() != null)
				{
					q.offer(temp.getLeft());
				}
				if(temp.getRight() != null)
				{
					q.offer(temp.getRight());
				}
			}
		}
		return count;
	}
	
	/**
	 * Method to return total no of full nodes in Binary tree using Level Order Traversal
	 * Nodes having both left and right children are called as Full Nodes
	 * 
	 * @param root
	 * @return number of full nodes in integer
	 */
	public int noOfFullNodesUsingLevelOrder(BinaryTreeNode root)
	{
		if(root ==null)
		{
			return 0;
		}
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		int count = 0;
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			if(temp != null)
			{
				if(temp.getLeft() != null && temp.getRight() != null)
				{
					count++;
				}
				if(temp.getLeft() != null)
				{
					q.offer(temp.getLeft());
				}
				if(temp.getRight() != null)
				{
					q.offer(temp.getRight());
				}
			}
		}
		return count;
	}
	
	/**
	 * Method to return total no of Half nodes in Binary tree using Level Order Traversal
	 * Nodes having either left or right child (but not both) are called as Full Nodes
	 * 
	 * @param root
	 * @return number of half nodes in integer
	 */
	public int noOfHalfNodesUsingLevelOrder(BinaryTreeNode root)
	{
		if(root ==null)
		{
			return 0;
		}
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		int count = 0;
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			if(temp != null)
			{
				if((temp.getLeft() != null && temp.getRight() == null) || (temp.getLeft() == null && temp.getRight() != null))
				{
					count++;
				}
				if(temp.getLeft() != null)
				{
					q.offer(temp.getLeft());
				}
				if(temp.getRight() != null)
				{
					q.offer(temp.getRight());
				}
			}
		}
		return count;
	}
	
	/**
	 * Method to check if 2 trees have same node structure
	 * 
	 * @param root1
	 * @param root2
	 * @return boolean flag 
	 */
	public boolean isStructuallySame(BinaryTreeNode root1, BinaryTreeNode root2)
	{
		if(root1 == null && root2 == null)
		{
			return true;
		}
		if(root1 == null || root2 == null)
		{
			return false;
		}
		
		return (isStructuallySame(root1.getLeft(), root2.getLeft()) && isStructuallySame(root1.getRight(), root2.getRight()));
	}
	
	/**
	 * Method to get the diameter of Binary Tree recursively
	 * Calculate diameter for each left and right subtree by recursive calls
	 * In the function get height of each left and right sub-trees node recursively
	 * Return the max of all these calculations
	 * 
	 * @param root
	 * @return diameter in integer
	 */
	public int diameterOfBTRecursively(BinaryTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		int lHeight = heightOfBinaryTree(root.getLeft());
		int rHeight = heightOfBinaryTree(root.getRight());
		
		int ldiameter = diameterOfBTRecursively(root.getLeft());
		int rdiameter = diameterOfBTRecursively(root.getRight());
		
		return Math.max(lHeight+rHeight+1, Math.max(ldiameter, rdiameter));
		
	}
	
	/**
	 * Method to calculate height of tree recursively
	 * 
	 * @param root
	 * @return height of Binary tree in integer
	 */
	public int heightOfBinaryTree(BinaryTreeNode root)
	{
		if (root == null)
		{
			return 0;
		}
		
		return (1 + Math.max(heightOfBinaryTree(root.getLeft()), heightOfBinaryTree(root.getRight())));
	}
	
	public int widthOfBTRecursive(BinaryTreeNode root)
	{
		int max=0;
		int height = maxDepthRecursive(root);
		for(int i = 0; i<=height; i++)
		{
			int temp = width(root, i);
			if(temp > max)
			{
				max = temp;
			}
		}
		return max;
	}
	
	/**
	 * Method to return width (no of nodes) at any level of Bianry tree
	 * 
	 * @param root
	 * @param depth
	 * @return width in integer
	 */
	public int width(BinaryTreeNode root, int depth)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			if(depth == 0)
				return 1;
			else
				return (width(root.getLeft(), depth-1) + width(root.getRight(), depth-1));
		}
	}
	
	/**
	 * Method to return level number with maximum sum value in Binary Tree
	 * 
	 * @param root
	 * @return level with max sum in integer
	 */
	public int findMaxSumLevelInBT(BinaryTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		int currSum = 0, maxSum = 0, level=1, maxSumLevel=1;
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			if(temp != null)
			{
				currSum = currSum + temp.getData();
				if(temp.getLeft() != null)
					q.offer(temp.getLeft());
				if(temp.getRight() != null)
					q.offer(temp.getRight());
			}
			else
			{
				level++;
				if(currSum > maxSum)
				{
					maxSum = currSum;
					maxSumLevel = level;
				}
				currSum = 0;
				if(!q.isEmpty())
				{
					q.offer(null);
				}
			}
		}
		return maxSumLevel;
	}
	
	/**
	 * Method to print paths in Binary Tree
	 * 
	 * @param root
	 */
	public void printPaths(BinaryTreeNode root)
	{
		int[] path = new int[sizeOfBTRecursive(root)];
		printPathsInBT(root, path, 0);
	}
	
	/**
	 * Method to print each path values of Binary Tree using recursion
	 * 
	 * @param root
	 * @param path
	 * @param pathLen
	 */
	public void printPathsInBT(BinaryTreeNode root, int[] path, int pathLen)
	{
		if(root == null)
			return;
		path[pathLen] = root.getData();
		pathLen++;
		if(root.getLeft() == null && root.getRight() == null)
		{
			printPathArr(path, pathLen);
		}
		else
		{
			printPathsInBT(root.getLeft(), path, pathLen);
			printPathsInBT(root.getRight(), path, pathLen);
		}
	}
	
	/**
	 * Method to print array containing the path values of Binary Tree
	 * 
	 * @param path
	 * @param pathLen
	 */
	public void printPathArr(int[] path, int pathLen)
	{
		for(int i = 0; i < pathLen; i++)
		{
			System.out.print(path[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * Method to check if any path exists having sum equal to given value
	 * FLow goes through each node decreasing its data value from sum and checking if after the leaf node sum becomes 0
	 * 
	 * @param root
	 * @param sum
	 * @return flag representing presence of path having given sum
	 */
	public boolean hasPathSumInBT(BinaryTreeNode root, int sum)
	{
		if(root == null)
			return false;
		if(root.getLeft() == null && root.getRight() == null && root.getData() == sum)
			return true;
		else
			return hasPathSumInBT(root.getLeft(), sum-root.getData()) || hasPathSumInBT(root.getRight(), sum-root.getData());
	}
	
	/**
	 * Method to return sum of all nodes in Binary Tree
	 * 
	 * @param root
	 * @return sum of all nodes in integer
	 */
	public int sumOfBT(BinaryTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		else
		{
			return (root.getData() + sumOfBT(root.getLeft()) + sumOfBT(root.getRight()));
		}
	}
	
	/**
	 * Method to return sum of all nodes in Binary Tree using recursion
	 * 
	 * @param root
	 * @return sum of all nodes in integer
	 */
	public int sumOfBTRecursive(BinaryTreeNode root)
	{
		if(root == null)
		{
			return 0;
		}
		
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		int sum = 0;
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			sum+=temp.getData();
			if(temp.getLeft() != null)
				q.offer(temp.getLeft());
			if(temp.getRight() != null)
				q.offer(temp.getRight());
		}
		return sum;
	}
	
	/**
	 * Method to return Binary Tree which is a mirror of given Binary Tree
	 * 
	 * @param root
	 * @return BinaryTreeNode with mirrored nodes
	 */
	public BinaryTreeNode mirrorOfBT(BinaryTreeNode root)
	{
		BinaryTreeNode temp;
		if(root != null)
		{
			mirrorOfBT(root.getLeft());
			mirrorOfBT(root.getRight());
			//Swapping the pointers of each subtree
			temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
		}
		return root;
	}
	
	/**
	 * Method to return true if given 2 Binary Trees are mirror of each other else false
	 * 
	 * @param root1
	 * @param root2
	 * @return flag representing if 2 Binary Trees are mirrors of each other
	 */
	public boolean areMirrors(BinaryTreeNode root1, BinaryTreeNode root2)
	{
		if(root1 == null && root2 == null)
			return true;
		if(root1 == null || root2 == null)
			return false;
		if(root1.getData() != root2.getData())
			return false;
		return (areMirrors(root1.getLeft(), root2.getRight()) && areMirrors(root1.getRight(), root2.getLeft()));
	}
	
	/**
	 * Method create Binary Tree using given preOrder and inOrder traversal sequences
	 * 
	 * @param preOrder
	 * @param inOrder
	 * @return constructed BinaryTreeNode
	 */
	public BinaryTreeNode buildBinaryTreeUsingPreIN(int[] preOrder, int[] inOrder)
	{
		if(preOrder.length == 0 || inOrder.length == 0)
			return null;
		return buildBTUsingPreOrderInOrder(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
	}
	
	/**
	 * Method to return created Binary Tree using preOrder and inOrder sequence with help of recursion
	 * 
	 * @param preOrder
	 * @param preStart
	 * @param preEnd
	 * @param inOrder
	 * @param inStart
	 * @param inEnd
	 * @return constructed BinaryTreeNode
	 */
	public BinaryTreeNode buildBTUsingPreOrderInOrder(int[] preOrder, int preStart, int preEnd, int[] inOrder, int inStart, int inEnd)
	{
		if(preStart > preEnd || inStart > inEnd)
			return null;
		int data = preOrder[preStart];
		BinaryTreeNode curr = new BinaryTreeNode(data);
		int offset = inStart;
		for(; offset < inEnd; offset++)
		{
			if(inOrder[offset] == data)
				break;
		}
		
		curr.left = buildBTUsingPreOrderInOrder(preOrder, preStart+1, preEnd+offset-inStart, inOrder, inStart, offset-1);
		curr.right = buildBTUsingPreOrderInOrder(preOrder, preStart+offset-inStart+1, preEnd, inOrder, offset+1, inEnd);
		return curr;
	}
	
	/**
	 * Method create Binary Tree using given postOrder and inOrder traversal sequences
	 * 
	 * @param preOrder
	 * @param inOrder
	 * @return constructed BinaryTreeNode
	 */
	public BinaryTreeNode buildBinaryTreeUsingPostIn(int[] preOrder, int[] inOrder)
	{
		if(preOrder.length == 0 || inOrder.length == 0)
			return null;
		return buildBTUsingPostOrderInOrder(preOrder, 0, preOrder.length-1, inOrder, 0, inOrder.length-1);
	}
	
	/**
	 * Method to return created Binary Tree using postOrder and inOrder sequence with help of recursion
	 * 
	 * @param postOrder
	 * @param postStart
	 * @param postEnd
	 * @param inOrder
	 * @param inStart
	 * @param inEnd
	 * @return constructed BinaryTreeNode
	 */
	public BinaryTreeNode buildBTUsingPostOrderInOrder(int[] postOrder, int postStart, int postEnd, int[] inOrder, int inStart, int inEnd)
	{
		if(postStart > postEnd || inStart > inEnd)
			return null;
		int data = postOrder[postStart];
		BinaryTreeNode curr = new BinaryTreeNode(data);
		int offset = inStart;
		for(; offset < inEnd; offset++)
		{
			if(inOrder[offset] == data)
				break;
		}
		
		curr.left = buildBTUsingPostOrderInOrder(postOrder, postStart, postEnd+offset-inStart-1, inOrder, inStart, offset-1);
		curr.right = buildBTUsingPostOrderInOrder(postOrder, postStart+offset-inStart, postEnd-1, inOrder, offset+1, inEnd);
		return curr;
	}
	
	/**
	 * Method to print all ancestors of a given node if its found in given Binary Tree
	 * 
	 * @param root
	 * @param node
	 * @return true flag is node exists
	 */
	public boolean printAllAncestors(BinaryTreeNode root, BinaryTreeNode node)
	{
		if(root == null)
		{
			return false;
		}
		if(root.getLeft() == node || root.getRight() == node || printAllAncestors(root.getLeft(), node) || printAllAncestors(root.getRight(), node))
		{
			System.out.println(root.getData());
			return true;
		}
		return false;
	}
	
	/**
	 * Method to find the LCA (Least Common Ancestor) for 2 give nodes
	 * 
	 * @param root
	 * @param node1
	 * @param node2
	 * @return BinaryTreeNode object representing LCA
	 */
	public BinaryTreeNode LeastCommonAncestor(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2)
	{
		BinaryTreeNode left, right;
		if(root == null)
		{
			return root;
		}
		if(root == node1 || root == node2)
			return root;
		left = LeastCommonAncestor(root.getLeft(), node1, node2);
		right = LeastCommonAncestor(root.getRight(), node1, node2);
		
		if(left != null && right != null)
		{
			return root;
		}
		else
		{
			return (left != null ? left : right);
		}
	}
	
	/**
	 * Method to return list of nodes traversed in zigzag manner for given Binary Tree
	 * 
	 * @param root
	 * @return list of each level nodes in zigzag fashion
	 */
	public ArrayList<ArrayList<Integer>> zigzagTraversalLevelOrder(BinaryTreeNode root)
	{
		if(root == null)
		{
			return null;
		}
		Queue<BinaryTreeNode> q = new LinkedList<BinaryTreeNode>();
		q.offer(root);
		q.offer(null);
		boolean isLeftToRight = true;
		ArrayList<Integer> curr = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		while(!q.isEmpty())
		{
			BinaryTreeNode temp = q.poll();
			if(temp!= null)
			{
				curr.add(temp.getData());
				if(temp.getLeft() != null)
					q.offer(temp.getLeft());
				if(temp.getRight() != null)
					q.offer(temp.getRight());
			}
			else
			{
				if(isLeftToRight)
				{
					ArrayList<Integer> curr1 = new ArrayList<Integer>(curr);
					result.add(curr1);
					curr.clear();
				}
				else
				{
					Stack<Integer> stack = new Stack<Integer>();
					stack.addAll(curr);
					ArrayList<Integer> curr1 = new ArrayList<Integer>();
					while(!stack.isEmpty())
					{
						curr1.add(stack.pop());
					}
					result.add(curr1);
					curr.clear();
				}
				
				if(!q.isEmpty())
				{
					q.offer(null);
					isLeftToRight = !isLeftToRight;
				}
			}
		}
		return result;
	}
	
	/**
	 * Method to get vertical sum of Binary tree by calculating sum of each nodes in each collumn
	 * 
	 * @param root
	 */
	public void verticalSumBT(BinaryTreeNode root)
	{
		HashMap<Integer, Integer> hash = new HashMap<Integer, Integer>();
		vSum(hash, root, 0);
		System.out.println();
		for(int i : hash.keySet())
		{
			System.out.println("key(pos): "+i+" sum: "+hash.get(i));
		}
	}
	
	/**
	 * Method to calculate sum for each nodes for each column in Binary tree
	 * 
	 * @param hash
	 * @param root
	 * @param c
	 */
	public void vSum(HashMap<Integer, Integer> hash, BinaryTreeNode root, int c)
	{
		if(root.getLeft() != null)
			vSum(hash, root.getLeft(), c-1);
		if(root.getRight() != null)
			vSum(hash, root.getRight(), c+1);
		int data = 0;
		if(hash.containsKey(c))
		{
			data=hash.get(c);
		}
		hash.put(c, root.data+data);
	}
	
	/**
	 * Method to return number of possible binary tree that can be created by given number of nodes
	 * Alternative approach: noOfPossibleBT = 2^n - n
	 * 
	 * @param n
	 * @return integer for no of possible BTs
	 */
	public int noOfBTPOssible(int n)
	{
		int[] count = new int[n+1];
		count[0]=1;
		count[1]=1;
		for(int i=2;i<=n;i++)
		{
			for(int j=0;j<i;j++)
			{
				count[i]+=count[j] * count[j-i-1];
			}
		}
		return count[n];
	}
	
	/**
	 * Method to create all possible Binary Tress from given number of nodes
	 * 
	 * @param n
	 * @return list of possible BT
	 */
	public ArrayList<BinaryTreeNode> generateBinaryTrees(int n)
	{
		if(n==0)
			return generateAllPOssibleBT(1,0);;
		return generateAllPOssibleBT(1,n);
	}
	
	/**
	 * Method to create and return all possible trees from given number of nodes
	 * 
	 * @param start
	 * @param end
	 * @return list of possible BT
	 */
	public ArrayList<BinaryTreeNode> generateAllPOssibleBT(int start, int end)
	{
		ArrayList<BinaryTreeNode> subTrees = new ArrayList<BinaryTreeNode>();
		if(start > end)
		{
			subTrees.add(null);
			return subTrees;
		}
		for(int i=start; i <= end; i++)
		{
			for(BinaryTreeNode left : generateAllPOssibleBT(start, i-1))
			{
				for(BinaryTreeNode right : generateAllPOssibleBT(i+1, end))
				{
					BinaryTreeNode tree = new BinaryTreeNode(i);
					tree.setLeft(left);
					tree.setRight(right);
					subTrees.add(tree);
				}
			}
		}
		return subTrees;	
	}
	
	/**
	 * Method to create Binary Tree from give Post Order sequence of I and L
	 * I: Inner node
	 * L: Leaf Node
	 * 
	 * @param order
	 * @return BinaryTreeNode object formed from given order
	 */
	public BinaryTreeNode binaryTreeFromPreOrderIL(int[] order)
	{
		if(order == null)
		{
			return null;
		}
		return binaryTreeFromPreOrderIL(order, 0);
	}
	
	/**
	 * Method to create Binary Tree from give Post Order sequence of I and L
	 * I: Inner node
	 * L: Leaf Node
	 * 
	 * @param order
	 * @param i
	 * @return BinaryTreeNode object formed from given order and order index
	 */
	public BinaryTreeNode binaryTreeFromPreOrderIL(int[] order, int i)
	{
		if(order == null)
		{
			return null;
		}
		if(order.length == i)
		{
			return null;
		}
		
		BinaryTreeNode node = new BinaryTreeNode();
		node.setData(order[i]);
		node.setLeft(null);
		node.setRight(null);
		
		if(order[i]=='L')
			return node;
		i=i+1;
		node.setLeft(binaryTreeFromPreOrderIL(order, i));
		i=i+1;
		node.setRight(binaryTreeFromPreOrderIL(order, i));
		return node;
	}
	
	/*
	 * Global static variables to keep hold of last visited nodes in order to use
	 * them again in process of other nodes preOrder successor
	 */
	static BinaryTreeNode P = null;
	static Stack<BinaryTreeNode> S = new Stack<>();
	
	
	/**
	 * Method to get pre-order successor of a node in a Binary Tree
	 * 
	 * @param node
	 * @return
	 */
	public BinaryTreeNode getPreOrderSucessor(BinaryTreeNode node)
	{
		if(node != null)
		{
			P = node;
		}
		
		// If there is left of current node,
		// then push the current to stack and return the left node as pre-order successor
		if(P.getLeft() != null)
		{
			S.push(P);
			P = P.getLeft();
		}
		else // In case there is no left of current node
		{
			// Get the nodes from stack until there is right node of current node
			// This way we will get the right node of root of given node
			// means pre-order successor (right sibling) of a left most node
			while(P.getRight() == null)
			{
				P = S.pop();
			}
			P.getRight();
		}
		
		return P;
	}
	
}
