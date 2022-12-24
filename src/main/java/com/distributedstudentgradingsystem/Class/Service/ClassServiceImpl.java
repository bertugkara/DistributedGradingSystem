package com.distributedstudentgradingsystem.Class.Service;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Class.Repository.ClassRepository;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRepository classRepository;

    @Override
    public Result addClass(Class obj) {
        return new Result(classRepository.save(obj) != null);
    }

    @Override
    public List<Class> getAllClasses() {
        List<Class> classList = classRepository.findAll();
        if (!classList.isEmpty()) {
            return classRepository.findAll();
        } else {
            return null;
        }
    }

    @Override
    public Class getOne(Long id) {
        return classRepository.findById(id).orElse(null);
    }

    @Override
    public List<Class> getClassesByStudentId(Student student) {
        if (student != null) {
            return classRepository.findAllByStudentListContaining(student);
        }
        return null;
    }

    @Override
    public List<Class> getClassesByExpertId(Long id) {
        if (id != null) {
            return classRepository.findClassesByExpertListContains(id);
        }
        return null;
    }

    @Override
    public List<Class> getClassesByInstructorId(Long id) {
        if (id != null) {
            classRepository.findClassesByInstructor_Id(id);
        }
        return null;
    }

}


