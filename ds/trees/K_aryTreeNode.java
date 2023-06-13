package ds.trees;

public class K_aryTreeNode {
	
	int data;
	K_aryTreeNode[] child;
	
	// Global variable to keep track of current array value to be processed while creating the nodes
	int currIndex = 0;
	
	public K_aryTreeNode(int k)
	{
		child = new K_aryTreeNode[k];
	}
	
	public int getData() {
		return data;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public K_aryTreeNode getChild(int i) {
		return child[i];
	}
	
	public void setChild(int i, K_aryTreeNode child) {
		this.child[i] = child;
	}
	
	
	/* A full k –ary tree is a tree where each node has either 0 or k children */
	
	/**
	 * Method to build a k-ary tree using given array with pre-order traversal
	 * 
	 * @param A
	 * @param k
	 * @return k-ary tree
	 * 
	 */
	public K_aryTreeNode buildK_aryTree(int A[], int k)
	{
		int n = A.length;
		if(n <= 0)
		{
			return null;
		}
		
		K_aryTreeNode newNode = new K_aryTreeNode(k);
		newNode.setData(data);
		
		// Loop k times for each node to create its k no of children
		for(int i = 0; i < k; i++)
		{
			// Check if the current index to be processed in array is less than its length
			if((k * currIndex + 1) < n)
			{
				newNode.setChild(currIndex, buildK_aryTree(A, k));
			}
			
			// if no value present in array for current index to be child then make null child
			else newNode.setChild(currIndex, null);
		}
		
		return newNode;
	}
	 
}
