package ds.stacks;

public class ArrayStack {
	
	int[] stack;
	int top=-1;
	static final int CAPACITY=10;
	int capacity;

	public ArrayStack() {
		this(CAPACITY);
	}
	
	public ArrayStack(int cap) {
		this.capacity = cap;
		this.stack = new int[capacity];
	}
	
	public int size()
	{
		return (this.top + 1);
	}
	
	boolean isEmpty()
	{
		return (top < 0);
	}
	
	public void push(int data) throws Exception
	{
		if (size() == this.capacity)
		{
			throw new Exception("Stack is full!!");
		}
		stack[++top] = data;
	}
	
	public int top() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is empty!!");
		}
		return stack[top];
	}
	
	public int pop() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is empty!!");
		}
		int data = stack[top];
		stack[top--] = Integer.MIN_VALUE;
		return data;
	}
	
	public String toString()
	{
		String stackStr = "";
		if(!isEmpty())
		{
			stackStr = stackStr + "[" +stack[0];
			int size = size();
			for (int i = 1; i < size; i++)
			{
				stackStr = stackStr + ", " + stack[i];
			}
			
			stackStr = stackStr + "]";
		}
		
		return stackStr;
	}

	public static void main(String[] args) {
		ArrayStack stackObj = new ArrayStack(5);
		try
		{
			stackObj.push(1);
			stackObj.push(2);
			stackObj.push(3);
			stackObj.push(4);
			stackObj.push(5);
			//stackObj.push(6);
			
			System.out.println(stackObj.toString());
			
			System.out.println(stackObj.top());
			
			stackObj.pop();
			stackObj.pop();
			stackObj.pop();
			System.out.println(stackObj.toString());
			stackObj.pop();
			//stackObj.pop();
			//stackObj.pop();
			
			System.out.println(stackObj.toString());
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
