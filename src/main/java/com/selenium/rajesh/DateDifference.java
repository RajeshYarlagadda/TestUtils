package com.selenium.rajesh;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateDifference {

	private static boolean between(Date date, Date dateStart, Date dateEnd) {
	    if (date != null && dateStart != null && dateEnd != null) {
	        return (dateEqualOrAfter(date, dateStart) && dateEqualOrBefore(date, dateEnd));
	    }
	    return false;
	}

	private static boolean dateEqualOrAfter(Date dateInQuestion, Date date2)
	{
	    if (dateInQuestion.equals(date2))
	        return true;

	    return (dateInQuestion.after(date2));

	}
	private static boolean dateEqualOrBefore(Date dateInQuestion, Date date2)
	{
	    if (dateInQuestion.equals(date2))
	        return true;

	    return (dateInQuestion.before(date2));

	}
	public static void main(String[] args) throws ParseException {
		DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
		Date d1 = fmt.parse("2015-07-19");
		Date d2 = fmt.parse("2015-07-25");
		Date d3 = fmt.parse("2015-07-18");
		System.out.println(between(d3, d1, d2));
	}

}
