package ds.stacks;

public class ReverseStack {
	
	public void insertAtBottom(ArrayStack stack, int data) throws Exception
	{
		if(stack.isEmpty())
		{
			stack.push(data);
			return;
		}
		int temp = stack.pop();
		insertAtBottom(stack, data);
		stack.push(temp);
		
	}

	public void reverseStack(ArrayStack stack) throws Exception
	{
		if (stack.isEmpty())
		{
			return;
		}
		
		int temp = stack.pop();
		reverseStack(stack);
		insertAtBottom(stack, temp);
	}
	
	public static void main(String[] args)
	{
		try
		{
			ArrayStack stack = new ArrayStack(5);
			stack.push(1);
			stack.push(2);
			stack.push(3);
			stack.push(4);
			stack.push(5);
			
			ReverseStack obj = new ReverseStack();
			obj.reverseStack(stack);
			
			System.out.println(stack.toString());
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
