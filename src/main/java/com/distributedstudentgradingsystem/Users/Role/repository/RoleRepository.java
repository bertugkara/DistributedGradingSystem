package com.distributedstudentgradingsystem.Users.Role.repository;

import com.distributedstudentgradingsystem.Users.Role.entity.Role;
import com.distributedstudentgradingsystem.Users.Role.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(UserRole userRole);
}
