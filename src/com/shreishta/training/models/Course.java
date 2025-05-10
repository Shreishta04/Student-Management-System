package com.shreishta.training.models;

public class Course {
    private static int count = 0;
    private int courseId;
    private String courseName;

    public Course(String courseName) {
        count++;
        this.courseId = count;
        this.courseName = courseName;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public void display() {
        System.out.println("Course Id: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println(" ");
    }
}
