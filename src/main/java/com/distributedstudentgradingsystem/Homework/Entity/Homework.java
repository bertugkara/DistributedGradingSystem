package com.distributedstudentgradingsystem.Homework.Entity;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.common.BaseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Homework extends BaseEntity {

    @FutureOrPresent
    @NotBlank
    private LocalDate startDate;

    @Future
    @NotBlank
    private LocalDate endDate;

    @NotBlank
    @Size(max = 1000)
    private String description;

    @OneToMany
    @JoinTable(name = "homework_and_submissions",
            joinColumns = @JoinColumn(name ="homework_id"),
            inverseJoinColumns = @JoinColumn(name = "submission_id")
    )
    private List<HomeworkSubmission> submission;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class lesson;

    @ManyToOne
    @JoinColumn(name = "responsible_expert")
    private Expert expert;

    @ManyToOne
    @JoinColumn(name = "creator_id")
    private Teacher creator;

    public void addSubmission(List<HomeworkSubmission> submissionsList)
    {
        this.submission=submissionsList;
    }
}
