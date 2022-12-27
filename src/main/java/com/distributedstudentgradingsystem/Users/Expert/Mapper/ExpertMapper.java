package com.distributedstudentgradingsystem.Users.Expert.Mapper;

import com.distributedstudentgradingsystem.Class.Mapper.ClassMapper;
import com.distributedstudentgradingsystem.Homework.Mapper.HomeworkMapper;
import com.distributedstudentgradingsystem.Homework.Mapper.HomeworkSubmissionMapper;
import com.distributedstudentgradingsystem.Users.Expert.DTO.ExpertAddRequestDTO;
import com.distributedstudentgradingsystem.Users.Expert.DTO.ExpertProfileResponseDTO;
import com.distributedstudentgradingsystem.Users.Expert.DTO.PojoExpertResponseDTO;
import com.distributedstudentgradingsystem.Users.Expert.Entity.Expert;
import com.distributedstudentgradingsystem.Users.Expert.Entity.ExpertProfile;
import com.distributedstudentgradingsystem.Users.Teacher.Service.TeacherService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        componentModel = "spring" , uses = {ClassMapper.class, HomeworkMapper.class, HomeworkSubmissionMapper.class})
public abstract class ExpertMapper {

    @Autowired
    protected TeacherService teacherService;

    public abstract PojoExpertResponseDTO entityToDTO(Expert expert);

    public abstract List<PojoExpertResponseDTO> entityListToDtoList(List<Expert> expertList);

    @Mapping(target = "referencedTeacherIfExists",
            expression = "java(teacherService.findById(expertAddRequestDTO.getReferencedTeacherID()))")
    public abstract Expert dtoToEntity(ExpertAddRequestDTO expertAddRequestDTO);

    public abstract ExpertProfileResponseDTO profileEntityToResponseDTO(ExpertProfile expertProfile);
}
