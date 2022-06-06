package com.studyapp.StudentsCourse.Controller;

import java.util.Calendar;

public class Student {
    //studentName consists of the first and last name
    private String studentName;
    private Calendar courseStartDate;
    private Calendar courseEndDate;


    //constructor
    public Student(String _studentName, Calendar _courseStartDate, Calendar _courseEndDate) {
        this.studentName = _studentName;
        this.courseStartDate = _courseStartDate;
        this.courseEndDate = _courseEndDate;
    }

    public String getStudentName(){
        return studentName;
    }

    public Calendar getCourseStartDate(){
        return courseStartDate;
    }

    public Calendar getCourseEndDate(){
        return courseEndDate;
    }
}
