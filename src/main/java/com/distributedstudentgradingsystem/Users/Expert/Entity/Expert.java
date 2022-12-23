package com.distributedstudentgradingsystem.Users.Expert.Entity;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
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
@DiscriminatorValue("E")
public class Expert extends User implements Serializable {

    @OneToOne(fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "teacher_id")
    private Teacher referencedTeacherIfExists;

    @ManyToMany(mappedBy = "expertList")
    private List<Class> classList = new ArrayList<>();


}
