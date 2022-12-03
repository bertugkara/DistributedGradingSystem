package com.distributedstudentgradingsystem.Users.Registration;

import com.distributedstudentgradingsystem.Exception.EmailAlreadyInUseException;
import com.distributedstudentgradingsystem.Exception.UsernameAlreadyIsUsingException;
import com.distributedstudentgradingsystem.Users.User.Entity.User;
import com.distributedstudentgradingsystem.utilities.Result;
import org.springframework.stereotype.Component;

@Component
public interface RegistrationService<T extends User> {

    Result register(T dto) throws UsernameAlreadyIsUsingException, EmailAlreadyInUseException;

}
