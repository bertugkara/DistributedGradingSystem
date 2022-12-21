package com.distributedstudentgradingsystem.Users.Student.Entity;

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
@Getter
@AllArgsConstructor
@Entity
@DiscriminatorValue("S")
public class Student extends User implements Serializable {

    @Nullable
    private int age;

}
