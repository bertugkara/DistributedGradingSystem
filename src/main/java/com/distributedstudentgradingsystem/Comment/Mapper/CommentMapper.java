package com.distributedstudentgradingsystem.Comment.Mapper;

import com.distributedstudentgradingsystem.Comment.DTO.CommentResponseDTO;
import com.distributedstudentgradingsystem.Comment.DTO.CreateParentCommentRequest;
import com.distributedstudentgradingsystem.Comment.Entity.Comment;
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

@Mapper(componentModel = "spring", nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {TeacherService.class, StudentService.class, ExpertService.class,
                TeacherMapper.class, StudentMapper.class, ExpertMapper.class,
                HomeworkSubmissionService.class, HomeworkSubmissionMapper.class
        })
public abstract class CommentMapper {

    @Autowired
    protected TeacherService teacherService;
    @Autowired
    protected StudentService studentService;
    @Autowired
    protected ExpertService expertService;
    @Autowired
    protected HomeworkSubmissionService homeworkSubmissionService;

    @Mappings({
            @Mapping(target = "homeworkSubmission", expression = "java(homeworkSubmissionService.getOneHomeworkSubmission(createParentCommentRequest.getHomeworkSubmissionID()))"),
            @Mapping(target = "writerTeacher", expression = "java(teacherService.findById(createParentCommentRequest.getTeacherID()))"),
            @Mapping(target = "writerStudent", expression = "java(studentService.findById(createParentCommentRequest.getStudentID()))"),
            @Mapping(target = "writerExpert", expression = "java(expertService.findById(createParentCommentRequest.getExpertID()))"),
    })
    public abstract Comment dtoToEntity(CreateParentCommentRequest createParentCommentRequest);

    @Mappings({
            @Mapping(target = "comment", source = "comment"),
            @Mapping(target = "homeworkSubmissionResponseDTO", source = "homeworkSubmission"),
            @Mapping(target = "creatorStudent", source = "writerStudent"),
            @Mapping(target = "creatorTeacher", source = "writerTeacher"),
            @Mapping(target = "creatorExpert", source = "writerExpert"),
            @Mapping(target = "childComment", source = "childComment"),
            @Mapping(target = "parentComment", source = "anchestorComment"),
    })
    public abstract CommentResponseDTO parentEntityToDto(Comment comment);

}

