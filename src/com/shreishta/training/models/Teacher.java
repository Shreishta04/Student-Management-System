package com.shreishta.training.models;

public class Teacher extends Person {
    private String dept;
    private float salary;

    public Teacher(String name, String dept, float salary){
        super(name);
        this.dept = dept;
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void display(){
        System.out.println(" ");
        System.out.println("Reg No: " +getRegNo());
        System.out.println("Name: " +getName());
        System.out.println("Dept: " +dept);
        System.out.println("Salary: " +salary);
    }
}
