package com.shreishta.training;

import com.shreishta.training.exceptions.UnauthorizedException;
import com.shreishta.training.models.Course;
import com.shreishta.training.models.Student;
import com.shreishta.training.models.Teacher;
import com.shreishta.training.services.CourseServiceImpl;
import com.shreishta.training.services.StudentServiceImpl;
import com.shreishta.training.services.TeacherServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Teacher> teachers = new ArrayList<>();
        ArrayList<Course> courses = new ArrayList<>();

        StudentServiceImpl studentServiceImpl = new StudentServiceImpl();
        TeacherServiceImpl teacherServiceImpl = new TeacherServiceImpl();
        CourseServiceImpl courseServiceImpl = new CourseServiceImpl();

        int ch;
        do {
            System.out.println("1. Create Student     |  8. Delete Teacher");
            System.out.println("2. Display Students   |  9. Create Course");
            System.out.println("3. Update Student     |  10. Display Course");
            System.out.println("4. Delete Student     |  11. Update Course");
            System.out.println("5. Create Teacher     |  12. Delete Course");
            System.out.println("6. Display Teachers   |  13. Register for Course");
            System.out.println("7. Update Teacher     |  14. Exit");
            System.out.println("Enter your choice: ");
            Scanner s = new Scanner(System.in);
            ch = s.nextInt();
            switch (ch) {
                case 1:
                    students.add(studentServiceImpl.createStudent());
                    break;
                case 2:
                    if (students.isEmpty()) {
                        System.out.println("No Student Details to be displayed! Create student to display...");
                    } else {
                        System.out.println("Students - Details");
                        System.out.println("------------------");
                        for (Student i : students) {
                            i.display();
                        }
                    }
                    break;
                case 3:
                    studentServiceImpl.updateStudent(students);
                    break;
                case 4:
                    studentServiceImpl.deleteStudent(students);
                    break;
                case 5:
                    teachers.add(teacherServiceImpl.createTeacher());
                    break;
                case 6:
                    if (teachers.isEmpty()) {
                        System.out.println("No teachers to display!");
                    } else {
                        System.out.println("Teachers - Details");
                        System.out.println("------------------");
                        for (Teacher t : teachers) {
                            t.display();
                        }
                    }
                    break;
                case 7:
                    teacherServiceImpl.updateTeacher(teachers);
                    break;
                case 8:
                    teacherServiceImpl.deleteTeacher(teachers);
                    break;
                case 9:
                    try {
                        courses.add(courseServiceImpl.createCourse(teachers));
                    } catch (IllegalStateException | UnauthorizedException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 10:
                    System.out.println("List of Courses");
                    System.out.println("------------------");
                    if (courses.isEmpty()) {
                        System.out.println("No Courses created yet.");
                    } else {
                        for (Course c : courses) {
                            c.display();
                        }
                    }
                    break;
                case 11:
                    if (courses.isEmpty()) {
                        System.out.println("No Courses created yet.");
                    } else {
                        try {
                            courseServiceImpl.updateCourse(teachers, courses);
                        } catch (UnauthorizedException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    break;
                case 12:
                    if (courses.isEmpty()) {
                        System.out.println("No Courses created yet.");
                    } else {
                        try {
                            courseServiceImpl.deleteCourse(teachers, courses);
                        } catch (UnauthorizedException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    }

                    break;
                case 13:
                    if (courses.isEmpty()) {
                        System.out.println("No Courses created yet.");
                    } else {
                        try {
                            courseServiceImpl.registerCourse(students, courses);
                        } catch (UnauthorizedException e) {
                            System.out.println("Error: " + e.getMessage());
                            ;
                        }
                    }
                    break;
                case 14:
                    System.out.println("Exiting loop...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (ch != 14);
    }
}