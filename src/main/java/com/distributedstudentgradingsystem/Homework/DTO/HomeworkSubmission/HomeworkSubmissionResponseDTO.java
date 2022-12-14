package com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission;


import com.distributedstudentgradingsystem.FileSubmissions.DTO.FileResponseDTO;
import com.distributedstudentgradingsystem.Homework.DTO.GradeSubmission.GradeSubmissionResponseDTO;
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
public class HomeworkSubmissionResponseDTO {
    private String description;
    private Long id;
    private Instant createdDate;
    private PojoStudentResponseDTO owner;
    private HomeworkResponseDTO homework;
    private FileResponseDTO fileDTO;
    private GradeSubmissionResponseDTO gradeSubmission;
}
