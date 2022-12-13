package com.distributedstudentgradingsystem.Class.Entity;

import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.common.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "class")
@NoArgsConstructor
public class Class extends BaseEntity {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String lessonCode;

    @ManyToOne
    @JoinColumn(name = "teacher")
    private Teacher instructor;

    @ManyToMany
    @JoinTable(name = "class_and_experts",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "expert_id"))
    private List<Expert> expertList = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "class_and_students",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> studentList = new ArrayList<>();

    public void addExpert(Expert expert) {
        this.expertList.add(expert);
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public void addStudentAsList(List<Student> studentList) {
        this.studentList.addAll(studentList);
    }

}
