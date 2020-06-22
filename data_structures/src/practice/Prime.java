package practice;

import java.util.Scanner;

public class Prime {

	private void checkPrime(int[] arr) {
		for(int data:arr) {
			if(data%2==0) {
				if(data == 2) {
					System.out.println("Prime");
					continue;
				}
				System.out.println("Not Prime");
			} else {
				boolean oddPrimeFlag = true;
				if(data == 1) {
					System.out.println("Not Prime");
					continue;
				}
				for(int primeCounter = 3; primeCounter <= Math.sqrt(data); primeCounter+=2) {
					if(data%primeCounter==0) {
						System.out.println("Not Prime");
						oddPrimeFlag = false;
						break;
					}
				}
				if(oddPrimeFlag) {
					System.out.println("Prime");
				}
			}
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int inputTestCase = scanner.nextInt();
		int[] arr = new int[inputTestCase];
		for(int counter = 0; counter < inputTestCase; counter++) {
			arr[counter] = scanner.nextInt();
		}
		scanner.close();
		Prime prime = new Prime();
		prime.checkPrime(arr);
	}

}
