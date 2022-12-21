package com.distributedstudentgradingsystem.Users.Expert.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExpertAddRequestDTO {
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Size(max = 50)
    private String username;
    @NotBlank
    @Size(max = 100)
    private String firstName;
    @NotBlank
    @Size(max = 50)
    private String lastName;
    @NotBlank
    @Size(max = 50)
    private String password;

    private Long referencedTeacherID;
}
