package com.distributedstudentgradingsystem.Users.Teacher.Service;

import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher findById(Long id);

    List<Teacher> findAllTeachersAndConvertToResponseDTO();
}
