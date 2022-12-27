package com.distributedstudentgradingsystem.Class.Repository;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassRepository extends JpaRepository<Class,Long> {

    List<Class> findAllByStudentListContaining(Student student);
    List<Class> findAllByExpertListContaining(Expert expert);
    List<Class> findClassesByInstructor_Id(Long id);
}