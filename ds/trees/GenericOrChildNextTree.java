package ds.trees;

public class GenericOrChildNextTree {
	private int data;
	private GenericOrChildNextTree firstChild;
	private GenericOrChildNextTree nextSibling;
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public GenericOrChildNextTree getFirstChild() {
		return firstChild;
	}
	public void setFirstChild(GenericOrChildNextTree firstChild) {
		this.firstChild = firstChild;
	}
	public GenericOrChildNextTree getNextSibling() {
		return nextSibling;
	}
	public void setNextSibling(GenericOrChildNextTree nextSibling) {
		this.nextSibling = nextSibling;
	}
	
	/**
	 * Method to return sum of all nodes in Child/Next Tree
	 * 
	 * @param node
	 * @return sum of all nodes in integer
	 */
	public int findSum(GenericOrChildNextTree node)
	{
		if(node == null)
			return 0;
		return node.getData() + findSum(node.getFirstChild()) + findSum(node.getNextSibling());
	}
	
	/**
	 * Method to find the number of siblings of a given node in generic tree
	 * 
	 * @param node
	 * @return Siblings count
	 */
	public int SiblingsCount(GenericOrChildNextTree node)
	{
		int count = 0;
		
		while(node != null)
		{
			count++;
			node = node.getNextSibling();
		}
		
		return count;
	}
	
	/**
	 * Method to return the number children of a given node in Generic Tree
	 * 
	 * @param node
	 * @return
	 */
	public int childCount(GenericOrChildNextTree node)
	{
		int count = 0;
		node = node.getFirstChild();
		while(node != null)
		{
			count++;
			node = node.getNextSibling();
		}
		return count;
	}
}
