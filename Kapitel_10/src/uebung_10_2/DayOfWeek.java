package uebung_10_2;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class DayOfWeek {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Bitte geben Sie" + " ein Datum ein:");

		System.out.print("Tag: ");
		int day = sc.nextInt();
		sc.nextLine();
		System.out.print("Monat: ");
		int month = sc.nextInt();
		sc.nextLine();
		System.out.print("Jahr: ");
		int year = sc.nextInt();
		sc.nextLine();
		sc.close();

		GregorianCalendar greCal = new GregorianCalendar();

		greCal.set(Calendar.DATE, day);
		greCal.set(Calendar.MONTH, month - 1); // MONTH starts at 0 in Java (Januar = 0, Februar = 1, ...)
		greCal.set(Calendar.YEAR, year);

		System.out.println("Der " + day + "." + month + "." + year + " war ein "
				+ greCal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_FORMAT, Locale.getDefault()));
	}
}
