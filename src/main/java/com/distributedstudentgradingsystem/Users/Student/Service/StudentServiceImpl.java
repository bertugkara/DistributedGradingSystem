package com.distributedstudentgradingsystem.Users.Student.Service;

import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Student.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public Student findById(Long id) throws EntityNotFoundException {
        if (id != null) {
            return studentRepository.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public Set<Student> findByIdList(List<Long> idList) {
        if (idList != null && !idList.isEmpty()) {
            return new HashSet<>(studentRepository.getStudentsByIdIn(idList));
        }
        return null;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }


}
