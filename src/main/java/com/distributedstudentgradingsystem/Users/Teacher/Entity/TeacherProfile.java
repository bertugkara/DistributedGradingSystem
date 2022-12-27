package com.distributedstudentgradingsystem.Users.Teacher.Entity;

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
public class TeacherProfile {
    private Long id;
    private String firstName;
    private String email;
    private String lastName;
    private List<Class> classList;
    private List<Homework> createdHomeworkList;
    private List<HomeworkSubmission> homeworkSubmissionPerformedObjection;

    public static TeacherProfile fromTeacher(Teacher teacher,
                                             List<Class> classList,
                                             List<Homework> homeworkList,
                                             List<HomeworkSubmission> homeworkSubmissionList
                                             ){
        TeacherProfile teacherProfile = new TeacherProfile();
        teacherProfile.setId(teacher.getId());
        teacherProfile.setEmail(teacher.getEmail());
        teacherProfile.setFirstName(teacher.getFirstName());
        teacherProfile.setLastName(teacher.getLastName());
        teacherProfile.setClassList(classList);
        teacherProfile.setCreatedHomeworkList(homeworkList);
        teacherProfile.setHomeworkSubmissionPerformedObjection(homeworkSubmissionList);
        return teacherProfile;
    }
}
