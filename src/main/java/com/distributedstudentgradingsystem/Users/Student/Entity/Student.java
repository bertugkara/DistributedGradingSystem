package com.distributedstudentgradingsystem.Users.Student.Entity;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.GradeSubmission;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
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
@DiscriminatorValue("S")
public class Student extends User implements Serializable {

    @ManyToMany(mappedBy = "studentList")
    private List<Class> classList = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
    private List<HomeworkSubmission> homeworkSubmissions;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "graderStudent")
    private List<GradeSubmission> gradeSubmissionList;

    public boolean isStudentPassedTheClass(Long classID) {
        short submissionCount = (short) homeworkSubmissions.size();
        int score = homeworkSubmissions.stream().
                filter(homeworkSubmission ->
                        homeworkSubmission.getHomework().getLesson().getId().equals(classID) && homeworkSubmission.getGradeSubmission() != null)
                .map(homeworkSubmission -> homeworkSubmission.getGradeSubmission().getGivenPoint())
                .mapToInt(Short::intValue)
                .sum();
        return score >= submissionCount * 50 ? true : false;
    }

}
