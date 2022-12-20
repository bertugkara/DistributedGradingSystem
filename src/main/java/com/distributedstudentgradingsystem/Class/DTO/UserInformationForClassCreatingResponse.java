package com.distributedstudentgradingsystem.Class.DTO;


import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserInformationForClassCreatingResponse {
    List<Expert> expertResponseDTOList;
    List<Student> studentResponseDTOList;
    List<Teacher> teacherResponseDTOList;
}
