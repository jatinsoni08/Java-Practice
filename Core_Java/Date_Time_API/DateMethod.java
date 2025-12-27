package com.jatin.java8;

public class DateMethod {
	public static void main(String[] args) {

		// Creating java.util.Date object
		// Represents current date and time (old Date API)
		java.util.Date utilDate = new java.util.Date();
		System.out.println("java.util.Date: \n" + utilDate + "\n");

		// Converting java.util.Date to milliseconds since 1 January 1970
		long millis = utilDate.getTime();

		// Creating java.sql.Date using milliseconds
		// java.sql.Date stores ONLY date (no time)
		java.sql.Date sqlDate1 = new java.sql.Date(millis);
		System.out.println("java.sql.Date from utilDate.getTime(): \n" + sqlDate1 + "\n");

		// Creating java.sql.Date using current system time
		java.sql.Date sqlDate2 = new java.sql.Date(System.currentTimeMillis());
		System.out.println("java.sql.Date from System.currentTimeMillis(): \n" + sqlDate2 + "\n");

		// Another way to convert util.Date to sql.Date
		// First create util.Date, then extract time in milliseconds
		java.sql.Date date1 = new java.sql.Date(new java.util.Date().getTime());
		System.out.println("Converted util.Date to sql.Date: \n" + date1 + "\n");
	}
}
