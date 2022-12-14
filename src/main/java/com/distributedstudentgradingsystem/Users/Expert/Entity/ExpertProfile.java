package com.distributedstudentgradingsystem.Users.Expert.Entity;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ExpertProfile {

    private String firstName;
    private String email;
    private String lastName;
    private List<Class> classList;
    private List<Homework> responsibleHomeworkList;

    public static ExpertProfile fromExpert(Expert expert,
                                             List<Class> classList,
                                             List<Homework> homeworkList
                                             ){
        ExpertProfile expertProfile = new ExpertProfile();
        expertProfile.setEmail(expert.getEmail());
        expertProfile.setFirstName(expert.getFirstName());
        expertProfile.setLastName(expert.getLastName());
        expertProfile.setClassList(classList);
        expertProfile.setResponsibleHomeworkList(homeworkList);
        return expertProfile;
    }
}
