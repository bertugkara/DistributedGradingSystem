package com.distributedstudentgradingsystem.Users.Student.Controller;

import com.distributedstudentgradingsystem.Exception.EmailAlreadyInUseException;
import com.distributedstudentgradingsystem.Exception.UsernameAlreadyIsUsingException;
import com.distributedstudentgradingsystem.Registration.RegistrationService;
import com.distributedstudentgradingsystem.Users.Student.DTO.AddStudentRequestDTO;
import com.distributedstudentgradingsystem.Users.Student.DTO.PojoStudentResponseDTO;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Student.Mapper.StudentMapper;
import com.distributedstudentgradingsystem.Users.Student.Service.StudentService;
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
@RequestMapping(path = "student/")
public class StudentController {

    private final RegistrationService<Student> registrationService;
    private final StudentService studentService;

    @PostMapping(value = "add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Result add(@RequestBody @Valid AddStudentRequestDTO addStudentRequestDTO) throws EmailAlreadyInUseException, UsernameAlreadyIsUsingException {
        return registrationService.register(StudentMapper.INSTANCE.dtoToEntity(addStudentRequestDTO));
    }

    @GetMapping(value = "getAll")
    @PreAuthorize("hasAuthority('ADMIN')")
    public DataResult<List<PojoStudentResponseDTO>> getAllStudents() {
        List<PojoStudentResponseDTO> pojoStudentResponseDTOList =
               StudentMapper.INSTANCE.entityListToDtoList(studentService.findAllStudents());
        return new DataResult<>( pojoStudentResponseDTOList , !pojoStudentResponseDTOList.isEmpty());
    }
}
