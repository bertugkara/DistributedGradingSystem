package com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class HomeworkSubmissionAddRequest {
    @NotBlank
    private String description;
    @NotBlank
    private Long creatorID;
    @NotBlank
    private Long homeworkID;
}
