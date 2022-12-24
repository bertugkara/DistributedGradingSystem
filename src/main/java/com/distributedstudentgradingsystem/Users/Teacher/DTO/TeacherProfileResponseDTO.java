package com.distributedstudentgradingsystem.Users.Teacher.DTO;

import com.distributedstudentgradingsystem.Class.DTO.ClassResponseDTO;
import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class TeacherProfileResponseDTO {
    private String firstName;
    private String email;
    private String lastName;
    private List<ClassResponseDTO> classList;
    private List<Homework> createdHomeworkList;
}
