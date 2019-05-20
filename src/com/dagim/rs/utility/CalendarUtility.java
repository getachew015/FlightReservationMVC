package com.dagim.rs.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarUtility
{

    public static Calendar getCalendarFromString(String date) throws Exception  {

          /* Instantiated simple date format object and specified the pattern */

          SimpleDateFormat simpleDate=new SimpleDateFormat("MM-dd-yyyy");
          Date dateReference=null;

          /* parse method returns the Java.Util.Date object corresponding to
           * the String date */

          dateReference = simpleDate.parse(date);

          /* Calendar object instantiated and setTime method sets the calendar
           * time with the date passed */

          Calendar calendar = Calendar.getInstance();
          calendar.setTime(dateReference);

          /* the set calendar object is returned */

          return calendar;
    }

    public static String getStringFromCalendar(Calendar calendar) throws Exception
    {

          /* Declaration of variables   */

          Date date=null;
          SimpleDateFormat simpleDate=new SimpleDateFormat("MM-dd-yyyy");

          /* Getting Date from the calendar object and using format method for retrieval of
           * date in text format */

          date = calendar.getTime();
          String textDate = simpleDate.format(date);


          /* the string date is returned */

          return textDate;
    }

}
