package com.distributedstudentgradingsystem.Users.Admin.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminPojoResponseDTO {

    @NotBlank
    private String email;
}
