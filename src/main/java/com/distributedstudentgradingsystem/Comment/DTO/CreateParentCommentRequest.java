package com.distributedstudentgradingsystem.Comment.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class CreateParentCommentRequest {
    @NotBlank
    private String comment;
    @NotBlank
    private Long homeworkSubmissionID;
    private Long studentID;
    private Long teacherID;
    private Long ExpertID;
}
