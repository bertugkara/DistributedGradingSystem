package com.distributedstudentgradingsystem.Class.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@Setter
public class AddPojoClassRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String lessonCode;
}
