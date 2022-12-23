package com.distributedstudentgradingsystem.Users.Teacher.Entity;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Homework.Entity.Homework;
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

    private String firstName;
    private String email;
    private String lastName;
    private List<Class> classList;
    private List<Homework> createdHomeworkList;

    public static TeacherProfile fromTeacher(Teacher teacher,
                                             List<Class> classList,
                                             List<Homework> homeworkList
                                             ){
        TeacherProfile teacherProfile = new TeacherProfile();
        teacherProfile.setEmail(teacher.getEmail());
        teacherProfile.setFirstName(teacher.getFirstName());
        teacherProfile.setLastName(teacher.getLastName());
        teacherProfile.setClassList(classList);
        teacherProfile.setCreatedHomeworkList(homeworkList);
        return teacherProfile;
    }
}
