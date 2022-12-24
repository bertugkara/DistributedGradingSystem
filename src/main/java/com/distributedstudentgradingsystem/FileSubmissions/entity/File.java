package com.distributedstudentgradingsystem.FileSubmissions.entity;

import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.common.BaseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class File extends BaseEntity {

    private String name;
    private String type;
    @Lob
    private byte[] data;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student submissioner;

    @OneToOne(mappedBy = "file")
    private HomeworkSubmission homeworkSubmission;

    public File(String name, String type, byte[] data, Student submissioner) {
        this.name = name;
        this.type = type;
        this.data = data;
        this.submissioner = submissioner;
    }
}
