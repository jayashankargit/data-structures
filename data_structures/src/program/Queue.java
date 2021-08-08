package program;

/**
 * concept of first in and first out
 */
public class Queue {
	int[] arr = null;
	int capacity = 5;
	int front = 0;
	int rear = -1;
	public Queue() {
		this.arr = new int[capacity];
	}
	public Queue(int capacity) {
		this.capacity = capacity;
		this.arr = new int[capacity];
	}
	public void enqueue(int dataCounter) {
		if(isFull()) {
			System.out.println("Queue is full:");
			return;
		}
		arr[++rear] = dataCounter;
		System.out.println("Enqueued data is:"+dataCounter);
	}
	public void dequeue() {
		if(isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Dequeued data is:"+arr[front]);
		rear--;
		for(int i = front; i<size();i++) {
			arr[i] = arr[i+1];
		}
	}
	public boolean isFull() {
		return size() == this.capacity;
	}
	public boolean isEmpty() {
		return rear == -1;
	}
	public int size() {
		return rear+1;
	}
	public void dataInsertion() {
		for(int dataCounter = 1; dataCounter <= this.capacity; dataCounter++) {
			enqueue(dataCounter);
		}
	}
	public void dataDeletion() {
		int rearSize = size();
		for(int dataCounter = 1; dataCounter <= rearSize; dataCounter++) {
			dequeue();
		}
	}
	public static void main(String[] args) {
		Queue queue = new Queue(5);
		queue.dataInsertion();
		queue.dequeue();
		queue.enqueue(100);
		queue.enqueue(60);
		queue.dataDeletion();
		queue.dequeue();
	}
}