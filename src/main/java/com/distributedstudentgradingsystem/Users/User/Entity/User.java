package com.distributedstudentgradingsystem.Users.User.Entity;

import com.distributedstudentgradingsystem.Role.entity.Role;
import com.distributedstudentgradingsystem.common.BaseEntity.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type")
public abstract class User extends BaseEntity {

    @NotBlank
    private String firstName;

    @Column( unique = true)
    @Email
    @NotBlank
    private String email;

    @Column( unique = true)
    @NotBlank
    private String username;

    @NotBlank
    private String lastName;

    @NotBlank
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roleSet = new HashSet<>();

}
