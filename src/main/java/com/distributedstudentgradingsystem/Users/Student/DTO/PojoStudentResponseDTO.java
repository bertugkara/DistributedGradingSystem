package com.distributedstudentgradingsystem.Users.Student.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PojoStudentResponseDTO {
    private String firstName;
    private String email;
    private String lastName;
}
