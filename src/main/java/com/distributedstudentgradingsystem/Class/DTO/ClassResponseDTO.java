package com.distributedstudentgradingsystem.Class.DTO;


import com.distributedstudentgradingsystem.Users.Expert.DTO.PojoExpertResponseDTO;
import com.distributedstudentgradingsystem.Users.Student.DTO.PojoStudentResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.PojoTeacherResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClassResponseDTO {

    private String name;
    private String description;
    private String lessonCode;
    private PojoTeacherResponseDTO instructor;
    private Set<PojoExpertResponseDTO> expertList;
    private Set<PojoStudentResponseDTO> studentList;

}
