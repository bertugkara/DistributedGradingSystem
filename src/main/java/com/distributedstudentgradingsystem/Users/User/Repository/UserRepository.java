package com.distributedstudentgradingsystem.Users.User.Repository;

import com.distributedstudentgradingsystem.Users.User.Entity.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Primary
public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    T findByEmail(String email);

    T findByUsername(String username);

    List<User> findAllByIsEnabledTrue();
    List<User> findAllByIsEnabledFalse();
}
