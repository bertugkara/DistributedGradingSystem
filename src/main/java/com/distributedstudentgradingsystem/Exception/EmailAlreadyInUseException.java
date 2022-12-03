package com.distributedstudentgradingsystem.Exception;

import com.distributedstudentgradingsystem.Exception.enums.RegistrationError;

public class EmailAlreadyInUseException extends Exception{

    public EmailAlreadyInUseException(RegistrationError error){
        super(String.valueOf(error));
    }
}
