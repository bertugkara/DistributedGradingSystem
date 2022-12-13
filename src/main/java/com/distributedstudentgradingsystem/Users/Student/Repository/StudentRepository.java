package com.distributedstudentgradingsystem.Users.Student.Repository;

import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.User.Repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends UserRepository<Student> {

    List<Student> getStudentsByIdIn(List<Long> idList);

}
