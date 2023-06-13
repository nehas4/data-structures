package ds.trees;

import java.util.Arrays;

public class TreeAlgorithms {
	
	/*
	 * Given a parent array P, where P[i] indicates the parent of ith node in the
	 * tree (assume parent of root node is indicated with –1). Give an algorithm for
	 * finding the height or depth of the tree
	 * 
	 * Eg: Values(parent node) -1	0	1	6	6	0	0	2	7
	 * 		Indices(node)		0	1	2	3	4	5	6	7	8
	 * 
	 * Depth of above tree is 4.
	 */
	
	/**
	 * Method to find the Depth of Generic tree based on array of Parents given using loop
	 * 
	 * @param P
	 * @return Depth of the given of generic tree
	 * 
	 */
	public int FindDepthInGenericTree(int[] P)
	{
		int maxDepth = -1, currentDepth = -1, j;
		
		for(int i = 0; i < P.length; i++)
		{
			currentDepth = 0; j = i;
			
			while(P[j] != -1)
			{
				currentDepth++;
				j = P[j];
			}
			
			if(currentDepth > maxDepth)
			{
				maxDepth = currentDepth;
			}
		}
		
		return maxDepth;
	}
	
	
	
	// Different approach for above problem
	
	/**
	 * Method to find the Depth of Generic tree based on array of Parents given by sort array
	 * 
	 * @param P
	 * @return Depth of the given of generic tree
	 * 
	 */
	public int FindDepthInGenericTree1(int[] P)
	{
		
		Arrays.sort(P);
		int maxDepth = 0, prevNodeParent = P[0];
		
		for(int i = 0; i < P.length - 1; i++)
		{
			if(P[i] != prevNodeParent)
			{
				maxDepth++;
			}
			
			prevNodeParent = P[i];
		}
		
		return maxDepth;
	}
	
	
	
	/*
	 * Given two trees how do we check whether the trees are isomorphic to each
	 * other or not
	 * 
	 * Two binary trees are isomorphic if they have the same structure irrespective of values.
	 */
	
	/**
	 * Checks whether the given 2 trees are Isomorphic or not
	 * 
	 * @param root1
	 * @param root2
	 * @return returns boolean value result if trees are Isomorphic or not
	 * 
	 */
	public boolean isIsomorphicTree(BinaryTreeNode root1, BinaryTreeNode root2)
	{
		if(root1 == null && root2 == null)
		{
			return true;
		}
		if((root1 == null && root2 != null) || (root1 != null && root2 == null))
		{
			return false;
		}
		
		return (isIsomorphicTree(root1.getLeft(), root2.getLeft())) && (isIsomorphicTree(root1.getRight(), root2.getRight()));
	}
	
	
	
	/*
	 * Given two trees how do we check whether the trees are isomorphic to each
	 * other or not
	 * 
	 * Trees having identical structure or obtained by swapping (or mirror binary tree) 
	 * its children are called Quasi isomorphic trees (Data is not considered)
	 */
	
	/**
	 * Checks whether the given 2 trees are Quasi-Isomorphic or not
	 * 
	 * @param root1
	 * @param root2
	 * @return returns boolean value result if trees are Quasi-Isomorphic or not
	 * 
	 */
	public boolean isQuasiIsomorphicTree(BinaryTreeNode root1, BinaryTreeNode root2)
	{
		if(root1 == null && root2 == null)
		{
			return true;
		}
		if((root1 == null && root2 != null) || (root1 != null && root2 == null))
		{
			return false;
		}
		
		// Either the structure should be identical or by swapping the left/right children
		return ((isIsomorphicTree(root1.getLeft(), root2.getLeft())) && (isIsomorphicTree(root1.getRight(), root2.getRight())))
				|| ((isIsomorphicTree(root1.getLeft(), root2.getRight())) && (isIsomorphicTree(root1.getRight(), root2.getLeft())));
	}
	
	public static void main(String[] args) {
		
		TreeAlgorithms algo = new TreeAlgorithms();
		
		int P[] = new int[] {-1, 0, 1, 6, 6, 0, 0, 2, 7};
		
		System.out.println(algo.FindDepthInGenericTree(P));
		System.out.println(algo.FindDepthInGenericTree1(P));
	}
	
}
