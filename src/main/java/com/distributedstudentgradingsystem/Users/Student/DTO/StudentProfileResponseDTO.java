package com.distributedstudentgradingsystem.Users.Student.DTO;


import com.distributedstudentgradingsystem.Class.DTO.ClassResponseDTO;
import com.distributedstudentgradingsystem.Homework.DTO.Homework.HomeworkResponseDTO;
import com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission.HomeworkSubmissionResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class StudentProfileResponseDTO {
    private Long id;
    private String firstName;
    private String email;
    private String lastName;
    private List<ClassResponseDTO> classList;
    private List<HomeworkResponseDTO> responsibleHomeworkList;
    private List<HomeworkSubmissionResponseDTO> submissionList;
}
