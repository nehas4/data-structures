package ds.queues;

public class DynamicArrayQueue
{
	private int[] queue;
	private int size, front, rear, capacity;
	private static final int CAPACITY=16;
	private static final int MINCAPACITY=1<<15;
	
	public DynamicArrayQueue()
	{
		queue=new int[CAPACITY];
		this.capacity=CAPACITY;
		size=front=rear=0;
	}
	
	public DynamicArrayQueue(int capacity)
	{
		queue=new int[capacity];
		this.capacity=capacity;
		size=front=rear=0;
	}
	
	public void enqueue(int data)
	{
		if(size == capacity)
		{
			expand();
		}
		queue[rear] = data;
		rear=(rear+1)%capacity;
		size++;
	}
	
	public void expand()
	{
		int[] newQ = new int[capacity<<1];
		for(int i=0; i<size; i++)
		{
			newQ[i] = queue[front+i];
			//newQ[i-front]=queue[i%capacity];
		}
		queue = newQ;
		capacity=capacity<<1;
		//capacity *= 2;
		front = 0;
		rear = size-1;
	}
	
	public int dequeue()
	{
		if(size==0)
		{
			throw new IllegalStateException("Queue is empty: Underflow");
		}
		int data=queue[front];
		queue[front]=Integer.MIN_VALUE;
		front=(front+1)%capacity;
		size--;
		shrink();
		return data;
	}
	
	public void shrink()
	{
		int length = size;
		if(length <= MINCAPACITY || length<<2 >= length)
		{
			return;
		}
		
		if(length < MINCAPACITY)
		{
			length=MINCAPACITY;
		}
		int[] newQ = new int[length];
		System.arraycopy(queue, 0, newQ, 0, length+1);
		capacity=length;
		queue=newQ;
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
	
	public static void main(String[] args) 
	{
		DynamicArrayQueue Q = new DynamicArrayQueue(5);
		Q.enqueue(1);
		Q.enqueue(2);
		Q.enqueue(3);
		Q.enqueue(4);
		Q.enqueue(5);
		System.out.println(Q.toString());
		Q.enqueue(6);
		Q.enqueue(7);
		System.out.println(Q.toString());

		Q.dequeue();
		Q.dequeue();
		Q.dequeue();
		Q.dequeue();
		Q.dequeue();
		Q.dequeue();
		Q.dequeue();
		//Q.dequeue();
		System.out.println(Q.toString());
	}
}
