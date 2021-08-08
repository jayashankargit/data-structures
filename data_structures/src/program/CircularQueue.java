package program;

import java.util.Arrays;

/**
 * Advantages over queue is operation, in normal queue on removing a data, all other data should be shifted down.
 * if we insert new value in queue.
 */
public class CircularQueue {
	int[] arr = null;
	int capacity = 3;
	int front = 0;
	int rear = -1;
	int size = 0;
	public int size() {
		return size;
	}
	public CircularQueue() {
		arr = new int[capacity];
	}
	public CircularQueue(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
	}
	public void enqueue(int data) {
		if(isFull()) {
			System.out.println("Queue is full can't insert the data");
			return;
		}
		/*if(rear == capacity) {
			rear = 0;
		}*/
		//The Above logic can be rewritten as
		rear = (rear + 1)%capacity;
		arr[rear] = data;
		size++;
		System.out.println("enqueued data is :"+data);
	}
	public void dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty can't get value from queue");
			return;
		}
		int data = arr[front];
		front = (front + 1)%capacity;
		size--;
		System.out.println("dequeued data is :"+data);
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public boolean isFull() {
		return size == capacity;
	}
	public void displayArray() {
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		CircularQueue circularQueue = new CircularQueue();
		for(int counter=1;counter<=3;counter++) {
			circularQueue.enqueue(counter);
		}
		circularQueue.dequeue();
		circularQueue.enqueue(4);
		for(int counter=1;counter<=3;counter++) {
			circularQueue.dequeue();
		}
		circularQueue.dequeue();
		circularQueue.displayArray();
	}
}
