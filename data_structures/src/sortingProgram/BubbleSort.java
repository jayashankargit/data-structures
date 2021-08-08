package sortingProgram;

public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = {70,40,10,50};
		int arrSize = arr.length;
		int counterEndValidation = arrSize - 1;
		int swapTemp;
		for(int outerCounter = 0; outerCounter < counterEndValidation; outerCounter++) {
			for(int innerCounter = 0; innerCounter < counterEndValidation; innerCounter++) {
				if(arr[innerCounter] > arr[innerCounter+1]) {
					swapTemp = arr[innerCounter+1];
					arr[innerCounter+1] = arr[innerCounter];
					arr[innerCounter] = swapTemp;
				}
			}
		}

		for(int data:arr) {
			System.out.println(data);
		}
	}

}
