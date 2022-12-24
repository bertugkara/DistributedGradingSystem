package com.distributedstudentgradingsystem.Homework.Entity;

import com.distributedstudentgradingsystem.FileSubmissions.entity.File;
import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.GradeSubmission;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
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

    @Size(min = 0, max = 500)
    private String description;

    @OneToOne
    @JoinColumn(name = "file_id")
    @NotBlank
    private File file;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id")
    @NotBlank
    private Student owner;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "homework_id")
    @NotBlank
    private Homework homework;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "appointed_expert_id")
    private Expert appointedExpert;

    @OneToOne(fetch = FetchType.EAGER, mappedBy = "submission")
    private GradeSubmission gradeSubmission;

}
