package ds.trees;

public class ThreadedBinaryTree {
	
	int data;
	int LTag;
	int RTag;
	ThreadedBinaryTree left;
	ThreadedBinaryTree right;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public int getLTag() {
		return LTag;
	}
	public void setLTag(int lTag) {
		LTag = lTag;
	}
	public int getRTag() {
		return RTag;
	}
	public void setRTag(int rTag) {
		RTag = rTag;
	}
	public ThreadedBinaryTree getLeft() {
		return left;
	}
	public void setLeft(ThreadedBinaryTree left) {
		this.left = left;
	}
	public ThreadedBinaryTree getRight() {
		return right;
	}
	public void setRight(ThreadedBinaryTree right) {
		this.right = right;
	}
	
	
	/**
	 * Method to find the InOrder successor of a particular node in a InOrder Threaded Binary Tree
	 * 
	 * @param node
	 * @return InOrder successor node
	 * 
	 */
	
	public ThreadedBinaryTree getInOrderSuccessor(ThreadedBinaryTree node)
	{
		ThreadedBinaryTree currentNode;
		if(node.getRTag() == 0)
		{
			currentNode = node.getRight();
		}
		else
		{
			currentNode = node.getRight();
			while(currentNode.getLTag() == 1)
			{
				currentNode = currentNode.getLeft();
			}
		}
		
		return currentNode;
	}
	
	
	/**
	 * Method to do InOrder traversal from dummy node in a InOrder Threaded Binary Tree
	 * 
	 * @param node
	 * @return
	 * 
	 */
	
	public void inOrderTraversal(ThreadedBinaryTree root)
	{
		// To get the left most node from Dummy Node
		ThreadedBinaryTree rootNode = getInOrderSuccessor(root);
		do
		{
			System.out.println(rootNode.getData());
			// Traversing each node by getting InOrder successor from left most node
			rootNode = getInOrderSuccessor(rootNode);
		}while(rootNode != root);
	}
	
	
	/**
	 * Alternative approach to do InOrder traversal from dummy node in a InOrder Threaded Binary Tree
	 * 
	 * @param node
	 * @return
	 * 
	 */
	
	public void inOrderTraversal1(ThreadedBinaryTree root)
	{
		ThreadedBinaryTree rootNode = root;
		while(true)
		{
			// First call will give the left most node from dummy node 
			// then traversing each node by getting InOrder successor from that node
			rootNode = getInOrderSuccessor(rootNode);
			if(rootNode == root)
			{
				return;
			}
			System.out.println(rootNode.getData());
		}
	}
	
	
	/**
	 * Method to find the PreOrder successor of a particular node in a InOrder Threaded Binary Tree
	 * 
	 * @param node
	 * @return PreOrder successor node
	 * 
	 */
	
	public ThreadedBinaryTree getPreOrderSuccessor(ThreadedBinaryTree node)
	{
		if(node.getLTag() == 1)
		{
			return node.getLeft();
		}
		else
		{
			while(node.getRTag() == 0)
			{
				node = node.getRight();
			}
			return node.getRight();
		}
	}
	
	
	/**
	 * Method to do PreOrder traversal from dummy node in a InOrder Threaded Binary Tree
	 * 
	 * @param node
	 * @return
	 * 
	 */
	
	public void preOrderTraversal(ThreadedBinaryTree root)
	{
		// To get the root node from Dummy Node
		ThreadedBinaryTree rootNode = getPreOrderSuccessor(root);
		do
		{
			System.out.println(rootNode.getData());
			// Traversing each node by getting PreOrder successor from root node
			rootNode = getPreOrderSuccessor(rootNode);
		}while(rootNode != root);
	}
	
	
	/**
	 * Alternative approach to do PreOrder traversal from dummy node in a InOrder Threaded Binary Tree
	 * 
	 * @param node
	 * @return
	 * 
	 */
	
	public void preOrderTraversal1(ThreadedBinaryTree root)
	{
		ThreadedBinaryTree rootNode = root;
		while(true)
		{
			// First call will give the root node from dummy node 
			// then traversing each node by getting InOrder successor from that node
			rootNode = getPreOrderSuccessor(rootNode);
			if(rootNode == root)
			{
				return;
			}
			System.out.println(rootNode.getData());
		}
	}
	
	
	/**
	 * Method to get post-order successor of a node in InOrder Threaded Binary tree
	 * 
	 * @param node
	 * @return
	 */
	
	public ThreadedBinaryTree getPostOrderSuccessor(ThreadedBinaryTree node)
	{
		//Get the root of given node
		ThreadedBinaryTree root = getNodeRoot(node);
		ThreadedBinaryTree current = root;
		
		// If current's node root does not have right branch
		// or If current node is right of root node then return root as per post ordering
		if(root.getRTag() == 0 || root.getRight() == node)
		{
			return root;
		}
		else // If the current node is in the left of root, need to traverse the right branch of root to get the post order successor
		{
			// Get the right node of root
			current = root.getRight();
			
			// If root node is the dummy node 
			// and given node is the top most node being the left of dummy node
			// then, return root
			if(current.getLeft() == node)
			{
				return root;
			}
			
			// Traverse to the left most node of right branch to get the post order successor of given node
			while(current.getLTag() == 1)
			{
				current = current.getLeft();
			}
			return current;
		}
	}
	
	
	/**
	 * Method to get the root node of any node in in-Order Threaded Binary Tree
	 * 
	 * @param node
	 * @return
	 */
	
