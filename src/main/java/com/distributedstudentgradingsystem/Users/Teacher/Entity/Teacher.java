package com.distributedstudentgradingsystem.Users.Teacher.Entity;

import com.distributedstudentgradingsystem.Users.User.Entity.User;
import lombok.*;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.io.Serializable;


@NoArgsConstructor
@Setter
@AllArgsConstructor
@Getter
@Entity
@DiscriminatorValue("T")
public class Teacher extends User implements Serializable {

    private int age;

}
