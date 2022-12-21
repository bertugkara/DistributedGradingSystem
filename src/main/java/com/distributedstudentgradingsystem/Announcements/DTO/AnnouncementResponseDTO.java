package com.distributedstudentgradingsystem.Announcements.DTO;

import com.distributedstudentgradingsystem.Users.Admin.DTO.AdminPojoResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.PojoTeacherResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class AnnouncementResponseDTO {

    private String announcement;
    private AdminPojoResponseDTO adminPojoResponseDTO;
    private PojoTeacherResponseDTO pojoTeacherResponseDTO;

}
