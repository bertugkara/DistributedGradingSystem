package com.distributedstudentgradingsystem.Users.Teacher.Entity;

import com.distributedstudentgradingsystem.Users.User.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

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

    @Nullable
    private int age;


    private boolean isExpert = true;
}
