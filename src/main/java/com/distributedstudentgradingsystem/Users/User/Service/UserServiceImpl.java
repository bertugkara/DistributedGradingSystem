package com.distributedstudentgradingsystem.Users.User.Service;


import com.distributedstudentgradingsystem.Users.User.Entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl<T extends User> implements UserService<T>{

}
