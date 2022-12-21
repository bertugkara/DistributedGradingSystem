package com.distributedstudentgradingsystem.Users.Expert.Entity;

import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.Users.User.Entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@DiscriminatorValue("E")
public class Expert extends User implements Serializable {
    @Nullable
    private int age;

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "teacher_id")
    private Teacher referencedTeacherIfExists;
}
