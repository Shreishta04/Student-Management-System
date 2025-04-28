package com.shreishta.training.services;
import com.shreishta.training.models.Teacher;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TeacherServiceImpl implements TeacherService {

    public Teacher createTeacher(){
        Scanner s = new Scanner(System.in);
        String name = " ";
        while(name == " "){
            System.out.println("Enter name: ");
            name = s.nextLine();
            if(name == " "){
                System.out.println("Name cannot be blank!");
            }
        }

        String dept = " ";
        while(dept == " "){
            System.out.println("Enter department: ");
            dept = s.nextLine();
            if(dept == " "){
                System.out.println("Department cannot be blank!");
            }
        }

        int flag = 0 ;
        float salary = 0;
        while(flag == 0){
            try{
                System.out.println("Enter salary: ");
                salary = s.nextFloat();
                s.nextLine();
                flag = 1;
            }catch(InputMismatchException e){
                System.out.println("Enter valid Salary!");
                s.nextLine();
            }
        }

        Teacher teacher = new Teacher(name, dept, salary);
        System.out.println("Teacher Created!");
        return teacher;
    }

    public void updateTeacher(ArrayList<Teacher> teachers){
        int flag = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter reg no: ");
        int searchRegNo = s.nextInt();
        s.nextLine();
        for(int t = 0; t < teachers.size(); t++){
            if(searchRegNo == teachers.get(t).getRegNo()){
                flag = 1;
                System.out.println("Teacher found!");
                String newName = " ";
                while(newName == " "){
                    System.out.println("Enter new Name: ");
                    newName = s.nextLine();
                    if(newName == " "){
                        System.out.println("Name cannot be blank!");
                    }
                }

                teachers.get(t).setName(newName);

                String newDept = " ";
                while(newDept == " "){
                    System.out.println("Enter new department: ");
                    newDept = s.nextLine();
                    if(newDept == " "){
                        System.out.println("Department cannot be blank!");
                    }
                }
                teachers.get(t).setDept(newDept);

                flag = 0 ;
                float newSalary = 0;
                while(flag == 0){
                    try{
                        System.out.println("Enter new salary: ");
                        newSalary = s.nextFloat();
                        s.nextLine();
                        flag = 1;
                    }catch(InputMismatchException e){
                        System.out.println("Enter valid Salary!");
                        s.nextLine();
                    }
                }
                teachers.get(t).setSalary(newSalary);
                System.out.println("Details Updated!");
            }
        }
        if(flag == 0){
            System.out.println("Teacher not found!");
        }
    }
    public void deleteTeacher(ArrayList<Teacher> teachers){
        int flag = 0;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter reg no: ");
        int searchRegNo = s.nextInt();
        for(int t = 0; t < teachers.size(); t++){
            if(searchRegNo == teachers.get(t).getRegNo()){
                flag = 1;
                System.out.println("Teacher with id " +searchRegNo+ " found!");
                teachers.remove(t);
                System.out.println("Teacher with id " +searchRegNo+ " removed!");
            }
        }
        if(flag == 0){
            System.out.println("Teacher not found!");
        }
    }

}
