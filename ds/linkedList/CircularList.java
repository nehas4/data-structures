package ds.linkedList;


class CLLNode
{
	private int data;
	private CLLNode next;
	
	public CLLNode(int data, CLLNode next) {
		super();
		this.data = data;
		this.next = next;
	}
	
	public CLLNode(int data) {
		super();
		this.data = data;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public CLLNode getNext() {
		return next;
	}
	public void setNext(CLLNode next) {
		this.next = next;
	}
	
}
public class CircularList 
{
	CLLNode tail=null;
	int length=0;
	
	public void insertAtHead(int data)
	{
		CLLNode newNode = new CLLNode(data);
		if(tail == null)
		{
			newNode.setNext(newNode);
			tail = newNode;
		}
		else
		{
			newNode.setNext(tail.getNext());
			tail.setNext(newNode);
		}
		length++;
	}
	
	public void insertAtEnd(int data)
	{
		insertAtHead(data);
		tail = tail.getNext();
	}
	
	public void insertAtPos(int data, int position)
	{
		if(position < 0)
		{
			position = 0;
		}
		else if(position > length)
		{
			position = length;
		}
		CLLNode newNode = new CLLNode(data);
		if (tail == null)
		{
			newNode.setNext(newNode);
			tail = newNode;
		}
		else
		{
			CLLNode tempNode = tail;
			for (int i = 1; i < position; i++)
			{
				tempNode = tempNode.getNext();
			}
			
			newNode.setNext(tempNode.getNext());
			tempNode.setNext(newNode);
			
		}
		length++;
	}
	
	public void removeAtHead()
	{
		if(tail == null)
		{
			System.out.println("List is Empty!!!!");
			return;
		}
		else
		{
			CLLNode toDelete = tail.getNext();
			if(tail == toDelete)
			{
				tail = null;
			}
			else
			{
				tail.setNext(toDelete.getNext());
				toDelete = null;
			}
			length--;
		}
	}
	
	public void removeAtTail()
	{
		if(tail == null)
		{
			System.out.println("List is Empty!!!!");
			return;
		}
		else
		{
			CLLNode toDelete = tail;
			if(tail.getNext() == toDelete)
			{
				tail = null;
			}
			else
			{
				CLLNode tempNode = tail.getNext();
				while(tempNode.getNext() != tail)
				{
					tempNode = tempNode.getNext();
				}
				tempNode.setNext(tail.getNext());
				tail = tempNode;
			}
			length --;
		}
	}
	
	public void removeData(int data)
	{
		if(tail == null)
		{
			System.out.println("List is Empty!!!!");
			return;
		}
		else
		{
			if(tail.getData() == data)
			{
				if(tail == tail.getNext())
				{
					tail = null;
				}
				else
				{
					removeAtTail();
				}
			}
			else
			{
				CLLNode tempNode = tail.getNext();
				CLLNode prevNode = tail;
				while(tempNode.getData() != data)
				{
					prevNode = tempNode;
					tempNode = tempNode.getNext();
				}
				prevNode.setNext(tempNode.getNext());
				tempNode = null;
			}
			length --;
		}
	}
	
	public int peek()
	{
		return tail.getNext().getData();
	}
	
	public int peekAtTail()
	{
		return tail.getData();
	}
	
	public int getPosition(int data)
	{
		if (tail == null)
		{
			System.out.println("List is Empty!!!!");
			return -1;
		}
		else
		{
			int pos = 0;
			CLLNode temp = tail.getNext();
			while(temp != tail)
			{
				pos ++;
				if(temp.getData() == data)
				{
					return pos;
				}
				temp = temp.getNext();
			}
			
			if(tail.getData() == data)
			{
				return pos ++;
			}
			return -1;
		}
	}
	
	public String toString()
	{
		String list="";
		if(tail == null)
		{
			System.out.println("List is Empty!!!!");
			return list;
		}
		CLLNode startNode = tail.getNext();
		list = "{"+startNode.getData();
		while(startNode.getNext() != tail)
		{
			startNode = startNode.getNext();
			list = list + ", "+startNode.getData();
		}
		list = list + ", "+tail.getData() + "}";
		return list;
	}
	
	public int getLength()
	{
		return length;
	}
	
	public void clearList()
	{
		length = 0;
		tail = null;
	}
	
	public static void main(String[] args) {
		CircularList list = new CircularList();
		list.insertAtHead(1);
		list.insertAtHead(2);
		
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		
		list.insertAtPos(5, 2);
		list.insertAtPos(6, 5);
		
		System.out.println(list.toString());
		System.out.println("length 1="+list.getLength());
		
		list.removeAtHead();
		System.out.println(list.toString());
		
		list.removeAtTail();
		System.out.println(list.toString());
		
		list.removeData(3);
		System.out.println(list.toString());
		System.out.println("length 2="+list.getLength());
		
		System.out.println("peek="+list.peek());
		System.out.println("peek at tail="+list.peekAtTail());
		
		list.clearList();
		System.out.println("length 2="+list.getLength());
		System.out.println(list.toString());
	}
}
