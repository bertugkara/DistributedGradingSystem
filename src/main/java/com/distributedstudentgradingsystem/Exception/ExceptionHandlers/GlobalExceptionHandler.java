package com.distributedstudentgradingsystem.Exception.ExceptionHandlers;


import com.distributedstudentgradingsystem.Exception.EmailAlreadyInUseException;
import com.distributedstudentgradingsystem.Exception.UsernameAlreadyIsUsingException;
import com.distributedstudentgradingsystem.utilities.ErrorResult;
import com.distributedstudentgradingsystem.utilities.Result;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {UsernameNotFoundException.class})
    public Result handleMethodArgumentException(UsernameNotFoundException exception) {
        return new ErrorResult(exception.getCause().getMessage());
    }

    @ExceptionHandler(value = {EntityNotFoundException.class})
    public Result handleMethodArgumentException(EntityNotFoundException exception) {
        return new ErrorResult(exception.getCause().getMessage());
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public Result handleMethodArgumentException(RuntimeException exception) {
        return new ErrorResult(exception.getMessage());
    }

    @ExceptionHandler(value = {IOException.class})
    public Result handleMethodArgumentException(IOException exception) {
        return new ErrorResult(exception.getCause().getMessage());
    }

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public Result handleMaxSizeException(MaxUploadSizeExceededException exception) {
        return new ErrorResult("File is too Large!");
    }

    @ExceptionHandler(UsernameAlreadyIsUsingException.class)
    public Result usernameIsAlreadyUsing(UsernameAlreadyIsUsingException exception){
        return new ErrorResult(exception.getMessage());
    }
    @ExceptionHandler(EmailAlreadyInUseException.class)
    public Result usernameIsAlreadyUsing(EmailAlreadyInUseException exception){
        return new ErrorResult(exception.getMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Result illegalArgumentException(IllegalArgumentException exception){
        return new ErrorResult(exception.getMessage());
    }
}
