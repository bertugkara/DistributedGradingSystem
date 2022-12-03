package com.distributedstudentgradingsystem.Exception.enums;

public enum RegistrationError {

    USERNAME_IN_USE("Username Is Already Using"),
    EMAIL_IN_USE( "Email is Already Using");

    RegistrationError(String name) {
    }

}
