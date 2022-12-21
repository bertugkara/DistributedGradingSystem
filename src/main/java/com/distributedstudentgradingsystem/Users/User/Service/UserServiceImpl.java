package com.distributedstudentgradingsystem.Users.User.Service;


import com.distributedstudentgradingsystem.Users.User.Entity.User;
import com.distributedstudentgradingsystem.Users.User.Repository.UserRepository;
import com.distributedstudentgradingsystem.utilities.Result;
import com.distributedstudentgradingsystem.utilities.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl<T extends User> implements UserService<T>{

    private final UserRepository<User> userRepository;

    @Override
    public Result assignUserActive(Long id) {
        User user = findById(id);
        user.setIsEnabled(true);
        userRepository.save(user);
        return new SuccessResult();
    }

    @Override
    public Result assignUserInactive(Long id) {
        User user = findById(id);
        user.setIsEnabled(false);
        userRepository.save(user);
        return new SuccessResult();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> findAllActiveUsers() {
        return userRepository.findAllByIsEnabledTrue();
    }

    @Override
    public List<User> findAllInactiveUsers() {
        return userRepository.findAllByIsEnabledFalse();
    }
}
