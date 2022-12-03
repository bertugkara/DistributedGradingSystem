package com.distributedstudentgradingsystem.Users.Admin.Controller;

import com.distributedstudentgradingsystem.Exception.EmailAlreadyInUseException;
import com.distributedstudentgradingsystem.Exception.UsernameAlreadyIsUsingException;
import com.distributedstudentgradingsystem.Users.Admin.Controller.DTO.AddAdminRequestDTO;
import com.distributedstudentgradingsystem.Users.Admin.Entity.Admin;
import com.distributedstudentgradingsystem.Users.Admin.Mapper.AdminMapper;
import com.distributedstudentgradingsystem.Users.Registration.RegistrationService;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "admin/")
public class AdminController {

    private final RegistrationService<Admin> registrationService;

    @PostMapping(value = "add")
    public Result add(@RequestBody @Valid AddAdminRequestDTO addAdminRequestDTO) throws EmailAlreadyInUseException, UsernameAlreadyIsUsingException {
        return registrationService.register(AdminMapper.INSTANCE.dtoToEntity(addAdminRequestDTO));
    }

}
