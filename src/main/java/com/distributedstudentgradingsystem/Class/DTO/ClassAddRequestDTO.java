package com.distributedstudentgradingsystem.Class.DTO;


import lombok.*;

import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ClassAddRequestDTO {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String lessonCode;

    private Long instructor;

    private List<Long> expertList;

    private List<Long> studentList;
}
