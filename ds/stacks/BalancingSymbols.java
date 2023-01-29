package ds.stacks;

import java.util.Arrays;
import java.util.List;

class Stack<E>
{
	E[] stack;
	int top=-1;
	static final int CAPACITY=10;
	int capacity;
	
	public Stack(E[] stack, int capacity)
	{
		this.stack = stack;
		this.capacity = capacity;
	}
	
	public int size()
	{
		return (this.top + 1);
	}
	
	boolean isEmpty()
	{
		return (top < 0);
	}
	
	public void push(E data) throws Exception
	{
		if (size() == this.capacity)
		{
			throw new Exception("Stack is full!!");
		}
		stack[++top] = data;
	}
	
	public E top() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is empty!!");
		}
		return stack[top];
	}
	
	public E pop() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is empty!!");
		}
		E data = stack[top];
		stack[top--] = null;
		return data;
	}
	
	public E peek() throws Exception
	{
		if(isEmpty())
		{
			throw new Exception("Stack is empty!!");
		}
		return stack[top];
	}
	
}
public class BalancingSymbols {
	
	public boolean isBalanced(String exp)
	{
		try
		{
			Stack<Character> stack = new Stack<Character>(new Character[exp.length()], exp.length());
			List<Character> beginChar = Arrays.asList('(', '[', '{');
			List<Character> endChar = Arrays.asList(')', ']', '}');
			Character c;
			for(int i = 0; i < exp.length(); i++)
			{
				c = exp.charAt(i);
				if(beginChar.contains(c))
				{
					stack.push(c);
				}
				else if(endChar.contains(c))
				{
					Character topChar = stack.peek();
					switch(c)
					{
						case ')': 
									if(topChar.equals('('))
									{
										stack.pop();
									}
									else
										return false;
									break;
						case ']':
									if(topChar.equals('['))
									{
										stack.pop();
									}
									else
										return false;
									break;
						case '}':
									if(topChar.equals('{'))
									{
										stack.pop();
									}
									else
										return false;
									break;
					}
				}
			}
			if(!stack.isEmpty())
			{
				return false;
			}
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
	
	public void expEvaluation(String exp) throws Exception
	{
		Stack<Integer> stack = new Stack<Integer>(new Integer[exp.length()], exp.length());
		for(int i = 0; i < exp.length(); i++)
		{
			String c = String.valueOf(exp.charAt(i));
			if(c.equals("+"))
			{
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a+b);
			}
			else if(c.equals("-"))
			{
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b-a);
			}
			else if(c.equals("*"))
			{
				int a = stack.pop();
				int b = stack.pop();
				stack.push(a*b);
			}
			else if(c.equals("/"))
			{
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b/a);
			}
			else
				stack.push(Integer.parseInt(c));
		}
		
		System.out.println("Result="+stack.pop());
	}
	
	public static void main(String[] args) {
		String str = "(a+(b{c*d-[e\f]}))";
		BalancingSymbols obj = new BalancingSymbols();
		//System.out.println(obj.isBalanced(str));
		
		try {
			obj.expEvaluation("123*+5-");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
