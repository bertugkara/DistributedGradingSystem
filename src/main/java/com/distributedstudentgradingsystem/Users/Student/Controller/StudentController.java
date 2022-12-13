package com.distributedstudentgradingsystem.Users.Student.Controller;

import com.distributedstudentgradingsystem.Exception.EmailAlreadyInUseException;
import com.distributedstudentgradingsystem.Exception.UsernameAlreadyIsUsingException;
import com.distributedstudentgradingsystem.Registration.RegistrationService;
import com.distributedstudentgradingsystem.Users.Student.DTO.AddStudentRequestDTO;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Student.Mapper.StudentMapper;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "student/")
public class StudentController {

    private final RegistrationService<Student> registrationService;

    @PostMapping(value = "add")
    public Result add(@RequestBody @Valid AddStudentRequestDTO addStudentRequestDTO) throws EmailAlreadyInUseException, UsernameAlreadyIsUsingException {
        return registrationService.register(StudentMapper.INSTANCE.dtoToEntity(addStudentRequestDTO));
    }

}
