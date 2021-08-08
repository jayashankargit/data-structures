package practice;

import java.util.Scanner;

class Difference {
  	private int[] elements;
  	public int maximumDifference;
    public Difference(int[] a){
    	this.elements = a;
    }
    public void computeDifference() {
    	int elementsLength = elements.length;
    	int differenceValue;
    	for(int counterOne = 0; counterOne < elementsLength; counterOne++) {
    		for(int counterTwo = counterOne + 1; counterTwo < elementsLength; counterTwo++) {
    			differenceValue = Math.abs(elements[counterOne]-elements[counterTwo]);
    			if(differenceValue > maximumDifference){
    				maximumDifference = differenceValue;
    			}
    		}
    	}

    }

} // End of Difference class

public class SolutionOne {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}