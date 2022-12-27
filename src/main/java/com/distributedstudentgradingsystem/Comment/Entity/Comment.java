package com.distributedstudentgradingsystem.Comment.Entity;


import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.common.BaseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity {

    @Max(1000)
    private String comment;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "homeworkSubmissionId")
    private HomeworkSubmission homeworkSubmission;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student writerStudent;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher writerTeacher;

    @ManyToOne
    @JoinColumn(name = "expert_id")
    private Expert writerExpert;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "anchestorCommentId")
    private Comment anchestorComment;

    @ManyToOne(fetch = FetchType.EAGER)
    private Comment childComment;
}
