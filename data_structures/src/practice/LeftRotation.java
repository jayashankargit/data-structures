package practice;

public class LeftRotation {
	public static void leftRotation(int[] arr, int rotationValue){
        int arrLength = arr.length;
        int[] resultValue = new int[arrLength];
        int valueSetCounter = 0;
        for(int counter = rotationValue; counter < arrLength; counter++){
            resultValue[valueSetCounter++] = arr[counter];
        }
        for(int counter = 0; counter < rotationValue; counter++){
            resultValue[valueSetCounter++] = arr[counter];
        }
        print(resultValue);
    }
	public static void print(int[] resultValue) {
		StringBuilder stringBuilder = new StringBuilder();
		for(int data:resultValue) {
			stringBuilder.append(data).append(" ");
		}
		stringBuilder.deleteCharAt(stringBuilder.length()-1);
		System.out.println(stringBuilder.toString());
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		leftRotation(arr, 4);
	}

}
