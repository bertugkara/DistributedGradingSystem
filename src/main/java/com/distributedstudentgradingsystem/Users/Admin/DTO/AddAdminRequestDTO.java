package com.distributedstudentgradingsystem.Users.Admin.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
public class AddAdminRequestDTO {
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
}
