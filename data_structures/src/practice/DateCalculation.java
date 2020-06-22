package practice;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class DateCalculation {
	public static void fineCalculation(Period period, int actualYear, int expectedYear) {
		int months = Math.abs(period.getMonths());
		int days = Math.abs(period.getDays());
		int years = Math.abs(period.getYears());
		int fine = 0;
		if(actualYear != expectedYear) {
			fine = 10000;
		} else {
			if(months == 0 && days == 0 && years ==0) {
				fine = 0;
			} else if(months == 0 && years == 0) {
				fine = 15 * days;
			} else if(years == 0) {
				fine = 500 * months; 
			}
		}
		System.out.println(fine);
	}
	public static void dateFormat(String actualReturnDate, String expectedReturnDate) throws ParseException {
		String[] actualDateArray = actualReturnDate.split(" ");
		String[] expectedDateArray = expectedReturnDate.split(" ");
		int actualYear = Integer.parseInt(actualDateArray[2]);
		int expectedYear = Integer.parseInt(expectedDateArray[2]);
		LocalDate actualDate = LocalDate.of(Integer.parseInt(actualDateArray[2]), Integer.parseInt(actualDateArray[1]), Integer.parseInt(actualDateArray[0]));
		LocalDate expectedDate = LocalDate.of(Integer.parseInt(expectedDateArray[2]), Integer.parseInt(expectedDateArray[1]), Integer.parseInt(expectedDateArray[0]));
		if(actualDate.isBefore(expectedDate)) {
			System.out.println(0);
			return;
		}
		Period p = Period.between(actualDate, expectedDate);
		fineCalculation(p, actualYear, expectedYear);
	}
	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		String actualReturnDate = scanner.nextLine();
		String expectedReturnDate = scanner.nextLine();
		dateFormat(actualReturnDate, expectedReturnDate);
	}
}
