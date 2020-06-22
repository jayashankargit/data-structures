package practice;

public class LinkedList {

	class Node{
		int data;
		Node next;
		
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}
	public Node head = null;
	public Node tail = null;
	
	public void add(int data) {
		Node newNode = new Node(data);
		if(head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}
	public void display() {
		Node current = head;
		if(head == null) {
			System.out.println("linked list is empty");
			return;
		}
		System.out.println("Nodes of singly linked list are:");
		while(current!=null) {
			System.out.println(current.data+" ");
			current = current.next;
		}
	}
	private void removeDuplication() {
		Node headNode = head;
		Node currentNode = headNode;
		Node previousNode = null;
		Node tempNode = null;
		if(headNode == null) {
			System.out.println("list is empty");
		} else {
			while(headNode != null) {
				currentNode = headNode.next;
				previousNode = headNode;
				while(currentNode != null) {
					if(headNode.data == currentNode.data) {
						tempNode = currentNode.next;
						previousNode.next = currentNode.next;
						currentNode.next = null;
						currentNode = tempNode;
					} else {
						currentNode = currentNode.next;
						previousNode = previousNode.next;
					}
				}
				headNode = headNode.next;
			}
		}
	}
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
//		for(int counter = 1; counter<=5;counter++) {
//			linkedList.add(counter);
//		}
//		int[] arr = {1,1,1,1,1,1,1};
		int[] arr = {1,2,2,3,3,4};
		for(int data:arr) {
			linkedList.add(data);
		}
		linkedList.display();
		//removing duplication in list
		linkedList.removeDuplication();
		linkedList.display();
	}
}