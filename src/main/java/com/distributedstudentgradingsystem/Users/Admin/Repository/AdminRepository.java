package com.distributedstudentgradingsystem.Users.Admin.Repository;

import com.distributedstudentgradingsystem.Users.Admin.Entity.Admin;
import com.distributedstudentgradingsystem.Users.User.Repository.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends UserRepository<Admin> {

}
