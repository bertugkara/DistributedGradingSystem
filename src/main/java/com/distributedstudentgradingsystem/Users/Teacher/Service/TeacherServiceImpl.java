package com.distributedstudentgradingsystem.Users.Teacher.Service;

import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.Users.Teacher.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher findById(Long id) {
        if (id != null) {
            return teacherRepository.findById(id).orElse(null);
        }
        return null;
    }
}
