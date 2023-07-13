package ds.stacks;

public class DynamicArrayStack {
	
	int capacity;
	int[] stack;
	public static final int CAPACITY=10;
	public static int MINCAPACITY = 1<<15;
	int top = -1;
	
	public DynamicArrayStack() {
		this(CAPACITY);
	}

	public DynamicArrayStack(int capacity) {
		this.capacity = capacity;
		this.stack = new int[capacity];
	}
	
	public int size()
	{
		return (top + 1);
	}
	
	public boolean isEmpty()
	{
		return (top < 0);
	}
	
	public void push(int data)
	{
		if(size() == capacity)
		{
			expand();
		}
		stack[++top] = data;
		
	}
	
	private void expand()
	{
		int length = size();
		int[] newStack = new int[length << 1];
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
		this.capacity = this.capacity<<1;
	}
	
	private void shrink()
	{
		int length = size();
		if(length <= MINCAPACITY || top<<2 >= length)
		{
			return;
		}
		length = length + (top<<1);
		if(top <MINCAPACITY)
		{
			length = MINCAPACITY;
		}
		
		int[] newStack = new int[length];
		System.arraycopy(stack, 0, newStack, 0, length);
		stack = newStack;
		this.capacity = length;
	}
	
	public int pop() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is empty!!");
		}
		int data = stack[top];
		stack[top--] = Integer.MIN_VALUE;
		shrink();
		return data;
	}
	
	public int top() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is empty!!");
		}
		return stack[top];
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
		DynamicArrayStack stackObj = new DynamicArrayStack(5);
		try
		{
			stackObj.push(1);
			stackObj.push(2);
			stackObj.push(3);
			stackObj.push(4);
			stackObj.push(5);
			stackObj.push(6);
			
			System.out.println(stackObj.toString());
			System.out.println(stackObj.capacity);
			
			System.out.println(stackObj.top());
			
			stackObj.pop();
			stackObj.pop();
			stackObj.pop();
			System.out.println(stackObj.toString());
			stackObj.pop();
			stackObj.pop();
			stackObj.pop();
			
			System.out.println(stackObj.toString());
			System.out.println(stackObj.top + 1);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
