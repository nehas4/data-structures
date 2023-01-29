package ds.stacks;

class ListNode
{
	int data;
	ListNode next;

	public ListNode(int data) {
		this.data = data;
	}
	
}

public class LinkedListStack 
{
	int length;
	private ListNode top;
	
	public LinkedListStack() {
		this.length = 0;
		this.top = null;
	}
	
	public LinkedListStack(int data) {
		
		this.top = new ListNode(data);
		top.next = null;
		this.length = length++;
	}
	
	public boolean isEmpty()
	{
		return (length < 0);
	}
	
	public void push(int data)
	{
		ListNode newNode = new ListNode(data);
		newNode.next = top;
		top = newNode;
		length++;
	}
	
	public int pop() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is empty!!");
		}
		
		int toDelete = top.data;
		top = top.next;
		length--;
		return toDelete;
	}
	
	public int peek() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is empty!!");
		}
		
		return top.data;
	}
	
	public int size()
	{
		return length;
	}
	
	public String toString()
	{
		String str = "";
		if(!isEmpty())
		{
			str = str + "[" + top.data;
			ListNode temp = top.next;
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
		LinkedListStack obj = new LinkedListStack(1);
		obj.push(2);
		obj.push(3);
		obj.push(4);
		obj.push(5);
		
		System.out.println(obj.toString());
		
		try
		{
			obj.pop();
			obj.pop();
			obj.pop();
			
			System.out.println(obj.toString());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
