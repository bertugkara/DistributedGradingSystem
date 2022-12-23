package com.distributedstudentgradingsystem.Class.Controller;

import com.distributedstudentgradingsystem.Class.DTO.ClassAddRequestDTO;
import com.distributedstudentgradingsystem.Class.DTO.ClassResponseDTO;
import com.distributedstudentgradingsystem.Class.Mapper.ClassMapper;
import com.distributedstudentgradingsystem.Class.Service.ClassService;
import com.distributedstudentgradingsystem.utilities.DataResult;
import com.distributedstudentgradingsystem.utilities.Result;
import com.distributedstudentgradingsystem.utilities.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "class/")
public class ClassController {

    private final ClassService classService;
    private final ClassMapper classMapper;

    @PostMapping(value = "add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Result add(@RequestBody @Valid ClassAddRequestDTO classAddRequestDTO) {
        return classService.addClass(classMapper.dtoToEntity(classAddRequestDTO));
    }

    @GetMapping(value = "getAll")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER','EXPERT')")
    public DataResult<List<ClassResponseDTO>> getAllClasses(){
        return new SuccessDataResult<>(classMapper.entityListToDtoList(classService.getAllClasses())) ;
    }

    @GetMapping(value = "getOne/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER','STUDENT','EXPERT')")
    public DataResult<ClassResponseDTO> getOne(@PathVariable(name = "id") Long id){
        return new SuccessDataResult<>(classMapper.entityToDTO(classService.getOne(id))) ;
    }
}
