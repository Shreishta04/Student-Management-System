package com.shreishta.training.models;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
    //abstraction of variables (hiding data) - the variables of this class can be altered
    //only by the methods within this class
    private static int count = 0;
    private int regNo;
    private String name;
    private int mark1, mark2;

    public Student(String name, int mark1, int mark2){
        count++;
        this.regNo = count;
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public int getRegNo(){
        return regNo;
    }
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getMark1(){
        return mark1;
    }

    public void setMark1(int mark1){
        this.mark1 = mark1;
    }

    public int getMark2(){
        return mark2;
    }

    public void setMark2(int mark2){
        this.mark2 = mark2;
    }
    public void displayStudent() {
        System.out.println("Register no: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("Mark 1: " + mark1);
        System.out.println("Mark 2: " + mark2);
    }
}

