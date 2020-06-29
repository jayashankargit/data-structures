package program;

public class EnqueueStack {

	int capacity = 5;
	Stack enqueueStack;
	Stack dequeueStack;
	public EnqueueStack() {
		enqueueStack = new Stack(capacity);
		dequeueStack = new Stack(capacity);
	}
	public EnqueueStack(int capacity) {
		this.capacity = capacity;
		enqueueStack = new Stack(capacity);
		dequeueStack = new Stack(capacity);
	}
	public void enqueuePush(int data) {
		if(enqueueStack.isFull()) {
			System.out.println("queue is full can't insert data");
			return;
		}
		enqueueStack.push(data);
		System.out.println("data enqueued in stack is :"+data);
	}
	public void enqueuePop() {
		if(enqueueStack.isEmpty()) {
			System.out.println("queue is empty can't pop the data");
			return;
		}
		//inserting value from one stack array in to other stack in reverse order
		while(!enqueueStack.isEmpty()) {
			dequeueStack.push(enqueueStack.peek());
			enqueueStack.pop();
		}
		int data = dequeueStack.peek();
		System.out.println("pop data from queue is :"+data);
		//value removed from dequeueStack
		dequeueStack.pop();
		//value is set to enqueueStack by value removed from dequeueStack
		while(!dequeueStack.isEmpty()) {
			enqueueStack.push(dequeueStack.peek());
			dequeueStack.pop();
		}
	}
	public String toString() {
		if(enqueueStack.isEmpty()) {
			System.out.println("queue is empty and can't display");
		}
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		while(!enqueueStack.isEmpty()) {
			stringBuilder.append(enqueueStack.peek()).append(",");
			dequeueStack.push(enqueueStack.peek());
			enqueueStack.pop();
		}
		while(!dequeueStack.isEmpty()) {
			enqueueStack.push(dequeueStack.peek());
			dequeueStack.pop();
		}
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	public static void main(String[] args) {
		EnqueueStack eq = new EnqueueStack();
		eq.enqueuePush(10);
		eq.enqueuePush(20);
		eq.enqueuePush(30);
		System.out.println(eq);
		eq.enqueuePop();
		System.out.println(eq);
	}
}