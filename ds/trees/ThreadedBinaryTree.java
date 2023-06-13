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
	
	
	public ThreadedBinaryTree getInOrderSuccessor123(ThreadedBinaryTree node)
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
	
	public ThreadedBinaryTree getPreOrderSuccessor123(ThreadedBinaryTree node)
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
	
	
	public ThreadedBinaryTree getPostOrderSuccessor(ThreadedBinaryTree node)
	{
		ThreadedBinaryTree root = getNodeRoot(node);
		ThreadedBinaryTree current = root;
		
		if(root.getRTag() == 0 || root.getRight() == node)
		{
			return root;
		}
		else
		{
			current = root.getRight();
			if(current.getLeft() == node)
			{
				return root;
			}
			while(current.getLTag() == 1)
			{
				current = current.getLeft();
			}
			return current;
		}
	}
	
	
	private ThreadedBinaryTree getNodeRoot(ThreadedBinaryTree node)
	{
		ThreadedBinaryTree current = node;
		ThreadedBinaryTree root;
		if(node.getRight() == node)
		{
			while(current.getLTag() == 1)
			{
				current = current.getLeft();
			}
			root = current;
		}
		else
		{
			if(current.getRTag() == 0)
			{
				root = current.getRight();
				if(root.getLeft() != node || root.getRight() == root)
				{
					root = current.getLeft();
				}
				
			}
			else
			{
				while(current.getRTag() == 1)
				{
					current = current.getRight();
				}
				
				root = current.getRight();
				
				if(root.getLeft() != node && root.getRight() == root)
				{
					current = node;
					while(current.getLTag() == 1)
					{
						current = current.getLeft();
					}
					root = current.getLeft();
				}
			}
		}
		return root;
	}
	
	
	
	
	public void postOrderTraversal(ThreadedBinaryTree root)
	{
		ThreadedBinaryTree node = root.getPostOrderSuccessor(root);
		do
		{
			System.out.println(node.getData());
			node = getPostOrderSuccessor(node);
		}while(node != root);
	}
	
	
	public void postOrderTraversal1(ThreadedBinaryTree root)
	{
		ThreadedBinaryTree node = root;
		while(true)
		{
			node = getPostOrderSuccessor(node);
			if(node == root)
			{
				return;
			}
			System.out.println(node.getData());
			
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
