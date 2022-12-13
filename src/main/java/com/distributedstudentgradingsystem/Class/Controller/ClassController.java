package com.distributedstudentgradingsystem.Class.Controller;

import com.distributedstudentgradingsystem.Class.DTO.AddPojoClassRequest;
import com.distributedstudentgradingsystem.Class.Mapper.ClassMapper;
import com.distributedstudentgradingsystem.Class.Service.ClassService;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "class/")
public class ClassController {

    private final ClassService classService;

    @PostMapping(value = "add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Result add(@RequestBody @Valid AddPojoClassRequest addPojoClassRequest) {
        return classService.addPojoClass(ClassMapper.INSTANCE.addDtoToEntity(addPojoClassRequest));
    }
}
