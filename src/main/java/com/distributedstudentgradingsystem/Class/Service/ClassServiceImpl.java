package com.distributedstudentgradingsystem.Class.Service;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Class.Repository.ClassRepository;
import com.distributedstudentgradingsystem.Users.Expert.Service.ExpertService;
import com.distributedstudentgradingsystem.Users.Student.Service.StudentService;
import com.distributedstudentgradingsystem.Users.Teacher.Service.TeacherService;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final StudentService studentService;
    private final TeacherService teacherService;
    private final ExpertService expertService;
    private final ClassRepository classRepository;

    @Override
    public Result addPojoClass(Class pojoClass){
        classRepository.save(pojoClass);
        return new Result(true);
    }
}


