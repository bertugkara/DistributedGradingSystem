package com.distributedstudentgradingsystem.Registration;

import com.distributedstudentgradingsystem.Exception.EmailAlreadyInUseException;
import com.distributedstudentgradingsystem.Exception.UsernameAlreadyIsUsingException;
import com.distributedstudentgradingsystem.Exception.enums.RegistrationError;
import com.distributedstudentgradingsystem.Users.Admin.Entity.Admin;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Expert.Repository.ExpertRepository;
import com.distributedstudentgradingsystem.Users.Role.entity.Role;
import com.distributedstudentgradingsystem.Users.Role.entity.UserRole;
import com.distributedstudentgradingsystem.Users.Role.repository.RoleRepository;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.Users.User.Entity.User;
import com.distributedstudentgradingsystem.Users.User.Repository.UserRepository;
import com.distributedstudentgradingsystem.common.passwordEncoder.PasswordEncoder;
import com.distributedstudentgradingsystem.utilities.Result;
import com.distributedstudentgradingsystem.utilities.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class RegistrationServiceImpl<T extends User> implements RegistrationService<T> {

    private final UserRepository<T> userRepository;
    private final ExpertRepository expertRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public Result register(T entity) throws UsernameAlreadyIsUsingException, EmailAlreadyInUseException {
        if (userRepository.findByEmail(entity.getEmail()) != null) {
            throw new EmailAlreadyInUseException(RegistrationError.EMAIL_IN_USE);
        }
        if (userRepository.findByUsername(entity.getUsername()) != null) {
            throw new UsernameAlreadyIsUsingException(RegistrationError.USERNAME_IN_USE);
        }

        String encryptedPassword = passwordEncoder.bcryptPasswordEncoder().encode(entity.getPassword());
        entity.setPassword(encryptedPassword);

        Set<Role> roles = fetchAndReturnRole(entity);
        entity.setRoleSet(roles);

        userRepository.save(entity);

        return new SuccessResult();
    }


    private Set<Role> fetchAndReturnRole(T entity) {

        List<UserRole> userRoleList = new ArrayList<>();

        if (entity instanceof Admin) {
            userRoleList.add(UserRole.ADMIN);
        } else if (entity instanceof Student) {
            userRoleList.add(UserRole.STUDENT);
        } else if (entity instanceof Expert) {
            userRoleList.add(UserRole.EXPERT);
        } else if (entity instanceof Teacher) {
            userRoleList.add(UserRole.TEACHER);
            userRoleList.add(UserRole.EXPERT);
        }

        List<Role> byName = roleRepository.findRolesByNameIn(userRoleList);
        Set<Role> roleSet = new java.util.HashSet<>();
        if (byName != null) {
            roleSet.addAll(byName);
        }
        return roleSet;

    }
}
