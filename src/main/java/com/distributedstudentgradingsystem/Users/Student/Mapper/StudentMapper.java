package com.distributedstudentgradingsystem.Users.Student.Mapper;

import com.distributedstudentgradingsystem.Class.Mapper.ClassMapper;
import com.distributedstudentgradingsystem.Class.Service.ClassService;
import com.distributedstudentgradingsystem.Homework.Mapper.HomeworkMapper;
import com.distributedstudentgradingsystem.Homework.Mapper.HomeworkSubmissionMapper;
import com.distributedstudentgradingsystem.Users.Student.DTO.AddStudentRequestDTO;
import com.distributedstudentgradingsystem.Users.Student.DTO.PojoStudentResponseDTO;
import com.distributedstudentgradingsystem.Users.Student.DTO.StudentProfileResponseDTO;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Student.Entity.StudentProfile;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT, unmappedTargetPolicy = ReportingPolicy.WARN,
        componentModel = "spring", uses = {ClassService.class, ClassMapper.class, HomeworkMapper.class, HomeworkSubmissionMapper.class})
public abstract class StudentMapper {


    public abstract Student dtoToEntity(AddStudentRequestDTO addStudentRequestDTO);

    public abstract PojoStudentResponseDTO entityToDTO(Student student);

    public abstract List<PojoStudentResponseDTO> entityListToDtoList(List<Student> students);

    public abstract StudentProfileResponseDTO profileEntityToProfileDto(StudentProfile studentProfile);
}
