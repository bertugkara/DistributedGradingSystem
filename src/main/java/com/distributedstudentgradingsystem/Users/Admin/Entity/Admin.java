package com.distributedstudentgradingsystem.Users.Admin.Entity;

import com.distributedstudentgradingsystem.Users.User.Entity.User;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
@Entity
@DiscriminatorValue("A")
public class Admin extends User implements Serializable {
    @Nullable
    private int age;

}
