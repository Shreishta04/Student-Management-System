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
                    try{
                        students.add(Student.createStudent());
                    } catch (RuntimeException e) {
                        System.out.println("Invalid datatype! Enter correct datatype.");
                        students.add(Student.createStudent());
                    }
                    break;
                case 2:
                    for (int i = 0; i < students.size(); i++) {
                        students.get(i).displayStudent();
                    }
                    break;
                case 3:
                    Student.updateStudent(students);
                    break;
                case 4:
                    Student.delete(students);
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