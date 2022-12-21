package com.distributedstudentgradingsystem.Users.User.Service;

import com.distributedstudentgradingsystem.Users.User.Entity.User;
import com.distributedstudentgradingsystem.utilities.Result;

import java.util.List;

public interface UserService<T extends User> {

    Result assignUserActive(Long id);
    Result assignUserInactive(Long id);
    User findById(Long id);

    List<User> findAllActiveUsers();
    List<User> findAllInactiveUsers();

}
