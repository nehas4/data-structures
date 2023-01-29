package ds.queues;

class ListNode
{
	int data;
	ListNode next;

	public ListNode(int data) {
		this.data = data;
	}
	
}

public class LinkedQueue 
{
	private int size;
	private ListNode front, rear;
	
	public LinkedQueue() {
		this.size = 0;
		this.front = this.rear = null;
	}
	
	public LinkedQueue(int data)
	{
		ListNode node = new ListNode(data);
		node.next=null;
		front = rear = node;
		size++;
	}
	
	public boolean isEmpty()
	{
		return (size < 0);
	}
	
	public void enqueue(int data)
	{
		ListNode newNode = new ListNode(data);
		if(isEmpty())
		{
			front = newNode;
		}
		else
		{
			rear.next = newNode;	
		}
		rear=newNode;
		size++;
	}
	
	public int dequeue() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Queue is empty!!");
		}
		
		int toDelete = front.data;
		front = front.next;
		size--;
		return toDelete;
	}
	
	public int first() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is empty!!");
		}
		
		return front.data;
	}
	
	public int size()
	{
		return size;
	}
	
	public String toString()
	{
		String str = "";
		if(!isEmpty())
		{
			str = str + "[" + front.data;
			ListNode temp = front.next;
			while(temp != null)
			{
				str = str + ", " + temp.data;
				temp = temp.next;
			}
			str = str + "]";
		}
		return str;
	}
	
	public static void main(String[] args) {
		LinkedQueue obj = new LinkedQueue(1);
		obj.enqueue(2);
		obj.enqueue(3);
		obj.enqueue(4);
		obj.enqueue(5);
		
		System.out.println(obj.toString());
		
		try
		{
			obj.dequeue();
			obj.dequeue();
			obj.dequeue();
			
			System.out.println(obj.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
