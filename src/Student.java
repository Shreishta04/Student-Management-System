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

    public void displayStudent() {
        System.out.println("Register no: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("Mark 1: " + mark1);
        System.out.println("Mark 2: " + mark2);
    }

    /*utility method (helper methods are usually static)
    it is used to create a static object*/

    public static Student createStudent(){
        Scanner s = new Scanner(System.in);
        String name = "";
//      System.out.println("1"+name+"2");
        while(name == ""){
            System.out.println("Enter name: ");
            name = s.nextLine();
            if(name == ""){
                System.out.println("Name field cannot be empty!");
            }
        }
        float mark1 = 0, mark2 = 0;
        int flag = 0;
        while(flag == 0) {
            try {
                System.out.println("Enter mark1: ");
                mark1 = s.nextFloat();
                s.nextLine();
                flag = 1;
            } catch (InputMismatchException e) { //two ways to end a program flow: return or throw exception
                System.out.println("Invalid datatype!"); //handling the exception gracefully
                s.nextLine();
            }
        }
        flag = 0;
        while(flag == 0){
            try{
                System.out.println("Enter mark2: ");
                mark2 = s.nextFloat();s.nextLine();
                flag = 1;
            } catch (InputMismatchException e) { //two ways to end a program flow: return or throw exception
                System.out.println("Invalid datatype!");
                s.nextLine();
            }
        }
        Student student = new Student(name, Math.round(mark1), Math.round(mark2));
        System.out.println("Student created!");
        return student;
    }

    public static void updateStudent(ArrayList<Student> students){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Reg No. to update: ");
        int searchRegNo = s.nextInt();
        int flag = 0;
        s.nextLine();
        for(int i = 0; i < students.size(); i++) {
            if (searchRegNo == students.get(i).regNo) {
                flag = 1;
                System.out.println("Student " + students.get(i).regNo + " found!");
                String newName = "";
                while(newName == "") {
                    System.out.println("Enter name: ");
                    newName = s.nextLine();
                    if (newName == "") {
                        System.out.println("Name field cannot be empty!");
                    }
                }
                students.get(i).name = newName;

                float newMark1 = 0, newMark2 = 0;
                flag = 0;
                while(flag == 0) {
                    try {
                        System.out.println("Enter mark1: ");
                        newMark1 = s.nextFloat();
                        s.nextLine();
                        flag = 1;
                    } catch (InputMismatchException e) { //two ways to end a program flow: return or throw exception
                        System.out.println("Invalid datatype!"); //handling the exception gracefully
                        s.nextLine();
                    }
                }
                students.get(i).mark1 = Math.round(newMark1);
                flag = 0;
                while(flag == 0){
                    try{
                        System.out.println("Enter mark2: ");
                        newMark2 = s.nextFloat();
                        s.nextLine();
                        flag = 1;
                    } catch (InputMismatchException e) { //two ways to end a program flow: return or throw exception
                        System.out.println("Invalid datatype!");
                        s.nextLine();
                    }
                }
                students.get(i).mark2 = Math.round(newMark2);
                System.out.println("Student details updated!");
            }
        }
        if (flag == 0) {
            System.out.println("Student not found!!");
        }
    }

    public static void delete(ArrayList<Student> students){
        System.out.println("Enter ID to delete: ");
        Scanner s = new Scanner(System.in);
        int searchRegNo = s.nextInt();
        s.nextLine();
        for(int i = 0; i <= students.size(); i++){
            if(searchRegNo == students.get(i).regNo){
                System.out.println("Student " +students.get(i).regNo + " found");
                students.remove(i);
                System.out.println("Student details deleted!");
                return;
            }
        }
        System.out.println("Student not found!!");
    }
}

