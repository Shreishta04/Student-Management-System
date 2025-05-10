package com.shreishta.training.models;

public abstract class Person {
    protected static int count = 0;
    protected int regNo;
    protected String name;

    public Person(String name) {
        count++;
        this.regNo = count;
        this.name = name;
    }

    public int getRegNo() {
        return regNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract public void display();
}
