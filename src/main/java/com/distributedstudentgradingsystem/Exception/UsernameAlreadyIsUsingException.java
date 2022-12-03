package com.distributedstudentgradingsystem.Exception;

import com.distributedstudentgradingsystem.Exception.enums.RegistrationError;

public class UsernameAlreadyIsUsingException extends Exception {
    public UsernameAlreadyIsUsingException(RegistrationError registrationError){
        super(String.valueOf(registrationError));
    }
}
