package ds.linkedList;

class ULLNode
{
	ULLNode next;
	int numElements;
	int array[];

	public ULLNode(int n)
	{
		next = null;
		numElements = 0;
		array = new int[n];
	}
}

class UnrolledLinkedList
{
	private ULLNode start;
	private ULLNode end;
	private int sizeNode;
	private int nNode;

	public UnrolledLinkedList(int capacity)
	{
		start = null;
		end = null;
		nNode = 0;
		sizeNode = capacity + 1;
	}

	public boolean isEmpty()
	{
		return start == null;
	}

	public int getSize()
	{
		return nNode;
	}

	public void makeEmpty()
	{
		start = null;
		end = null;
		nNode = 0;
	}

	public void insert(int x)
	{
		nNode++;
		if (start == null)
		{
			start = new ULLNode(sizeNode);
			start.array[0] = x;
			start.numElements++;
			end = start;
			return;
		}
		if (end.numElements + 1 < sizeNode)
		{
			end.array[end.numElements] = x;
			end.numElements++;
		}
		else
		{
			ULLNode nptr = new ULLNode(sizeNode);
			int j = 0;
			for (int i = end.numElements/2 + 1; i < end.numElements; i++)
			{
				nptr.array[j++] = end.array[i];
			}
			nptr.array[j++] = x;
			nptr.numElements = j;
			end.numElements = end.numElements/2 + 1;
			end.next = nptr;
			end = nptr;
		}
	}

	public void display()  
	{
		System.out.print("\nUnrolled Linked List = ");
		if (nNode == 0)
		{
			System.out.print("empty\n");
			return;
		}
		System.out.println();
		ULLNode ptr = start;
		while (ptr != null)
		{
			for (int i = 0; i < ptr.numElements; i++)
			{
				System.out.print(ptr.array[i] +" ");
			}
			System.out.println();
			ptr = ptr.next;
		}
	}
}

public class UnrolledLinkedListTest
{
	public static void main(String[] args)
	{
		UnrolledLinkedList ull = new UnrolledLinkedList(5);
		ull.insert(1);
		ull.insert(2);
		ull.insert(3);
		ull.insert(4);
		ull.insert(5);
		ull.insert(6);
		ull.insert(7);
		ull.insert(8);
		ull.insert(9);
		ull.insert(10);
		ull.insert(10);
		ull.insert(11);
		ull.insert(12);
		ull.insert(13);
		ull.insert(14);
		ull.insert(4);
		
		ull.display();
	}
}