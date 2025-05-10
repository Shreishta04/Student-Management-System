package com.shreishta.training.services;

import com.shreishta.training.exceptions.UnauthorizedException;
import com.shreishta.training.models.Course;
import com.shreishta.training.models.Student;
import com.shreishta.training.models.Teacher;

import java.util.ArrayList;

public interface CourseService {
    Course createCourse(ArrayList<Teacher> teachers) throws UnauthorizedException;

    void updateCourse(ArrayList<Teacher> teachers, ArrayList<Course> courses) throws UnauthorizedException;

    void deleteCourse(ArrayList<Teacher> teachers, ArrayList<Course> courses) throws UnauthorizedException;

    void registerCourse(ArrayList<Student> students, ArrayList<Course> courses) throws UnauthorizedException;
}
