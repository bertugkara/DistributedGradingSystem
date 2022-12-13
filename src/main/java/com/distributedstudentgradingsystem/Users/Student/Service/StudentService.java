package com.distributedstudentgradingsystem.Users.Student.Service;

import com.distributedstudentgradingsystem.Users.Student.Entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> bringStudentsWithIdList(List<Long> idList);
}
