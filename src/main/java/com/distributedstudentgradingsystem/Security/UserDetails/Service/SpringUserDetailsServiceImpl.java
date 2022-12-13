package com.distributedstudentgradingsystem.Security.UserDetails.Service;

import com.distributedstudentgradingsystem.Security.UserDetails.Entity.UserDetailsManager;
import com.distributedstudentgradingsystem.Users.User.Entity.User;
import com.distributedstudentgradingsystem.Users.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpringUserDetailsServiceImpl implements SpringUserDetailsService {

    private final UserRepository<User> userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User byUsername = userRepository.findByUsername(username);
        if (byUsername == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return UserDetailsManager.build( byUsername);
    }
}
