package com.distributedstudentgradingsystem.Announcements.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class AddAnnouncementRequestDTO {
    @NotBlank
    private String announcement;
    private Long adminID;
    private Long instructorID;

}
