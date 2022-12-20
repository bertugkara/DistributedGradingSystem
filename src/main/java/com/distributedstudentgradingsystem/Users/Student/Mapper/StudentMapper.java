package com.distributedstudentgradingsystem.Users.Student.Mapper;

import com.distributedstudentgradingsystem.Users.Student.DTO.AddStudentRequestDTO;
import com.distributedstudentgradingsystem.Users.Student.DTO.PojoStudentResponseDTO;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        componentModel = "spring")
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student dtoToEntity(AddStudentRequestDTO addStudentRequestDTO);

    PojoStudentResponseDTO entityToDTO(Student student);

    List<PojoStudentResponseDTO> entityListToDtoList(List<Student> students);
}
