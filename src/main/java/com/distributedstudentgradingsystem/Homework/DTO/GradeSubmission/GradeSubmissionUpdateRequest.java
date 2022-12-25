package com.distributedstudentgradingsystem.Homework.DTO.GradeSubmission;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class GradeSubmissionUpdateRequest {
    private short point;
    private Long teacherID;
    private Long expertID;
    private Long currentGradeSubmissionId;
}
