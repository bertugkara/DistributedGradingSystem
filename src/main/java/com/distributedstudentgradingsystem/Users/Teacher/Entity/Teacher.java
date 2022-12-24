package com.distributedstudentgradingsystem.Users.Teacher.Entity;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import com.distributedstudentgradingsystem.Users.User.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Setter
@AllArgsConstructor
@Getter
@Entity
@DiscriminatorValue("T")
public class Teacher extends User implements Serializable {

    private boolean isExpert = true;

    @OneToMany(mappedBy = "instructor")
    private List<Class> classList = new ArrayList<>();

    @OneToMany(mappedBy = "creator")
    private List<Homework> createdHomework=new ArrayList<>();
}
