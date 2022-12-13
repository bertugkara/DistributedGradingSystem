package com.distributedstudentgradingsystem.Class.DTO;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class AddClassRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String lessonCode;

    private Integer instructor;

    private List<Integer> studentList;

    private List<Integer> expertList;
}
