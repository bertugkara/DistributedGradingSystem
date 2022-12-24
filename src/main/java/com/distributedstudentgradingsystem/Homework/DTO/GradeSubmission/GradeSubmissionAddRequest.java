package com.distributedstudentgradingsystem.Homework.DTO.GradeSubmission;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GradeSubmissionAddRequest {
    private short point;
    private Long graderStudentID;
    private Long homeworkSubmissionID;
}
