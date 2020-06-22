package practice;

import java.util.Scanner;

public class BitwiseAnd {
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		int t = scanner.nextInt();
		int[] resultArr = new int[t];
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		for (int tItr = 0; tItr < t; tItr++) {
			String[] nk = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nk[0]);

			int k = Integer.parseInt(nk[1]);
			int tempResult;
			int maxValue = 0;
			for(int counter = 1; counter <= n; counter++) {
				for(int innerCounter = counter+1; innerCounter <= n; innerCounter++) {
					tempResult = counter&innerCounter;
					if(tempResult < k && maxValue < tempResult) {
						maxValue = tempResult;
					}
				}
			}
			resultArr[tItr] = maxValue;
		}
		for(int result : resultArr) {
			System.out.println(result);
		}
		scanner.close();
	}
}