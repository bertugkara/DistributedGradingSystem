package com.distributedstudentgradingsystem.Users.Student.Service;

import com.distributedstudentgradingsystem.Users.Student.Entity.Student;

import java.util.List;
import java.util.Set;

public interface StudentService {

    Student findById(Long id);
    Set<Student> findByIdList(List<Long> idList);

    List<Student> findAllStudents();

}
