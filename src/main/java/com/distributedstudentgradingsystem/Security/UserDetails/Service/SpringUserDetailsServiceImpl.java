package com.distributedstudentgradingsystem.Security.UserDetails.Service;

import com.distributedstudentgradingsystem.Security.UserDetails.Entity.UserDetailsManager;
import com.distributedstudentgradingsystem.Users.Admin.Entity.Admin;
import com.distributedstudentgradingsystem.Users.User.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpringUserDetailsServiceImpl implements SpringUserDetailsService {

    private final UserRepository<Admin> adminRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin byUsername = adminRepository.findByUsername(username);
        if (byUsername == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return UserDetailsManager.build( byUsername);
    }
}
