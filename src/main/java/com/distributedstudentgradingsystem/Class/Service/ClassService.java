package com.distributedstudentgradingsystem.Class.Service;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.utilities.Result;

import java.util.List;

public interface ClassService {

    Result addClass(Class pojoClass);

    List<Class> getAllClasses();

    Class getOne(Long id);

    List<Class> getClassesByStudentId(Student student);
    List<Class> getClassesByExpertId(Long id);

    List<Class> getClassesByInstructorId(Long id);
}
