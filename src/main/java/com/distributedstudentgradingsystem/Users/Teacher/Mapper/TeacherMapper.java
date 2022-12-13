package com.distributedstudentgradingsystem.Users.Teacher.Mapper;

import com.distributedstudentgradingsystem.Users.Teacher.DTO.AddTeacherRequestDTO;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher dtoToEntity(AddTeacherRequestDTO addTeacherRequestDTO);
}
