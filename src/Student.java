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

    public void displayStudent(){
        System.out.println("Register no: " +regNo);
        System.out.println("Name: "+name);
        System.out.println("Mark 1: "+mark1);
        System.out.println("Mark 2: "+mark2);
    }

    /*utility method (helper methods are usually static)
    it is used to create a static object*/

    public static Student createStudent(){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = s.nextLine();
        try{
            System.out.println("Enter mark1: ");
            int mark1 = s.nextInt();
            System.out.println("Enter mark2: ");
            int mark2 = s.nextInt();
            Student student = new Student(name, mark1, mark2);
            System.out.println("Student created!");
            return student;
        } catch (InputMismatchException e) { //two ways to end a program flow: return or throw exception
            throw new RuntimeException("Invalid datatype!");
        }
    }

    public static void updateStudent(ArrayList<Student> students){
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Reg No. to update: ");
        int searchRegNo = s.nextInt();
        s.nextLine();
        for(int i = 0; i < students.size(); i++){
            if(searchRegNo == students.get(i).regNo) {
                System.out.println("Student " + students.get(i).regNo + " found!");

                System.out.println("Enter new name: ");
                String newName = s.nextLine();
                students.get(i).name = newName;

                System.out.println("Enter new mark1: ");
                int newMark1 = s.nextInt();
                students.get(i).mark1 = newMark1;

                System.out.println("Enter new mark2: ");
                int newMark2 = s.nextInt();
                students.get(i).mark2 = newMark2;

                System.out.println("Student details updated!");
            }
        }
        //System.out.println("Student not found!!");
    }

    public static void delete(ArrayList<Student> students){
        System.out.println("Enter ID to delete: ");
        Scanner s = new Scanner(System.in);
        int searchRegNo = s.nextInt();
        s.nextLine();
        for(int i = 0; i < students.size(); i++){
            if(searchRegNo == students.get(i).regNo){
                System.out.println("Student " +students.get(i).regNo + " found!!");
                students.remove(i);
                System.out.println("Deleted!");
                return;
            }
        }
        System.out.println("Student not found!!");
    }
}

