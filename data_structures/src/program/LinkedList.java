package program;

public class LinkedList {
	class Node{
		int data;
		Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	Node head;
	Node tail;
	int size;
	public void add(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = tail = newNode;
//			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		size++;
	}
	public void add(int data, int index) {
		if(index < 0 || index > size) {
			System.out.println("index position is not valid or out of range");
			return;
		} else if(index == size) {
			add(data);
			return;
		}
		Node newNode = new Node(data);
		Node curr = head;
		Node prev = null;
		int indexCheckCounter = 0;
		while(curr != null && indexCheckCounter != index) {
			prev = curr;
			curr = curr.next;
			indexCheckCounter++;
		}
		if(index == 0) {
			head = newNode;
			head.next = curr;
		} else {
			newNode.next = prev.next;
			prev.next = newNode;
		}
		if(prev.next == null) {
			//might bring issue since the new node will be the last node so tail should be the new node
			tail = prev;
			
//			tail = newNode;
		}
		size++;
	}
	public void remove(int index) {
		if(head == null) {
			System.out.println("list is empty and can't delete from the list");
			return;
		}
		if(index < 0 || index > size) {
			System.out.println("index is out of range can't delete from the list");
			return;
		}
		Node curr = head;
		Node prev = null;
		int removeCounter = 0;
		while(curr != null && removeCounter++ != index) {
			prev = curr;
			curr = curr.next;
		}
		if(prev == null) {
			head = curr.next;
		} else {
			prev.next = curr.next;
			curr.next = null;
		}
		size--;
		if(prev != null && prev.next == null) {
			tail = prev;
		}
	}
	public void removeObj(int data) {
		if(head == null) {
			System.out.println("list is empty and can't delete from the list");
			return;
		}
		Node curr = head;
		Node prev = null;
		while(curr != null && curr.data != data) {
			prev = curr;
			curr = curr.next;
		}
		if(curr == null) {
			System.out.println("data is not found in the list");
			return;
		}
		if(prev == null) {
			head = curr.next;
		} else {
			prev.next = curr.next;
			curr.next = null;
		}
		size--;
		if(prev != null && prev.next == null) {
			tail = prev;
		}
	}
	//return the data from index
	public int get(int index) {
		if(head == null) {
			System.out.println("list is empty and can't delete from the list");
			return Integer.MIN_VALUE;
		}
		if(index < 0 || index > size) {
			System.out.println("index is out of range can't delete from the list");
			return Integer.MIN_VALUE;
		}
		Node curr = head;
		int getCounter = -1;
		while(curr != null && getCounter++ != index) {
			curr = curr.next;
		}
		return curr.data;
	}
	public int indexOf(int data) {
		Node curr = head;
		int indexCounter = 0;
		int index = -1;
		if(head == null) {
			System.out.println("list is empty and index can't be retrieved");
			return Integer.MIN_VALUE;
		}
		while(curr != null) {
			if(curr.data == data) {
				index = indexCounter;
				break;
			}
			curr = curr.next;
			indexCounter++;
		}
		if(indexCounter == size) {
			System.out.println("data is not found in the list");
			index = Integer.MIN_VALUE;
		}
		return index;
	}
	public int lastIndexOf(int data) {
		Node curr = head;
		int indexCounter = 0;
		int index = 0;
		if(head == null) {
			System.out.println("list is empty and index can't be retrieved");
			return Integer.MIN_VALUE;
		}
		while(curr != null) {
			if(curr.data == data) {
				index = indexCounter;
			}
			curr = curr.next;
			indexCounter++;
		}
		if(indexCounter == size) {
			System.out.println("data is not found in the list");
			index = Integer.MIN_VALUE;
		}
		return index;
	}
	public boolean isEmpty() {
		if(head != null) {
			return false;
		}
		return true;
	}
	public void clear() {
		head = tail = null;
	}
	public boolean containsOf(int data) {
		int index = indexOf(data);
		if(index == -1 || index == Integer.MIN_VALUE) {
			return false;
		} else {
			return true;
		}
	}
	public int size() {
		return size;
	}
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		Node curr = head;
		while(curr != null) {
			stringBuilder.append(curr.data).append(",");
			curr = curr.next;
		}
		if(stringBuilder.length() > 1) {
			stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}

	private void printTailData() {
		System.out.println(tail.data);
	}
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40,0);
		linkedList.printTailData();
		System.out.println(linkedList);
		linkedList.clear();
		System.out.println(linkedList);
//		linkedList.removeObj(50);
//		System.out.println(linkedList);
//		System.out.println("size is :"+linkedList.size());
//		linkedList.removeObj(20);
//		System.out.println(linkedList);
//		System.out.println("size is :"+linkedList.size());
	}
}