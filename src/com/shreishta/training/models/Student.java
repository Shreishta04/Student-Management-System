package com.shreishta.training.models;

import java.util.ArrayList;

public class Student extends Person {
    //abstraction of variables (hiding data) - the variables of this class can be altered
    //only by the methods within this class

    private int mark1, mark2;
    private ArrayList<Course> courseList;

    public Student(String name, int mark1, int mark2) {
        super(name);
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.courseList = new ArrayList<>();
    }

    public int getMark1() {
        return mark1;
    }

    public void setMark1(int mark1) {
        this.mark1 = mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public void setMark2(int mark2) {
        this.mark2 = mark2;
    }

    public ArrayList<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(Course course) {
        this.courseList.add(course);
    }

    public void display() {
        System.out.println(" ");
        System.out.println("List of Students: ");
        System.out.println("-------------------");
        System.out.println("Register no: " + getRegNo());
        System.out.println("Name: " + getName());
        System.out.println("Mark 1: " + mark1);
        System.out.println("Mark 2: " + mark2);
        System.out.println("Courses enrolled for: ");
        if (courseList.isEmpty()) {
            System.out.println("There are no courses enrolled yet.");
        } else {
            for (Course c : courseList) {
                System.out.println("Course Id: " + c.getCourseId() + " Course Name: " + c.getCourseName());
            }
        }
    }
}

