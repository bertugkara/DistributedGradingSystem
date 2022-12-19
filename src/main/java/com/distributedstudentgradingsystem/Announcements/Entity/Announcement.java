package com.distributedstudentgradingsystem.Announcements.Entity;

import com.distributedstudentgradingsystem.Users.Admin.Entity.Admin;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.common.BaseEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Announcement extends BaseEntity {
    @NotBlank
    private String announcement;

    @ManyToOne
    @JoinColumn(name = "admin_id")
    private Admin admin;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher instructor;
}
