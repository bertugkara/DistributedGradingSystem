package com.distributedstudentgradingsystem.Users.Student.Service;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Class.Service.ClassService;
import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import com.distributedstudentgradingsystem.Homework.Service.Homework.HomeworkService;
import com.distributedstudentgradingsystem.Homework.Service.HomeworkSubmission.HomeworkSubmissionService;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Student.Entity.StudentProfile;
import com.distributedstudentgradingsystem.Users.Student.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final ClassService classService;
    private final HomeworkService homeworkService;
    private final HomeworkSubmissionService homeworkSubmissionService;

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

    @Override
    public StudentProfile whoAmI(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        List<Class> classList = classService.getClassesByStudentId(student);
        List<Long> idList = classList.stream().map((Class::getId)).collect(Collectors.toList());
        List<Homework> homeworkList = homeworkService.getAllHomeworksByClassIDList(idList);
        List<HomeworkSubmission> homeworkSubmissionList = homeworkSubmissionService.getAllByStudentId(id);
        StudentProfile studentProfile = StudentProfile.fromStudent(student, classList, homeworkList, homeworkSubmissionList);
        return studentProfile;
    }


}
