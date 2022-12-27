package com.distributedstudentgradingsystem.Users.Expert.DTO;

import com.distributedstudentgradingsystem.Class.DTO.ClassResponseDTO;
import com.distributedstudentgradingsystem.Homework.DTO.Homework.HomeworkResponseDTO;
import com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission.HomeworkSubmissionResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ExpertProfileResponseDTO {
    private String firstName;
    private String email;
    private String lastName;
    private List<ClassResponseDTO> classList;
    private List<HomeworkResponseDTO> responsibleHomeworkList;
    private List<HomeworkSubmissionResponseDTO> homeworkSubmissionPerformedObjection;
}
