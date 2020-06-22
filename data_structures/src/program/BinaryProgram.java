package program;

import java.util.Scanner;

public class BinaryProgram {
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        int divide;
        String binaryValue="";
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        while(n > 1){
            divide = n/2;
            if(n%2 == 1){
            	binaryValue += "1";
            } else {
            	binaryValue += "0";
            }
            n = divide;
        }
        System.out.println(binaryValue);
        scanner.close();
    }
}
