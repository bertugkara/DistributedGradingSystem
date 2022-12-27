package com.distributedstudentgradingsystem.Homework.DTO.GradeSubmission;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GradeSubmissionAddRequest {
    @NotBlank
    private short point;
    @NotBlank
    private Long graderStudentID;
    @NotBlank
    private Long homeworkSubmissionID;
}
