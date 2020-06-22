package program;

import java.util.Scanner;

public class FirstProgram {private static final Scanner scanner = new Scanner(System.in);

public static void main(String[] args) {
	int[][] arr = new int[6][6];

	for (int i = 0; i < 6; i++) {
		String[] arrRowItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int j = 0; j < 6; j++) {
			int arrItem = Integer.parseInt(arrRowItems[j]);
			arr[i][j] = arrItem;
		}
	}
	int maxSumValue = 0;
	int sumValue = 0;
	int iValue = 0;
	int jValue = 0;
	boolean initialMaxSetFlag = true;
	for(int yAxis =  0; yAxis<4;yAxis++){
		for(int xAxis = 0; xAxis<4; xAxis++){
			sumValue = arr[iValue][jValue]+arr[iValue][jValue+1]+arr[iValue][jValue+2];
			sumValue += arr[++iValue][jValue+1];
			++iValue;
			sumValue += arr[iValue][jValue]+arr[iValue][jValue+1]+arr[iValue][jValue+2];
			if(initialMaxSetFlag || sumValue > maxSumValue){
				maxSumValue = sumValue;
				initialMaxSetFlag = false;
			}
			jValue++;
			iValue = iValue - 2;
			System.out.println("sumValue:"+sumValue);
		}
		jValue = 0;
		iValue++;
	}
	System.out.println("maxSumValue:"+maxSumValue);



	scanner.close();
}}