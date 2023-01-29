package ds.linkedList;

class Node
{
	Node next;
	int numElements;
	CLLNode[] elements;
	
	public Node(int capacity) {
		super();
		this.next = null;
		this.numElements = 0;
		this.elements = new CLLNode[capacity];
	}
	
	
}
public class UnrolledList
{
	Node start;
	Node end;
	int nodeCapacity;
	int size;
	public UnrolledList(int nodeCapacity) {
		super();
		this.start = null;
		this.end = null;
		this.nodeCapacity = nodeCapacity;
		this.size = 0;
	}

	public void insert(int data)
	{
		CLLNode newElement = new CLLNode(data);
		if (start == null)
		{
			Node newNode = new Node(nodeCapacity);
			newElement.setNext(newElement);
			newNode.elements[0] = newElement;
			newNode.numElements++;
			newNode.next = null;
			size++;
			start = newNode;
			end = newNode;
		}
		else
		{
			if (end.numElements + 1 > nodeCapacity)
			{
				Node newNode = new Node(nodeCapacity);
				newNode.elements[0] = end.elements[nodeCapacity/2 + 1];
				int j = 1;
				for (int i = (nodeCapacity/2 + 2); i < nodeCapacity; i++)
				{
					newNode.elements[j] = end.elements[i];
					newNode.elements[j-1].setNext(newNode.elements[j]);
					j++;
				}
				end.numElements = nodeCapacity/2 + 1;
				end.elements[nodeCapacity/2].setNext(end.elements[0]);
				newNode.elements[j] = newElement;
				newNode.elements[j-1].setNext(newNode.elements[j]);
				newNode.elements[j].setNext(newNode.elements[0]);
				newNode.numElements = j + 1;
				end.next = newNode;
				newNode.next = null;
				end = newNode;
			}
			else
			{
				end.elements[end.numElements - 1].setNext(newElement);
				newElement.setNext(end.elements[0]);
				end.elements[end.numElements] = newElement;
				end.numElements = end.numElements + 1;
			}
		}
	}
	
	public void printElements()
	{
		Node temp = start;
		String elementsStr = "";
		while(temp!=null)
		{
			elementsStr = "";
			elementsStr = elementsStr + temp.elements[0].getData();
			for(int i = 1; i < temp.numElements; i++)
			{
				elementsStr = elementsStr + "," + temp.elements[i].getData();
				
			};
			System.out.println(elementsStr);
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		UnrolledList list = new UnrolledList(7);
		list.insert(1);
		list.insert(2);
		list.insert(3);
		list.insert(4);
		list.insert(5);
		list.insert(6);
		list.insert(7);
		list.insert(8);
		list.insert(9);
		list.insert(10);
		list.insert(11);
		list.insert(12);
		list.insert(13);
		list.insert(14);
		list.insert(15);
		
		list.printElements();
	}
}
