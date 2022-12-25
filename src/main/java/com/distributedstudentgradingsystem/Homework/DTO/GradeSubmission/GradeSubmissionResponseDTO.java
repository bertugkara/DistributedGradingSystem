package com.distributedstudentgradingsystem.Homework.DTO.GradeSubmission;


import com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission.PojoHomeworkSubmissionResponseDTO;
import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.MarkState;
import com.distributedstudentgradingsystem.Users.Student.DTO.PojoStudentResponseDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class GradeSubmissionResponseDTO {
    private Long id;
    private PojoStudentResponseDTO graderStudent;
    private PojoHomeworkSubmissionResponseDTO submission;
    private short givenPoint;
    private MarkState state;
}
