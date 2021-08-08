package sortingProgram;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = {30, 20, 10, 50, 40};
		int temp;
		int j;
		for(int i = 1; i < arr.length; i++) {
			temp = arr[i];
			for(j = i; (j > 0  && temp < arr[j -1]); j --) {
				arr[j] = arr[j - 1];
			}
			arr[j] = temp;
		}

		for(int data:arr) {
			System.out.println(data);
		}
	}

}
