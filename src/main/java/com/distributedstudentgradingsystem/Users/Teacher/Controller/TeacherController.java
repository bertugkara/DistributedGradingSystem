package com.distributedstudentgradingsystem.Users.Teacher.Controller;

import com.distributedstudentgradingsystem.Exception.EmailAlreadyInUseException;
import com.distributedstudentgradingsystem.Exception.UsernameAlreadyIsUsingException;
import com.distributedstudentgradingsystem.Registration.RegistrationService;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.PojoTeacherResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.TeacherAddRequestDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.TeacherProfileResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.Users.Teacher.Mapper.TeacherMapper;
import com.distributedstudentgradingsystem.Users.Teacher.Service.TeacherService;
import com.distributedstudentgradingsystem.utilities.DataResult;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "teacher/")
public class TeacherController {

    private final RegistrationService<Teacher> registrationService;
    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @PostMapping(value = "add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Result add(@RequestBody @Valid TeacherAddRequestDTO teacherAddRequestDTO) throws EmailAlreadyInUseException, UsernameAlreadyIsUsingException {
        return registrationService.register(teacherMapper.dtoToEntity(teacherAddRequestDTO));
    }

    @GetMapping(value = "getAll")
    @PreAuthorize("hasAuthority('ADMIN')")
    public DataResult<List<PojoTeacherResponseDTO>> getAllTeachers() {
        List<PojoTeacherResponseDTO> pojoTeacherResponseDTOList = teacherMapper.
                entityListToResponseDtoList(teacherService.findAllTeachersAndConvertToResponseDTO());
        return new DataResult<>(pojoTeacherResponseDTOList, !pojoTeacherResponseDTOList.isEmpty());
    }

    @GetMapping(value = "whoAmI")
    @PreAuthorize("hasAuthority('TEACHER')")
    public DataResult<TeacherProfileResponseDTO> whoAmI(@RequestParam Long id) {
        TeacherProfileResponseDTO teacherProfileResponseDTO =
                teacherMapper.profileEntityToResponseDTO(teacherService.whoAmI(id));
        return new DataResult<>(teacherProfileResponseDTO, teacherProfileResponseDTO != null);
    }

}
