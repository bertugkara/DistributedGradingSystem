package com.distributedstudentgradingsystem.Homework.Mapper.GradeSubmission;


import com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission.GradeSubmissionAddRequest;
import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.GradeSubmission;
import com.distributedstudentgradingsystem.Homework.Mapper.HomeworkSubmissionMapper;
import com.distributedstudentgradingsystem.Homework.Service.HomeworkSubmission.HomeworkSubmissionService;
import com.distributedstudentgradingsystem.Users.Student.Mapper.StudentMapper;
import com.distributedstudentgradingsystem.Users.Student.Service.StudentService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {HomeworkSubmissionMapper.class, HomeworkSubmissionService.class,
                StudentMapper.class, StudentService.class})
public abstract class GradeSubmissionMapper {

    @Autowired
    protected StudentService studentService;
    @Autowired
    protected HomeworkSubmissionService homeworkSubmissionService;

    @Mappings({
            @Mapping(target = "graderStudent", expression = "java(studentService.findById(gradeSubmissionAddRequest.getGraderStudentID()))"),
            @Mapping(target = "submission", expression = "java(homeworkSubmissionService.getOneHomeworkSubmission(gradeSubmissionAddRequest.getHomeworkSubmissionID()))"),
            @Mapping(target = "givenPoint", source = "point")
    })
    public abstract GradeSubmission dtoToEntity(GradeSubmissionAddRequest gradeSubmissionAddRequest);
}
