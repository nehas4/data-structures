package ds.queues;

import ds.stacks.ArrayStack;

public class SimpleArrayQueue1
{
	private int queue[];
	private int size, front, rear, capacity;
	private static final int CAPACITY=16;
	
	public SimpleArrayQueue1()
	{
		queue = new int[CAPACITY];
		this.capacity=CAPACITY;
		size=0;
		front=0;
		rear=0;
	}
	
	public SimpleArrayQueue1(int cap)
	{
		queue = new int[cap];
		this.capacity=cap;
		size=0;
		front=0;
		rear=0;
	}
	
	public void enqueue(int data)
	{
		if(size==capacity)
		{
			throw new IllegalStateException("Queue is full: Overflow");
		}
		queue[rear]=data;
		rear=(rear+1)%capacity;
		size++;
	}
	
	public int dequeue()
	{
		if(size == 0)
		{
			throw new IllegalStateException("Queue is empty: Underflow");
		}
		int data = queue[front];
		queue[front]=Integer.MIN_VALUE;
		front = (front+1)%capacity;
		size--;
		return data;
	}
	
	public boolean isEmpty()
	{
		return (size==0);
	}
	
	public boolean isFull()
	{
		return (size == capacity);
	}
	
	public int size()
	{
		return size;
	}
	
	public String toString()
	{
		String qStr="[";
		for(int i = 0; i<size; i++)
		{
			qStr += Integer.toString(queue[(front + i) % capacity]);
			if(i < size - 1)
			{
				qStr +=", ";
			}
		}
		qStr +="]";
		return qStr;
	}
	
	public SimpleArrayQueue1 reverseQ(SimpleArrayQueue1 queue) throws Exception
	{
		ArrayStack stack = new ArrayStack(queue.size);
		while(queue.size > 0)
		{
			stack.push(queue.dequeue());
		}
		while(stack.size() > 0)
		{
			queue.enqueue(stack.pop());
		}
		return queue;
	}
	
	public SimpleArrayQueue1 reverHalfQ(SimpleArrayQueue1 queue) throws Exception
	{
		int halfsize = queue.capacity/2;
		ArrayStack stack = new ArrayStack(halfsize);
		while(queue.size > halfsize)
		{
			stack.push(queue.dequeue());
		}
		while(stack.size() > 0)
		{
			queue.enqueue(stack.pop());
		}
		for(int i = 0; i < halfsize; i++)
		{
			queue.enqueue(queue.dequeue());
		}
		return queue;
	}
	
	public SimpleArrayQueue1 inteLeavingQElement(SimpleArrayQueue1 queue) throws Exception
	{
		int halfsize = queue.capacity/2;
		ArrayStack stack = new ArrayStack(halfsize);
		while(queue.size > halfsize)
		{
			stack.push(queue.dequeue());
		}
		while(stack.size() > 0)
		{
			queue.enqueue(stack.pop());
		}
		for(int i = 0; i < halfsize; i++)
		{
			queue.enqueue(queue.dequeue());
		}
		for(int i = 0; i < halfsize; i++)
		{
			stack.push(queue.dequeue());
		}
		for(int i = 0; i < halfsize; i++)
		{
			queue.enqueue(stack.pop());
			queue.enqueue(queue.dequeue());
			
		}
		
		return queue;
	}
	
	
	public static void main(String[] args)
	{
		SimpleArrayQueue1 Q = new SimpleArrayQueue1(6);
		Q.enqueue(1);
		Q.enqueue(2);
		Q.enqueue(3);
		Q.enqueue(4);
		Q.enqueue(5);
		Q.enqueue(6);
		System.out.println("Queue: "+Q.toString());
		
//		Q.dequeue();
//		Q.dequeue();
		try {
			System.out.println("Reverse Queue: "+Q.reverseQ(Q).toString());
			System.out.println("Reverse Half Queue: "+Q.reverHalfQ(Q).toString());
			System.out.println("Intervene Queue Elements: "+Q.inteLeavingQElement(Q).toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