	private ThreadedBinaryTree getNodeRoot(ThreadedBinaryTree node)
	{
		ThreadedBinaryTree current = node;
		ThreadedBinaryTree root;

		// If rTag of given node is 0 then it will point to its inOrder successor
		if(current.getRTag() == 0)
		{
			root = current.getRight();
			
			/*
			 * If the root node's left is not the current node, 
			 * that means node is part of right branch, 
			 * hence get the left of current node which InOrder predecessor (root of right node)
			 */
			
			/*
			 * Or If root node right points to self, which means its dummy node 
			 * then root is the left of dummy node i.e., top most node
			 */
			if(root.getLeft() != node || root.getRight() == root)
			{
				root = current.getLeft();
			}
		}
		else // This block take care of scenarios when there is right branch of current node
		{
			// Traverse to get the left most node
			while(current.getLTag() == 1)
			{
				current = current.getLeft();
			}
			
			// Get the left of left most node to get the InOrder predecessor (root)
			root = current.getLeft();
			
			// If current node is a dummy node then just return the left most node
			if(node.getRight() == node)
			{
				return current;
			}
			
			// If the current node is not left or right of current root
			if(root.getRight() != node && root.getLeft() != node)
			{
				current = node;
				
				// Get the right most node
				// And then return InOrder successor of right most node
				while(current.getRTag() == 1)
				{
					current = current.getRight();
				}
				
				root = current.getRight();
			}
		}
		
		return root;
	}
	
	/**
	 * Method to do post-order traversal from dummy node in a in-Order Threaded Binary Tree
	 * 
	 * @param node
	 * 
	 */
	
	public void postOrderTraversal(ThreadedBinaryTree root)
	{
		// Traversing each node by getting PreOrder successor from root node
		ThreadedBinaryTree node = root.getPostOrderSuccessor(root);
		do
		{
			System.out.println(node.getData());
			
			// Traversing each node by getting PreOrder successor from root node
			node = getPostOrderSuccessor(node);
		}while(node != root);
	}
	
	
	/**
	 * Alternative approach to do post-order traversal from dummy node in a in-order Threaded Binary Tree
	 * 
	 * @param root
	 */
	
	public void postOrderTraversal1(ThreadedBinaryTree root)
	{
		ThreadedBinaryTree node = root;
		while(true)
		{
			// First call will give the root node from dummy node 
			// then traversing each node by getting InOrder successor from that node
			node = getPostOrderSuccessor(node);
			if(node == root)
			{
				return;
			}
			System.out.println(node.getData());
			
		}
	}
	
	
	/**
	 * Method to insert a node (Q) to the right of given node (P) in a in-order threaded binary tree
	 * 
	 * @param P
	 * @param Q
	 */
	
	public void InsertRightInInorderTBT(ThreadedBinaryTree P, ThreadedBinaryTree Q)
	{
		ThreadedBinaryTree temp;
		
		// Attach the new node (Q) to right of P
		Q.setRTag(P.getRTag());
		Q.setRight(P.getRight());
		Q.setLTag(0);
		Q.setLeft(P);
		P.setRight(Q);
		P.setRTag(1);
		
		/*
		 * In case right node of given node was not empty, then we need to change the
		 * left (InOrder predecessor) of left most node of right branch
		 */
		if(Q.getRTag() == 1)
		{
			temp = Q.getRight();
			while(temp.getLTag() == 1)
			{
				temp = temp.getLeft();
			}
			temp.setLeft(Q);
		}
	}
	
	public static void main(String[] args) {
		
		// Dummy Node
		ThreadedBinaryTree t1 = new ThreadedBinaryTree();
		ThreadedBinaryTree t2 = new ThreadedBinaryTree();
		ThreadedBinaryTree t3 = new ThreadedBinaryTree();
		ThreadedBinaryTree t4 = new ThreadedBinaryTree();
		ThreadedBinaryTree t5 = new ThreadedBinaryTree();
		ThreadedBinaryTree t6 = new ThreadedBinaryTree();
		ThreadedBinaryTree t7 = new ThreadedBinaryTree();
		ThreadedBinaryTree t8 = new ThreadedBinaryTree();
		ThreadedBinaryTree t9 = new ThreadedBinaryTree();
		ThreadedBinaryTree t10 = new ThreadedBinaryTree();
		
		t1.setData(-1);
		t1.setLTag(1);
		t1.setRTag(1);
		t1.setLeft(t2);
		t1.setRight(t1);
		
		t2.setData(1);
		t2.setLTag(1);
		t2.setRTag(1);
		t2.setLeft(t3);
		t2.setRight(t4);
		
		t3.setData(2);
		t3.setLTag(1);
		t3.setRTag(1);
		t3.setLeft(t5);
		t3.setRight(t6);
		
		t4.setData(3);
		t4.setLTag(1);
		t4.setRTag(1);
		t4.setLeft(t7);
		t4.setRight(t8);
		
		t5.setData(4);
		t5.setLTag(1);
		t5.setRTag(1);
		t5.setLeft(t9);
		t5.setRight(t10);	
		
		t6.setData(5);
		t6.setLTag(0);
		t6.setRTag(0);
		t6.setLeft(t3);
		t6.setRight(t2);
		
		t7.setData(6);
		t7.setLTag(0);
		t7.setRTag(0);
		t7.setLeft(t2);
		t7.setRight(t4);
		
		t8.setData(7);
		t8.setLTag(0);
		t8.setRTag(0);
		t8.setLeft(t4);
		t8.setRight(t1);
		
		t9.setData(8);
		t9.setLTag(0);
		t9.setRTag(0);
		t9.setLeft(t1);
		t9.setRight(t5);
		
		t10.setData(9);
		t10.setLTag(0);
		t10.setRTag(0);
		t10.setLeft(t5);
		t10.setRight(t3);
		
		System.out.println("============================================");
		t1.postOrderTraversal(t1);
		System.out.println("============================================");
		t1.postOrderTraversal1(t1);
		
	}
	
}
