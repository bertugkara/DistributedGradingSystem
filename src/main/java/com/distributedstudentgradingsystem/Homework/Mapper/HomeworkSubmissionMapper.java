package com.distributedstudentgradingsystem.Homework.Mapper;

import com.distributedstudentgradingsystem.FileSubmissions.Mapper.FileMapper;
import com.distributedstudentgradingsystem.FileSubmissions.Service.FileService;
import com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission.HomeworkSubmissionAddRequest;
import com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission.HomeworkSubmissionResponseDTO;
import com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission.PojoHomeworkSubmissionResponseDTO;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import com.distributedstudentgradingsystem.Homework.Mapper.GradeSubmission.GradeSubmissionMapper;
import com.distributedstudentgradingsystem.Homework.Service.Homework.HomeworkService;
import com.distributedstudentgradingsystem.Users.Student.Mapper.StudentMapper;
import com.distributedstudentgradingsystem.Users.Student.Service.StudentService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {HomeworkMapper.class, HomeworkService.class, StudentService.class,
                StudentMapper.class, FileService.class, FileMapper.class , GradeSubmissionMapper.class})
public abstract class HomeworkSubmissionMapper {

    @Autowired
    protected StudentService studentService;
    @Autowired
    protected HomeworkService homeworkService;

    @Mapping(target = "owner", expression = "java(studentService.findById(homeworkSubmissionAddRequest.getCreatorID()))")
    @Mapping(target = "homework", expression = "java(homeworkService.getOneHomework(homeworkSubmissionAddRequest.getHomeworkID()))")
    public abstract HomeworkSubmission dtoToEntity(HomeworkSubmissionAddRequest homeworkSubmissionAddRequest);

    @Mapping(target = "fileDTO", source = "file")
    public abstract HomeworkSubmissionResponseDTO entityToDTO(HomeworkSubmission homeworkSubmission);

    public abstract List<HomeworkSubmissionResponseDTO> entityListToDTOList(List<HomeworkSubmission> homeworkSubmission);

    public abstract PojoHomeworkSubmissionResponseDTO entityToPojoDTO(HomeworkSubmission homeworkSubmission);
}
