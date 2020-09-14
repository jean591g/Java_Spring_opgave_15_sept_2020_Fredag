package com.spring.demos.services;

import java.util.Calendar;
import java.util.Date;

public class ErDetFredag {

        private int d;
        public void setD(int d) { this.d = d; }
        public int getD(){
            return this.d;
        }

        public void zeller() {

            Date date = new Date();
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH) +1; // counts months from 0 = January, so add +1
            int year = cal.get(Calendar.YEAR);

            System.out.println("Date of today: " + day + "/" + month + "/" + year);

            // q is the day of the month
            int q = day;
            // m is the month (1-12)
            int m = month;
            // out of the year, we will get:
            // j as the century: year/100
            // k as the year of the century: year%100
            int j = (int) (year/100.0);
            int k = year%100;
            int h = (q + ((int)((13*(m+1))/5.0) + k + (int)(k/4.0) + (int)(j/4.0) + (5*j)))%7;
            // d is the day of the week
            d = ((h+5)%7)+1;

            System.out.println("Weekday number today: " + d);

        }
}



