package com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission;

import com.distributedstudentgradingsystem.Homework.DTO.Homework.HomeworkResponseDTO;
import com.distributedstudentgradingsystem.Users.Student.DTO.PojoStudentResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class PojoHomeworkSubmissionResponseDTO {
    private String description;
    private Long id;
    private Instant createdDate;
    private PojoStudentResponseDTO owner;
    private HomeworkResponseDTO homework;
}
