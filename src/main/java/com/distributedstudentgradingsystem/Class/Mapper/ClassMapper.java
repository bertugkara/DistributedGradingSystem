package com.distributedstudentgradingsystem.Class.Mapper;

import com.distributedstudentgradingsystem.Class.DTO.*;
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

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
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

    @Mapping(target = "expertList" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    @Mapping(target = "studentList" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    @Mapping(target = "instructor" , nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
    public abstract ClassResponseDTO entityToDTO(Class obj);

    public abstract List<ClassResponseDTO> entityListToDtoList(List<Class> classList);

    public abstract UserInformationForClassCreatingResponseDTO userInformationForClassCreatingResponseEntityToDto
            (UserInformationForClassCreatingResponse userInformationForClassCreatingResponse);

    public abstract PojoClassResponseDTO entityToPojoDTO(Class obj);

    @Mappings({
            @Mapping(target = "instructor", expression = "java(teacherService.findById(classUpdateRequest.getInstructor()))"),
            @Mapping(target = "expertList", expression = "java(expertService.findByIdList(classUpdateRequest.getExpertList()))"),
            @Mapping(target = "studentList", expression = "java(studentService.findByIdList(classUpdateRequest.getStudentList()))")
    })
    public abstract Class updateDtoToEntity(ClassUpdateRequest classUpdateRequest);
}
