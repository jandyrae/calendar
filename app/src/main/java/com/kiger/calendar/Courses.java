package com.kiger.calendar;

public class Courses {

    String course, time, date, month, year;

    public Courses(String course, String time, String date, String month, String year) {
        this.course = course;
        this.time = time;
        this.date = date;
        this.month = month;
        this.year = year;
    }

    public String getCourse() {
        return course;
    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }
}
