package com.distributedstudentgradingsystem.Homework.Mapper.GradeSubmission;


import com.distributedstudentgradingsystem.Homework.DTO.GradeSubmission.GradeSubmissionResponseDTO;
import com.distributedstudentgradingsystem.Homework.DTO.GradeSubmission.GradeSubmissionAddRequest;
import com.distributedstudentgradingsystem.Homework.DTO.GradeSubmission.GradeSubmissionUpdateRequest;
import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.GradeSubmission;
import com.distributedstudentgradingsystem.Homework.Mapper.HomeworkSubmissionMapper;
import com.distributedstudentgradingsystem.Homework.Service.HomeworkSubmission.HomeworkSubmissionService;
import com.distributedstudentgradingsystem.Users.Expert.Mapper.ExpertMapper;
import com.distributedstudentgradingsystem.Users.Expert.Service.ExpertService;
import com.distributedstudentgradingsystem.Users.Student.Mapper.StudentMapper;
import com.distributedstudentgradingsystem.Users.Student.Service.StudentService;
import com.distributedstudentgradingsystem.Users.Teacher.Mapper.TeacherMapper;
import com.distributedstudentgradingsystem.Users.Teacher.Service.TeacherService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {HomeworkSubmissionMapper.class, HomeworkSubmissionService.class,
                StudentMapper.class, StudentService.class, TeacherService.class, TeacherMapper.class, ExpertService.class, ExpertMapper.class})
public abstract class GradeSubmissionMapper {

    @Autowired
    protected StudentService studentService;
    @Autowired
    protected TeacherService teacherService;
    @Autowired
    protected ExpertService expertService;
    @Autowired
    protected HomeworkSubmissionService homeworkSubmissionService;

    @Mappings({
            @Mapping(target = "graderStudent", expression = "java(studentService.findById(gradeSubmissionAddRequest.getGraderStudentID()))"),
            @Mapping(target = "submission",
                    expression = "java(homeworkSubmissionService.getOneHomeworkSubmission(gradeSubmissionAddRequest.getHomeworkSubmissionID()))"),
            @Mapping(target = "givenPoint", source = "point")
    })
    public abstract GradeSubmission dtoToEntity(GradeSubmissionAddRequest gradeSubmissionAddRequest);

    public abstract GradeSubmissionResponseDTO entityToDTO(GradeSubmission gradeSubmission);

    @Mappings({
            @Mapping(target = "givenPoint", source = "point"),
            @Mapping(target = "graderTeacher", expression = "java(teacherService.findById(gradeSubmissionUpdateRequest.getTeacherID()))"),
            @Mapping(target = "graderExpert", expression = "java(expertService.findById(gradeSubmissionUpdateRequest.getExpertID()))")
    })
    public abstract GradeSubmission updateDtoToEntity(GradeSubmissionUpdateRequest gradeSubmissionUpdateRequest);
}
