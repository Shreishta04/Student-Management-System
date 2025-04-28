package com.shreishta.training.services;
import com.shreishta.training.exceptions.UnauthorizedException;
import com.shreishta.training.models.Course;
import com.shreishta.training.models.Student;
import com.shreishta.training.models.Teacher;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CourseServiceImpl implements courseService{

    @Override
    public Course createCourse(ArrayList<Teacher> teachers) throws UnauthorizedException {
        if (teachers.isEmpty()) {
            throw new IllegalStateException("No teachers exist. Create a teacher first before creating a course.");
        }

        Scanner s = new Scanner(System.in);
        int searchId = 0;
        int flag = 0;
        while(flag == 0) {
            try {
                System.out.println("Enter Teacher Reg No: ");
                searchId = s.nextInt();
                s.nextLine();
                flag = 1;
            } catch (InputMismatchException e) { //two ways to end a program flow: return or throw exception
                System.out.println("Invalid register no!"); //handling the exception gracefully
                s.nextLine();
            }
        }

        String teacherName = " ";
        flag = 0;



        for(Teacher t : teachers){
            if(searchId == t.getRegNo()) {
                flag = 1;
                teacherName = t.getName();
                break;
            }
        }
        if(flag == 0){
            throw new UnauthorizedException("Teacher Not Found. Unauthorised to create new Course.");
        }

        String courseName = " ";
        do{
            System.out.println("Enter Course Name: ");
            courseName = s.nextLine();
            if(courseName.isEmpty()){
                System.out.println("Course Name cannot be blank.");
            }
        }while(courseName.trim().isEmpty());

        Course course = new Course(courseName);
        System.out.println("Course "+courseName+" created by "+teacherName+ " .");
        return course;
    }

    @Override
    public void updateCourse(ArrayList<Teacher> teachers, ArrayList<Course> courses) throws UnauthorizedException{
        if (teachers.isEmpty()) {
            throw new IllegalStateException("No teachers exist. Create a teacher first before creating a course.");
        }

        int searchTeacherId;
        boolean teacherFound = false;
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Teacher Id: ");
        searchTeacherId = s.nextInt();
        s.nextLine();
        String teacherName = " ";


        for(Teacher t: teachers){
            if(searchTeacherId == t.getRegNo()){
                teacherFound = true;
                System.out.println("Teacher found!");
                teacherName = t.getName();
                break;
            }
        }

        if(!teacherFound){
            throw new UnauthorizedException("Teacher not found. Unauthorised to Update Courses.");
        }

        int searchCourseId;
        int tempCourseId = 0;
        boolean courseFound = false;
        String courseName = " ";
        System.out.println("Enter Course Id: ");
        searchCourseId = s.nextInt();
        s.nextLine();
        String newCourseName = " ";
        for (int c = 0; c < courses.size(); c++) {
            if (searchCourseId == courses.get(c).getCourseId()) {
                courseFound = true;
                System.out.println("Course found!!");
                courseName = courses.get(c).getCourseName();
                do{
                    System.out.println("Enter Course Name: ");
                    newCourseName = s.nextLine();
                    if(newCourseName.isEmpty()){
                        System.out.println("Course Name cannot be blank.");
                    }
                }while(newCourseName.trim().isEmpty());

                courses.get(c).setCourseName(newCourseName);
                System.out.println("Course name changed from " +courseName+ " to " +newCourseName+ " by "+teacherName);
            }
        }

        if(!courseFound){
            System.out.println("Course ID " +searchCourseId+ " does not exist!");
        }
    }

    @Override
    public void deleteCourse(ArrayList<Teacher> teachers, ArrayList<Course> courses) throws UnauthorizedException{
        if (teachers.isEmpty()) {
            throw new IllegalStateException("No teachers exist. Create a teacher first before creating a course.");
        }

        Scanner s = new Scanner(System.in);
        System.out.println("Enter Teacher Id: ");
        int searchTeacherId = s.nextInt();
        boolean teacherFound = false;


        String teacherName = " ";
        for(Teacher t : teachers){
            if(searchTeacherId == t.getRegNo()){
                teacherFound = true;
                System.out.println("Teacher found!");
                teacherName = t.getName();
                break;
            }
        }

        if(!teacherFound){
            throw new UnauthorizedException("Teacher not found! Unauthorized to delete courses!");
        }

        int searchCourseId;
        String courseName = " ";
        System.out.println("Enter course ID to delete: ");
        searchCourseId = s.nextInt();
        boolean courseFound = false;
        for(int c = 0; c < courses.size(); c++){
            if(searchCourseId == courses.get(c).getCourseId()){
                courseName = courses.get(c).getCourseName();
                courseFound = true;
                System.out.println("Course found!");
                courses.remove(c);
                System.out.println("Course "+courseName+ " removed by "+teacherName+" !");
                return;
            }
        }
        System.out.println("Course not found!");
    }

    public void registerCourse(ArrayList<Student> students, ArrayList<Course> courses) throws UnauthorizedException{
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Student Id: ");
        int searchStudentId = s.nextInt();
        boolean studentFound = false;
        boolean courseFound = false;
        String studentName = " ";
        String courseName = " ";
        if(students.isEmpty()){
            throw new IllegalStateException("No students registered yet. Create student to register.");
        }

        for(Student student : students){
            if(searchStudentId == student.getRegNo()){
                studentFound = true;
                System.out.println("Student found!!");
                studentName = student.getName();
                break;
            }
        }

        if(!studentFound){
            throw new UnauthorizedException("Student ID not found. Unauthorized to register.");
        }

        System.out.println("Enter course Id to register: ");
        int searchCourseId = s.nextInt();
        for(Course c : courses){
            if (searchCourseId == c.getCourseId()) {
                courseFound = true;
                System.out.println("Course Found!");
                for (Student stud : students) {
                    if (searchStudentId == stud.getRegNo()) {
                        stud.setCourseList(c);
                    }
                }
                System.out.println("Course added!");
            }
        }

        if(!courseFound){
            System.out.println("Course Not found!");
        }

    }
}
