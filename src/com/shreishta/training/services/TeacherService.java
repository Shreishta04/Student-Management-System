package com.shreishta.training.services;

import com.shreishta.training.models.Teacher;

import java.util.ArrayList;

public interface TeacherService {
    Teacher createTeacher();

    public void updateTeacher(ArrayList<Teacher> teachers);

    public void deleteTeacher(ArrayList<Teacher> teachers);
}
