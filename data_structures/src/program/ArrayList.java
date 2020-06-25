package program;

import java.util.Arrays;

public class ArrayList {

	int[] arr = null;
	int capacity = 5;
	int size = 0;
	public ArrayList() {
		this.arr = new int[capacity];
	}
	public ArrayList(int capacity) {
		this.arr = new int[capacity];
		this.capacity = capacity;
	}
	public void add(int data) {
		if(size == capacity) {
			ensureCapacity(data);
			return;
		}
		this.arr[size++] = data;
		System.out.println(data+" inserted in the list");
	}
	public void add(int data, int index) {
		if(size == capacity && index == size-1) {
			ensureCapacity(data);
			return;
		}
		for(int counter = size; counter > index;counter--) {
			arr[counter] = arr[counter-1];
		}
		arr[index] = data;
		size++;
		System.out.println(data+" inserted in the list");
	}
	//dynamic memory increment
	private void ensureCapacity(int data) {
		this.capacity = this.capacity + (this.capacity>>1);
		//to copy the existing array to new array
		int[] newArr = new int[capacity];
		int copyCounter = 0;
		for(int copyData:this.arr) {
			newArr[copyCounter++] = copyData;
		}
		this.arr = new int[capacity];
		this.arr = newArr;
		//add the data
		this.arr[size++] = data;
		System.out.println(data+" inserted in the list");
	}
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("[");
		boolean firstInstanceFlag = true;
		for(int displayCounter = 0; displayCounter < size;displayCounter++) {
			if(!(firstInstanceFlag)) {
				stringBuilder.append(" ").append(arr[displayCounter]).append(",");
			} else {
				stringBuilder.append(arr[displayCounter]).append(",");
				firstInstanceFlag = false;
			}
		}
		if(size != 0) {
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		}
		stringBuilder.append("]");
		return stringBuilder.toString();
	}
	public String display() {
		return Arrays.toString(this.arr);
	}
	public void remove(int index) {
		if(index < 0 || index > size-1) {
			System.out.println("given index position is invalid");
			return;
		}
		int dataToBeDeleted = arr[index];
		size--;
		//swap operation
		for(int swapCounter = index; swapCounter < size;swapCounter++) {
			arr[swapCounter] = arr[swapCounter+1]; 
		}
		System.out.println("deleted data from the array list is :"+dataToBeDeleted);
	}
	public int indexOf(int data) {
		int index = -1;
		for(int indexCounter = 0; indexCounter < size; indexCounter++) {
			if(arr[indexCounter] == data) {
				index = indexCounter;
				break;
			}
		}
		return index;
	}
	public int lastIndexOf(int data) {
		int index = -1;
		for(int indexCounter = size-1; indexCounter >= 0; indexCounter--) {
			if(arr[indexCounter] == data) {
				index = indexCounter;
				break;
			}
		}
		return index;
	}
	public void removeObj(int data) {
		remove(indexOf(data));
	}
	public int size() {
		return size;
	}
	public void clear() {
		size = 0;
	}
	public boolean contains(int data) {
		int index = indexOf(data);
		if(index != -1) {
			return true;
		}
		return false;
	}
	public boolean isEmpty() {
		if(size == 0) {
			return true;
		} else {
			return false;
		}
	}
	public static void main(String[] args) {
		ArrayList arrayList = new ArrayList();
		arrayList.add(10);
		arrayList.add(20);
		arrayList.add(30);
		arrayList.add(40);
		arrayList.add(10);
		System.out.println(arrayList);
		System.out.println("index of 10 is :"+arrayList.indexOf(10));
		System.out.println("index of 10 is :"+arrayList.lastIndexOf(10));
		arrayList.removeObj(20);
		System.out.println("Is 10 contains in the list :"+arrayList.contains(10));
		System.out.println(arrayList);
		arrayList.clear();
		System.out.println("is the list is empty :"+arrayList.isEmpty());
		
	}

}
