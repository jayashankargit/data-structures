package practice;

import java.util.Scanner;

public class Palindrome {

	    // Write your code here.
	    char[] stackArray = new char[100];
	    char[] queueArray = new char[100];
	    int stackTop = -1;
	    int queueFront = 0;
	    int queueRear = -1;
	    public void pushCharacter(char c){
	    	stackArray[++stackTop] = c;
	    }
	    public void enqueueCharacter(char c) {
	    	queueArray[++queueRear] = c;
	    }
	    public char popCharacter() {
	    	return stackArray[stackTop--];
	    }
	    public char dequeueCharacter() {
	    	return queueArray[queueFront++];
	    }
	    public static void main(String[] args) {
	        Scanner scan = new Scanner(System.in);
	        String input = scan.nextLine();
	        scan.close();

	        // Convert input String to an array of characters:
	        char[] s = input.toCharArray();

	        // Create a Solution object:
	        Palindrome p = new Palindrome();

	        // Enqueue/Push all chars to their respective data structures:
	        for (char c : s) {
	            p.pushCharacter(c);
	            p.enqueueCharacter(c);
	        }

	        // Pop/Dequeue the chars at the head of both data structures and compare them:
	        boolean isPalindrome = true;
	        for (int i = 0; i < s.length/2; i++) {
	            if (p.popCharacter() != p.dequeueCharacter()) {
	                isPalindrome = false;                
	                break;
	            }
	        }

	        //Finally, print whether string s is palindrome or not.
	        System.out.println( "The word, " + input + ", is " 
	                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
	    }
}
