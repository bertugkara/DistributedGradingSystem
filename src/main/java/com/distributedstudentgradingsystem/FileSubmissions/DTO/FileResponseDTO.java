package com.distributedstudentgradingsystem.FileSubmissions.DTO;


import com.distributedstudentgradingsystem.Users.Student.DTO.PojoStudentResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Lob;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FileResponseDTO {

    private String name;
    private String type;
    @Lob
    private byte[] data;
    private PojoStudentResponseDTO submissioner;
}
