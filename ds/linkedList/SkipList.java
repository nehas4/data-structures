package ds.linkedList;

import java.util.Random;

public class SkipList<T extends Comparable<T>, U> {

	private class Node {
		public T key;
		public U value;
		public long level;
		public Node next;
		public Node down;

		public Node(T key, U value, long level, Node next, Node down) {
			this.key = key;
			this.value = value;
			this.level = level;
			this.next = next;
			this.down = down;
		}
	}

	private Node head;
	private Random _random;
	private long size;
	private double _p;

	private long level() {
		long level = 0;
		while (level <= size && _random.nextDouble() < _p) {
			level++;
		}
		return level;
	}

	public SkipList() {
		head = new Node(null, null, 0, null, null);
		_random = new Random();
		size = 0;
		_p = 0.5;
	}

	public void add(T key, U value) {
		long level = level();
		if (level > head.level) {
			head = new Node(key, value, level, null, head);
		}
		Node curr = head;
		Node last = null;
		while (curr != null) {
			if (curr.next == null || curr.next.key.compareTo(key) > 0) {
				if (level >= curr.level) {
					Node node = new Node(key, value, curr.level, curr.next, null);
					if (last != null) {
						last.down = node;
					}
					last = node;
					curr.next = node;
				}
				curr = curr.down;
				continue;
			} else if (curr.next.key.equals(key)) {
				curr.next.value = value;
				return;
			}
			curr = curr.next;
		}
		size++;
	}

	public boolean containsKey(T key) {
		return get(key) != null;
	}

	public U get(T key) {
		Node curr = head;
		while (curr != null) {
			if (curr.next == null || curr.next.key.compareTo((key)) > 0) {
				curr = curr.down;
				continue;
			} else if (curr.next.key.equals(key)) {
				return curr.next.value;
			}
			curr = curr.next;
		}
		return null;
	}

	public U remove(T key) {
		U value = null;
		Node curr = head;
		while (curr != null) {
			if (curr.next == null || curr.next.key.compareTo(key) >= 0) {
				if (curr.next != null && curr.next.key.equals(key)) {
					value = curr.next.value;
					curr.next = curr.next.next;
					size--;
				}
				curr = curr.down;
				continue;
			}
			curr = curr.next;
		}
		return value;
	}

	void displayList() {
		System.out.print("\nSkiplist = ");
		Node current = head;
		
		 while(current.down != null) 
		 { 
			 current = current.down; 
		 }
		 

		while (current.next != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		
	}

	public static void main(String[] args) {
		SkipList s = new SkipList();
		s.add(1, 100);
		s.add(2, 101);
		s.add(3, 102);
		s.add(4, 103);
		s.add(5, 104);
		s.add(6, 105);
		s.add(7, 106);
		s.add(8, 107);
		s.add(9, 108);
		s.add(11, 109);
		s.add(12, 110);

		// System.out.println(s.get(6));

		s.displayList();
	}
}
