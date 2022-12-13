package com.distributedstudentgradingsystem.Users.Student.Service;

import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Student.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public List<Student> bringStudentsWithIdList(List<Long> idList) {
        return studentRepository.getStudentsByIdIn(idList);
    }
}
