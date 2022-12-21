package com.distributedstudentgradingsystem.Users.Admin.Controller;

import com.distributedstudentgradingsystem.Class.DTO.UserInformationForClassCreatingResponseDTO;
import com.distributedstudentgradingsystem.Class.Mapper.ClassMapper;
import com.distributedstudentgradingsystem.Exception.EmailAlreadyInUseException;
import com.distributedstudentgradingsystem.Exception.UsernameAlreadyIsUsingException;
import com.distributedstudentgradingsystem.Registration.RegistrationService;
import com.distributedstudentgradingsystem.Users.Admin.DTO.AddAdminRequestDTO;
import com.distributedstudentgradingsystem.Users.Admin.Entity.Admin;
import com.distributedstudentgradingsystem.Users.Admin.Mapper.AdminMapper;
import com.distributedstudentgradingsystem.Users.Admin.Service.AdminService;
import com.distributedstudentgradingsystem.utilities.DataResult;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "admin/")
public class AdminController {

    private final RegistrationService<Admin> registrationService;
    private final AdminService adminService;
    private final ClassMapper classMapper;

    @PostMapping(value = "add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Result add(@RequestBody @Valid AddAdminRequestDTO addAdminRequestDTO) throws EmailAlreadyInUseException, UsernameAlreadyIsUsingException {
        return registrationService.register(AdminMapper.INSTANCE.dtoToEntity(addAdminRequestDTO));
    }

    @GetMapping(value = "getAllExpertAndTeacherAndStudent")
    @PreAuthorize("hasAuthority('ADMIN')")
    public DataResult<UserInformationForClassCreatingResponseDTO> getAllExpertAndTeacherAndStudent() {
        UserInformationForClassCreatingResponseDTO userInformationForClassCreatingResponseDTO =
                classMapper.userInformationForClassCreatingResponseEntityToDto
                        (adminService.getUserInformationForCreatingClass());
        return new DataResult<>(userInformationForClassCreatingResponseDTO, true);
    }

}
