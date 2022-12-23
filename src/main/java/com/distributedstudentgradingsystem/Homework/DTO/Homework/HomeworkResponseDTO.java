package com.distributedstudentgradingsystem.Homework.DTO.Homework;

import com.distributedstudentgradingsystem.Class.DTO.ClassResponseDTO;
import com.distributedstudentgradingsystem.Users.Expert.DTO.PojoExpertResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.PojoTeacherResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeworkResponseDTO {
    private Long id;
    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private ClassResponseDTO classDTO;

    private PojoExpertResponseDTO expert;

    private PojoTeacherResponseDTO creator;
}
