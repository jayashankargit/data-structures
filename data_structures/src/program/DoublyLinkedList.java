package program;

public class DoublyLinkedList {

	class Node{
		int data;
		Node next;
		Node prev;
		
		public Node(int data){
			this.data = data;
		}
		
	}
	
	Node head;
	Node tail;
	int size = 0;
	
	public void add(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = tail.next;
		}
		size++;
	}
	
	public void add(int data, int index) {
		if(index < 0 || index > size-1) {
			System.out.println("index is out of bound insertion is not possible");
			return;
		}
		Node newNode = new Node(data);
		Node curr = findNode(index);
		Node temp = null;
		if(curr == head) {
			newNode.next = head;
			head.prev = newNode;
			head = newNode;
		} else {
			newNode.next = curr;
			newNode.prev = curr.prev;
			curr.prev = newNode;
			temp = newNode.prev;
			temp.next = newNode;
		}
		
	}
	public int get(int index) {
		if(index < 0 || index > size-1) {
			System.out.println("index is out of bound");
			return -1;
		}
		Node target = findNode(index);
		return target.data;
	}
	private Node findNode(int index) {
		int mid = size/2;
		if(index < mid) {
			return findReverse(index);
		}
		return findForward(index);
	}
	private Node findForward(int index) {
		Node curr = head;
		int incrementCounter = 0;
		while(curr != null && index != incrementCounter++) {
			curr = curr.next;
		}
		return curr;
	}
	
	private Node findReverse(int index) {
		Node curr = tail;
		int counter = size - 1;
		while(curr != null && counter-- != index) {
			curr = curr.prev;
		}
		return curr;
	}
	
	
	@Override
	public String toString() {
		Node curr = head;
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
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

	private void remove(int index) {
		if(index < 0 || index > size - 1) {
			System.out.println("given index is not in range");
			return;
		}
		Node curr = findNode(index);
		removeValueFromList(curr);
	}

	private void removeValueFromList(Node curr) {
		if(curr == head) {
			Node nextNode = curr.next;
			head = nextNode;
			curr.next = null;
		} else if(curr == tail) {
			Node prevNode = curr.prev;
			prevNode.next = null;
			curr = null;
			tail = prevNode;
		} else {
			Node prevNode = curr.prev;
			Node nextNode = curr.next;
			prevNode.next = nextNode;
			nextNode.prev = prevNode;
			
			curr.prev = curr.next = null;
		}
		size--;
	}
	public void removeObj(int data) {
		Node curr = head;
		while(curr != null && curr.data != data) {
			curr = curr.next;
		}
		removeValueFromList(curr);
	}
	public void set(int data, int index) {
		if(index < 0 || index > size - 1) {
			System.out.println("index is out of range");
			return;
		}
		Node curr = findNode(index);
		curr.data = data;
	}
	
	public int indexOf(int data) {
		Node curr = head;
		int index = 0;
		while(curr != null && curr.data != data) {
			curr = curr.next;
			index++;
		}
		if(index == size) {
			index = -1;
		}
		return index;
	}
	public int lastIndexOf(int data) {
		Node curr = tail;
		int index = size-1;
		while(curr != null && curr.data != data) {
			curr = curr.prev;
			index--;
		}
		return index;
	}
	public boolean containsOf(int data) {
		return indexOf(data) != -1;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void clear() {
		head = tail = null;
		size = 0;
	}
	public static void main(String[] args) {
		DoublyLinkedList ls = new DoublyLinkedList();
		ls.add(10);
		ls.add(20);
		ls.add(10);
		ls.add(40);
		System.out.println(ls);
		System.out.println(ls.isEmpty());
		ls.clear();
		System.out.println("after clearing list :"+ls.isEmpty());
	}
}