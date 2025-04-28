package com.shreishta.training.services;
import java.util.ArrayList;
import com.shreishta.training.models.Student;

public interface StudentService {
    Student createStudent();
    void updateStudent(ArrayList<Student> students);
    void deleteStudent(ArrayList<Student> students);
}
