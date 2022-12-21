package com.distributedstudentgradingsystem.Homework.DTO.Homework;

import com.distributedstudentgradingsystem.Class.DTO.ClassResponseDTO;
import com.distributedstudentgradingsystem.Users.Expert.DTO.PojoExpertResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.PojoTeacherResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeworkResponseDTO {
    @FutureOrPresent
    @NotBlank
    private LocalDate startDate;

    @Future
    @NotBlank
    private LocalDate endDate;

    @NotBlank
    @Size(max = 1000)
    private String description;

    @NotNull
    private ClassResponseDTO classDTO;

    private PojoExpertResponseDTO expert;

    @NotNull
    private PojoTeacherResponseDTO creator;
}
