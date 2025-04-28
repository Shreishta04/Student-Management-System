package com.shreishta.training.services;

import com.shreishta.training.models.Student;

import java.util.ArrayList;

public interface StudentService {
    Student createStudent();

    void updateStudent(ArrayList<Student> students);

    void deleteStudent(ArrayList<Student> students);
}
