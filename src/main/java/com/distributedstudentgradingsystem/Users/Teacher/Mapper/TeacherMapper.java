package com.distributedstudentgradingsystem.Users.Teacher.Mapper;

import com.distributedstudentgradingsystem.Class.Mapper.ClassMapper;
import com.distributedstudentgradingsystem.Homework.Mapper.HomeworkMapper;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.PojoTeacherResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.TeacherAddRequestDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.TeacherProfileResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.TeacherProfile;
import com.distributedstudentgradingsystem.Users.Teacher.Service.TeacherService;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        componentModel = "spring",
        uses = {TeacherService.class, ClassMapper.class, HomeworkMapper.class})
public interface TeacherMapper {

    TeacherMapper INSTANCE = Mappers.getMapper(TeacherMapper.class);

    Teacher dtoToEntity(TeacherAddRequestDTO teacherAddRequestDTO);

    PojoTeacherResponseDTO entityToResponseDTO(Teacher teacher);

    List<PojoTeacherResponseDTO> entityListToResponseDtoList(List<Teacher> teacherList);

    TeacherProfileResponseDTO profileEntityToResponseDTO(TeacherProfile teacherProfile);
}
