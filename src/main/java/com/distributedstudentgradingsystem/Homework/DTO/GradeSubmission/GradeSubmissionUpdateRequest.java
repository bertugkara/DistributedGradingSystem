package com.distributedstudentgradingsystem.Homework.DTO.GradeSubmission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class GradeSubmissionUpdateRequest {
    @NotBlank
    private short point;
    private Long teacherID;
    private Long expertID;
    @NotBlank
    private Long currentGradeSubmissionId;
}
