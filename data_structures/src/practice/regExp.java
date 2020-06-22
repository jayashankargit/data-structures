package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regExp {
	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int N = scanner.nextInt();
        String myRegExpString = "@gmail.com";
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        ArrayList<String> list = new ArrayList<String>();
        for (int NItr = 0; NItr < N; NItr++) {
            String[] firstNameEmailID = scanner.nextLine().split(" ");

            String firstName = firstNameEmailID[0];

            String emailID = firstNameEmailID[1];
            Pattern p = Pattern.compile(myRegExpString);
            Matcher m = p.matcher(emailID);
            if(m.find()) {
            	list.add(firstName);
            }

        }
        Collections.sort(list);
        list.stream().forEach(value->{
        	System.out.println(value);
        });
        scanner.close();
    }
}