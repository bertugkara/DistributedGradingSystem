package com.distributedstudentgradingsystem.Users.Expert.Entity;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Comment.Entity.Comment;
import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.GradeSubmission;
import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.Users.User.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@DiscriminatorValue("E")
public class Expert extends User implements Serializable {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher referencedTeacherIfExists;

    @ManyToMany(mappedBy = "expertList")
    private List<Class> classList = new ArrayList<>();

    @OneToMany(mappedBy = "expert")
    private List<Homework> assignedSubmissions = new ArrayList<>();

    @OneToMany(mappedBy = "appointedExpert")
    private List<HomeworkSubmission> appointedHomeworkSubmissionList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "graderExpert")
    private List<GradeSubmission> gradeSubmissionList;

    @OneToMany(mappedBy = "writerExpert")
    private List<Comment> commentList= new ArrayList<>();
}
