package com.shreishta.training;
import com.shreishta.training.services.studentService;
import com.shreishta.training.models.Student;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        int ch;
        do{
            System.out.println("1. Create Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            Scanner s = new Scanner(System.in);
            ch = s.nextInt();
            switch(ch){
                case 1:
                    students.add(studentService.createStudent());
                    break;
                case 2:
                    if(students.isEmpty()){
                        System.out.println("No Student Details to be displayed! Create student to display...");
                    }
                    else {
                        for (int i = 0; i < students.size(); i++) {
                            students.get(i).displayStudent();
                        }
                    }
                    break;
                case 3:
                    studentService.updateStudent(students);
                    break;
                case 4:
                    studentService.delete(students);
                    break;
                case 5:
                    System.out.println("Exiting loop...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }while(ch!=5);
    }
}