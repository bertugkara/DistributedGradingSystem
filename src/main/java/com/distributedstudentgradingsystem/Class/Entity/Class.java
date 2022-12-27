package com.distributedstudentgradingsystem.Class.Entity;

import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.common.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString
@Table(name = "class")
@NoArgsConstructor
public class Class extends BaseEntity {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotBlank
    private String lessonCode;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "teacher_id")
    private Teacher instructor;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "class_and_experts",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "expert_id"))
    private Set<Expert> expertList = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "class_and_students",
            joinColumns = @JoinColumn(name = "class_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> studentList = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "lesson")
    private Set<Homework> homeworkSet = new HashSet<>();

    public void addExpert(Expert expert) {
        this.expertList.add(expert);
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public void addStudentAsList(List<Student> studentList) {
        this.studentList.addAll(studentList);
    }

    public void updateClass(Class updatedClass){
        this.name = updatedClass.getName();
        this.description = updatedClass.getDescription();
        this.lessonCode = updatedClass.getLessonCode();
        this.expertList=updatedClass.getExpertList();
        this.studentList = updatedClass.getStudentList();
        this.instructor = updatedClass.getInstructor();
    }
}
