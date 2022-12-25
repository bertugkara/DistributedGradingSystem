package com.distributedstudentgradingsystem.Users.Teacher.Mapper;

import com.distributedstudentgradingsystem.Class.Mapper.ClassMapper;
import com.distributedstudentgradingsystem.Homework.Mapper.HomeworkMapper;
import com.distributedstudentgradingsystem.Homework.Mapper.HomeworkSubmissionMapper;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.PojoTeacherResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.TeacherAddRequestDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.TeacherProfileResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.Teacher;
import com.distributedstudentgradingsystem.Users.Teacher.Entity.TeacherProfile;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        componentModel = "spring",
        uses = {ClassMapper.class, HomeworkMapper.class, HomeworkSubmissionMapper.class})
public abstract class TeacherMapper {

    public abstract Teacher dtoToEntity(TeacherAddRequestDTO teacherAddRequestDTO);

    public abstract PojoTeacherResponseDTO entityToResponseDTO(Teacher teacher);

    public abstract List<PojoTeacherResponseDTO> entityListToResponseDtoList(List<Teacher> teacherList);

    public abstract TeacherProfileResponseDTO profileEntityToResponseDTO(TeacherProfile teacherProfile);
}
