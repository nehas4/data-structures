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
}
