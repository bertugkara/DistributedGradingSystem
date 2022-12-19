package com.distributedstudentgradingsystem.Users.Teacher.Controller;

import com.distributedstudentgradingsystem.Exception.EmailAlreadyInUseException;
import com.distributedstudentgradingsystem.Exception.UsernameAlreadyIsUsingException;
import com.distributedstudentgradingsystem.Registration.RegistrationService;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.TeacherAddRequestDTO;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.Users.Teacher.Mapper.TeacherMapper;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "teacher/")
public class TeacherController {

    private final RegistrationService<Teacher> registrationService;

    @PostMapping(value = "add")
    public Result add(@RequestBody @Valid TeacherAddRequestDTO teacherAddRequestDTO) throws EmailAlreadyInUseException, UsernameAlreadyIsUsingException {
        return registrationService.register(TeacherMapper.INSTANCE.dtoToEntity(teacherAddRequestDTO));
    }
    
}
