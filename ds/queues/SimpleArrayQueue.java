package ds.queues;

import ds.stacks.ArrayStack;

public class SimpleArrayQueue
{
	int[] Q;
	int size=0;
	static int CAPACITY=10;
	int capacity;
	int front=0;
	int rear=0;
	
	public SimpleArrayQueue() {
		this.capacity=CAPACITY;
		Q=new int[CAPACITY];
	}
	
	public SimpleArrayQueue(int capacity) {
		this.capacity=capacity;
		Q=new int[capacity];
	}

	public void enqueue(int data) throws Exception
	{
		if(size==capacity)
		{
			throw new Exception("Cannot insert. Queue is full!!");
		}

		Q[rear]=data;
		rear++;
		if(rear>= capacity)
		{
			rear = 0;
		}
		size++;
	}
	
	public int dequeue() throws Exception
	{
		if(size==0)
		{
			throw new Exception("Cannot delete. Queue is empty!!");
		}
		int toDelete = Q[front++];
		if(front >= capacity)
		{
			front = 0;
		}
		size--;
		return toDelete;
	}
	
	public String toString()
	{
		String qStr = "";
		if(front != -1)
		{
			qStr = qStr + Q[front];
		}
		for(int i=front+1; i<capacity; i++)
		{
			qStr = qStr + ", " + Q[i];
		}
		return qStr;
	}
	
	public SimpleArrayQueue reverseQ(SimpleArrayQueue queue) throws Exception
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
	
	public static void main(String[] args) {
		try
		{
			SimpleArrayQueue queue = new SimpleArrayQueue(5);
			queue.enqueue(1);
			queue.enqueue(2);
			queue.enqueue(3);
			queue.enqueue(4);
			queue.enqueue(5);
			//queue.enqueue(6);
			
			System.out.println(queue.toString());
			
//			queue.dequeue();
//			queue.dequeue();
//			queue.dequeue();
//			queue.dequeue();
//			System.out.println(queue.toString());
//			
//			queue.dequeue();
//			queue.dequeue();
//			
//			System.out.println(queue.toString());
			
			System.out.println(queue.reverseQ(queue).toString());
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
}
