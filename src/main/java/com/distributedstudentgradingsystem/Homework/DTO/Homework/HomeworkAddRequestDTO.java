package com.distributedstudentgradingsystem.Homework.DTO.Homework;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HomeworkAddRequestDTO {

    @FutureOrPresent
    @NotBlank
    private LocalDate startDate;

    @Future
    @NotBlank
    private LocalDate endDate;

    @NotBlank
    @Size(max = 1000)
    private String description;

    @NotNull
    private Long classID;

    @NotNull
    private Long creatorID;
}
