package com.distributedstudentgradingsystem.Users.Student.Service;

import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Student.Entity.StudentProfile;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Set;

public interface StudentService {

    Student findById(Long id) throws EntityNotFoundException;
    Set<Student> findByIdList(List<Long> idList);

    List<Student> findAllStudents();

    StudentProfile whoAmI(Long id);
    Boolean classFailSuccessCheck(Long classID, Long studentID);


}
