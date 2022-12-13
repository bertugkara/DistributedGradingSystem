package com.distributedstudentgradingsystem.Users.Teacher.Repository;

import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.Users.User.Repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends UserRepository<Teacher> {

}
