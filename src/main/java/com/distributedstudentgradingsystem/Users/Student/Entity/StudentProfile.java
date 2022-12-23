package com.distributedstudentgradingsystem.Users.Student.Entity;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StudentProfile {
    private Long id;
    private String firstName;
    private String email;
    private String lastName;
    private List<Class> classList;
    private List<Homework> responsibleHomeworkList;
    private List<HomeworkSubmission> submissionList;

    public static StudentProfile fromStudent(Student student,
                                             List<Class> classList,
                                             List<Homework> homeworkList,
                                             List<HomeworkSubmission> homeworkSubmissionList){
        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setId(student.getId());
        studentProfile.setEmail(student.getEmail());
        studentProfile.setFirstName(student.getFirstName());
        studentProfile.setLastName(student.getLastName());
        studentProfile.setClassList(classList);
        studentProfile.setResponsibleHomeworkList(homeworkList);
        studentProfile.setSubmissionList(homeworkSubmissionList);
        return studentProfile;
    }
}
