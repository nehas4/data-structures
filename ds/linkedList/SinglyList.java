package ds.linkedList;

class ListNode {
	private int Data;
	private ListNode next;
	
	public ListNode(int data) {
		Data = data;
	}
	public int getData() {
		return Data;
	}
	public void setData(int data) {
		Data = data;
	}
	public ListNode getNext() {
		return next;
	}
	public void setNext(ListNode next) {
		this.next = next;
	}
}

public class SinglyList {
	int length=0;
	ListNode head;
	
	public SinglyList()
	{
		length=0;
	}

	public synchronized ListNode getHead()
	{
		return head;
	}
	
	public synchronized void insertAtBegin(ListNode node)
	{
		node.setNext(head);
		head=node;
		length++;
	}
	
	public synchronized void insertAtEnd(ListNode node)
	{
		node.setNext(null);
		if(head == null)
		{
			head=node;
		}
		else
		{
			ListNode endNode = head;
			while(endNode.getNext()!=null)
			{
				endNode = endNode.getNext();
			}
			endNode.setNext(node);
		}
		length++;
	}
	
	public synchronized void insert(ListNode node, int position)
	{
		if(position < 0)
		{
			position = 0;
		}
		else if(position > length)
		{
			position = length;
		}
		if(head == null)
		{
			head=node;
			head.setNext(null);
		}
		
		if(position == 0)
		{
			node.setNext(head);
			head = node;
		}
		else
		{
			ListNode prevNode = head, temp = head.getNext();
			int insertPos = 1;
			while(temp != null)
			{
				if(insertPos == position)
				{
					node.setNext(temp);
					prevNode.setNext(node);
				}	
				insertPos++;
				prevNode=temp;
				temp = temp.getNext();
			}
		}
		length++;
	}
	
	public synchronized ListNode removeFromBegin()
	{
		if(head == null)
		{
			System.out.println("List is empty!");
			return null;
		}
		else
		{
			ListNode node = head;
			head = head.getNext();
			node.setNext(null);
			length--;
			return node;
		}

	}
	
	public synchronized ListNode removeFromEnd()
	{
		if(head == null)
		{
			System.out.println("List is empty!");
			return null;
		}
		else
		{
			ListNode temp = head, secondLast=null;
			if(head.getNext() == null)
			{
				head = null;
				return temp; 
			}
			while(temp.getNext() != null)
			{
				secondLast = temp;
				temp = temp.getNext();
			}
			secondLast.setNext(null);
			length--;
			return temp;
		}

	}
	
	public synchronized ListNode removeMached(ListNode node)
	{
		if(head == null)
		{
			System.out.println("List is empty!");
			return null;
		}
		else
		{
			ListNode temp = head;
			if(node.equals(head))
			{
				head = null;
				length--;
				return temp;
			}
			
			ListNode before=temp;
			temp = temp.getNext();
			while(temp != null)
			{
				if(node.equals(temp))
				{
					before.setNext(temp.getNext());
					length--;
					return temp;
				}
				temp = temp.getNext();
			}
			return null;
		}
	}
	
	public synchronized ListNode removeAtPosition(int position)
	{
		if(position < 0)
		{
			position = 0;
		}
		else if(position > length)
		{
			position = length;
		}
		if(head == null)
		{
			System.out.println("List is empty!");
			return null;
		}
		else
		{
			ListNode temp = head;
			if(position == 0)
			{
				head = null;
				return temp;
			}
			int removePos = 1;
			ListNode before = temp;
			temp = temp.getNext();
			while(temp != null && removePos != position)
			{
				removePos++;
				before = temp;
				temp = temp.getNext();
			}
			before.setNext(temp.getNext());
			temp.setNext(null);
			length--;
			return temp;
		}
	}
	
	public String toString()
	{
		String result = "[";
		if(head == null)
		{
			result+="]";
		}
		else
		{
			result = result + head.getData();
			ListNode node = head.getNext();
			while(node != null)
			{
				result = result + ", "+node.getData();
				node = node.getNext();
			}
			result = result + "]";
		}
		return result;
	}
	
	public int length()
	{
		return length;
	}
	
	public int getPosition(int data)
	{
		if(head == null)
		{
			System.out.println("List is empty!");
			return -1;
		}
		else
		{
			ListNode temp = head;
			int position = 0;
			while(temp != null)
			{
				if(temp.getData() == data)
				{
					return position;
				}
				position++;
				temp = temp.getNext();
			}
			return -1;
		}
	}
	
	public void clearList()
	{
		head = null;
		length = 0;
	}
	
	public static void main(String[] args) {
		
		SinglyList singlyList = new SinglyList();
		ListNode node1 = new ListNode(1);
		singlyList.insertAtEnd(node1);
		ListNode node2 = new ListNode(2);
		singlyList.insertAtBegin(node2);
		ListNode node3 = new ListNode(3);
		singlyList.insert(node3, 1);
		ListNode node4 = new ListNode(4);
		singlyList.insertAtEnd(node4);
		ListNode node5 = new ListNode(5);
		singlyList.insertAtEnd(node5);
		
		System.out.println("List length="+singlyList.length());
		System.out.println(singlyList.toString());
		
		System.out.println();
		System.out.println("Position of 3="+singlyList.getPosition(3));
		
		System.out.println();
		singlyList.removeFromBegin();
		System.out.println("singlyList.removeFromBegin()");
		System.out.println("List length="+singlyList.length());
		System.out.println(singlyList.toString());
		
		System.out.println();
		singlyList.removeFromEnd();
		System.out.println("singlyList.removeFromEnd()");
		System.out.println("List length="+singlyList.length());
		System.out.println(singlyList.toString());
		
		System.out.println();
		singlyList.removeAtPosition(2);
		System.out.println("singlyList.removeAtPosition()");
		System.out.println("List length="+singlyList.length());
		System.out.println(singlyList.toString());
		
		System.out.println();
		singlyList.removeMached(node1);
		System.out.println("singlyList.removeMached()");
		System.out.println("List length="+singlyList.length());
		System.out.println(singlyList.toString());
		
		System.out.println();
		singlyList.clearList();
		System.out.println("singlyList.clearList()");
		System.out.println("List length="+singlyList.length());
		System.out.println(singlyList.toString());
		
		System.out.println();
		singlyList.removeFromBegin();
		System.out.println("singlyList.removeFromBegin()");
		System.out.println("List length="+singlyList.length());
		System.out.println(singlyList.toString());
	}
}
