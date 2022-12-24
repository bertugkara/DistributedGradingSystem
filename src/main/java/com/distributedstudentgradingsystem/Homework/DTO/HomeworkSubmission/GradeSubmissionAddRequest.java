package com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class GradeSubmissionAddRequest {
    private Long graderStudentID;
    private Long homeworkSubmissionID;
    private short point;
}
