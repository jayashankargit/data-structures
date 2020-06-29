package program;

public class Stack {
	int[] arr = null;
	int capacity = 5;
	int top = -1;
	public Stack() {
		arr = new int[capacity];
	}
	public Stack(int capacity) {
		this.capacity = capacity;
		arr = new int[capacity];
	}
	public void push(int dataCounter) {
		if(!isFull()) {
			arr[++top] = dataCounter;
//			System.out.println("Data is pushed in stack"+dataCounter);
		} else {
			System.out.println("Stack is full");
		}
	}
	public void pop() {
		if(!isEmpty()) {
			int data = arr[top--];
//			System.out.println("Data is popped from stack"+data);
		} else {
			System.out.println("Stack is empty");
		}
	}
	
	public int peek() {
		if(!isEmpty()) {
//			System.out.println("Data at the top position is:"+arr[top]);
			return arr[top];
		} else {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		}
		
	}
	public boolean isFull() {
		if(this.capacity == top + 1) {
			return true;
		} else 
			return false;
	}
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		} else {
			return false;
		}
	}
	public void dataInsertion(Stack stack) {
		for(int dataCounter = 1; dataCounter <= this.capacity; dataCounter++) {
			stack.push(dataCounter);
		}
	}
	public void dataDeletion(Stack stack) {
		for(int dataCounter = 1; dataCounter <= this.capacity; dataCounter++) {
			stack.pop();
		}
	}
	
	public static void main(String[] args) {
		Stack stack = new Stack(5);
		stack.dataInsertion(stack);
		stack.push(6);
		stack.push(6);
		stack.peek();
		stack.dataDeletion(stack);
		stack.pop();
		stack.pop();
		stack.peek();
	}

}
