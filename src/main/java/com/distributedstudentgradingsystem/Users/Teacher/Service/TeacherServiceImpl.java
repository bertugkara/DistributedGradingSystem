package com.distributedstudentgradingsystem.Users.Teacher.Service;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Class.Service.ClassService;
import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import com.distributedstudentgradingsystem.Homework.Service.Homework.HomeworkService;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.TeacherProfile;
import com.distributedstudentgradingsystem.Users.Teacher.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;
    private final ClassService classService;
    private final HomeworkService homeworkService;

    @Override
    public Teacher findById(Long id) {
        if (id != null) {
            return teacherRepository.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public List<Teacher> findAllTeachersAndConvertToResponseDTO() {
        return teacherRepository.findAll();
    }

    @Override
    public TeacherProfile whoAmI(Long id) {
        Teacher teacher = teacherRepository.findById(id).orElse(null);
        List<Class> classesByInstructorId = classService.getClassesByInstructorId(id);
        List<Homework> allHomeworksByCreatorId = homeworkService.getAllHomeworksByCreatorId(id);
        TeacherProfile teacherProfile = TeacherProfile.fromTeacher(teacher,classesByInstructorId,allHomeworksByCreatorId);
        return teacherProfile;
    }
}
