package com.distributedstudentgradingsystem.Role.repository;

import com.distributedstudentgradingsystem.Role.entity.Role;
import com.distributedstudentgradingsystem.Role.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    Role findByName(UserRole userRole);
}
