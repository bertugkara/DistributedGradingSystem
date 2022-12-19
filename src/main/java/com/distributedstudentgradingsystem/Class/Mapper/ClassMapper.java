package com.distributedstudentgradingsystem.Class.Mapper;

import com.distributedstudentgradingsystem.Class.DTO.ClassAddRequestDTO;
import com.distributedstudentgradingsystem.Class.DTO.ClassResponseDTO;
import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.Users.Admin.Mapper.AdminMapper;
import com.distributedstudentgradingsystem.Users.Admin.Service.AdminService;
import com.distributedstudentgradingsystem.Users.Expert.Mapper.ExpertMapper;
import com.distributedstudentgradingsystem.Users.Expert.Service.ExpertService;
import com.distributedstudentgradingsystem.Users.Student.Mapper.StudentMapper;
import com.distributedstudentgradingsystem.Users.Student.Service.StudentService;
import com.distributedstudentgradingsystem.Users.Teacher.Mapper.TeacherMapper;
import com.distributedstudentgradingsystem.Users.Teacher.Service.TeacherService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {AdminService.class, TeacherService.class, StudentService.class, ExpertService.class,
                AdminMapper.class, TeacherMapper.class, StudentMapper.class, ExpertMapper.class})
public abstract class ClassMapper {

    @Autowired
    protected TeacherService teacherService;
    @Autowired
    protected ExpertService expertService;
    @Autowired
    protected StudentService studentService;

    @Mappings({
            @Mapping(target = "instructor", expression = "java(teacherService.findById(classAddRequestDTO.getInstructor()))"),
            @Mapping(target = "expertList", expression = "java(expertService.findByIdList(classAddRequestDTO.getExpertList()))"),
            @Mapping(target = "studentList", expression = "java(studentService.findByIdList(classAddRequestDTO.getStudentList()))")
    })
    public abstract Class dtoToEntity(ClassAddRequestDTO classAddRequestDTO);

    public abstract ClassResponseDTO entityToDTO(Class obj);

    public abstract List<ClassResponseDTO> entityListToDtoList(List<Class> classList);

}
