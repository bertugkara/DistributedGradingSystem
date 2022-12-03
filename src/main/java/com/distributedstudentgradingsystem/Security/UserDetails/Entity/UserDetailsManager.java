package com.distributedstudentgradingsystem.Security.UserDetails.Entity;

import com.distributedstudentgradingsystem.Users.User.Entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailsManager implements UserDetails {

    private Long id;
    private String email;
    private String password;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public static UserDetailsManager build(User user) {

        List<GrantedAuthority> authorities = user.getRoleSet().stream()
                .map( role ->
                        new SimpleGrantedAuthority(role.getName().name()) )
                .collect(Collectors.toList());


        return new UserDetailsManager(
                user.getId(),
                user.getEmail(),
                user.getPassword(), user.getUsername(),
                authorities);
    }

    public String getEmail(){
        return email;
    }

    public Long getId(){
        return id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
