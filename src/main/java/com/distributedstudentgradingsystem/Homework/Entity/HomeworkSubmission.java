package com.distributedstudentgradingsystem.Homework.Entity;

import com.distributedstudentgradingsystem.FileSubmissions.entity.File;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.common.BaseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "homework_submissions")
public class HomeworkSubmission extends BaseEntity {

    @Size(min = 0,max = 500)
    private String description;

    @OneToOne
    @JoinColumn(name = "file_id")
    @NotBlank
    private File file;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @NotBlank
    private Student owner;

    @ManyToOne
    @JoinColumn(name = "homework_id")
    @NotBlank
    private Homework homework;
}
