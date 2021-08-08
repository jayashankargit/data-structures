package practice;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class HourGlassSum {

	// Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	int xAxisLength = arr.length;
    	int yAxisLength = arr[0].length;
    	int sumValue;
    	int maxSumValue=Integer.MIN_VALUE;
        for(int xAxisCounter = 0; xAxisCounter < xAxisLength-2; xAxisCounter++) {
        	for(int yAxisCounter = 0; yAxisCounter < yAxisLength-2; yAxisCounter++) {
        		sumValue = arr[xAxisCounter][yAxisCounter] + arr[xAxisCounter][yAxisCounter + 1] + 
        				arr[xAxisCounter][yAxisCounter + 2];
        		sumValue += arr[xAxisCounter+1][yAxisCounter+1];
        		sumValue += arr[xAxisCounter + 2][yAxisCounter] + arr[xAxisCounter + 2][yAxisCounter + 1] + 
        				arr[xAxisCounter + 2][yAxisCounter + 2];
        		if(sumValue > maxSumValue) {
        			maxSumValue = sumValue;
        		}
        	}
        	
        }
    	return maxSumValue;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);
        System.out.println(result);

//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();

//        bufferedWriter.close();

        scanner.close();
    }

}
