package com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission;


import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.common.BaseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GradeSubmission extends BaseEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grader_student_id")
    private Student graderStudent;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "homework_submission_id")
    private HomeworkSubmission submission;

    @Min(0)
    @Max(100)
    private short givenPoint;

    @Enumerated(value = EnumType.STRING)
    private MarkState state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grader_teacher")
    private Teacher graderTeacher;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grader_expert")
    private Expert graderExpert;
}
