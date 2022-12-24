package com.distributedstudentgradingsystem.Homework.Mapper;


import com.distributedstudentgradingsystem.Class.Mapper.ClassMapper;
import com.distributedstudentgradingsystem.Class.Service.ClassService;
import com.distributedstudentgradingsystem.Homework.DTO.Homework.HomeworkAddRequestDTO;
import com.distributedstudentgradingsystem.Homework.DTO.Homework.HomeworkResponseDTO;
import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import com.distributedstudentgradingsystem.Users.Expert.Mapper.ExpertMapper;
import com.distributedstudentgradingsystem.Users.Expert.Service.ExpertService;
import com.distributedstudentgradingsystem.Users.Student.Mapper.StudentMapper;
import com.distributedstudentgradingsystem.Users.Teacher.Mapper.TeacherMapper;
import com.distributedstudentgradingsystem.Users.Teacher.Service.TeacherService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {TeacherMapper.class, ClassMapper.class, ExpertMapper.class,
                StudentMapper.class, TeacherService.class, ClassService.class})
public abstract class HomeworkMapper {

    @Autowired
    protected TeacherService teacherService;
    @Autowired
    protected ClassService classService;
    @Autowired
    protected ExpertService expertService;

    @Mapping(target = "classDTO", source = "lesson")
    @Mapping(target = "id", source = "id")
    public abstract HomeworkResponseDTO entityToDTO(Homework homework);

    @Mapping(target = "lesson", expression = "java(classService.getOne(homeworkAddRequestDTO.getClassID()))")
    @Mapping(target = "creator", expression = "java(teacherService.findById(homeworkAddRequestDTO.getCreatorID()))")
    @Mapping(target = "expert", expression = "java(expertService.findById(homeworkAddRequestDTO.getExpertID()))")
    public abstract Homework dtoToEntity(HomeworkAddRequestDTO homeworkAddRequestDTO);

    public abstract List<HomeworkResponseDTO> entityListToDtoList(List<Homework> homework);

}
