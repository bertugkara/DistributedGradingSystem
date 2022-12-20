package com.distributedstudentgradingsystem.Class.DTO;


import com.distributedstudentgradingsystem.Users.Expert.DTO.PojoExpertResponseDTO;
import com.distributedstudentgradingsystem.Users.Student.DTO.PojoStudentResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.PojoTeacherResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class UserInformationForClassCreatingResponseDTO {
    List<PojoExpertResponseDTO> expertResponseDTOList;
    List<PojoStudentResponseDTO> studentResponseDTOList;
    List<PojoTeacherResponseDTO> teacherResponseDTOList;
}
