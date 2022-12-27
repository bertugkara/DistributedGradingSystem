package com.distributedstudentgradingsystem.Comment.DTO;

import com.distributedstudentgradingsystem.Comment.Entity.Comment;
import com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission.HomeworkSubmissionResponseDTO;
import com.distributedstudentgradingsystem.Users.Expert.DTO.PojoExpertResponseDTO;
import com.distributedstudentgradingsystem.Users.Student.DTO.PojoStudentResponseDTO;
import com.distributedstudentgradingsystem.Users.Teacher.DTO.PojoTeacherResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class CommentResponseDTO {
    private String comment;
    private PojoStudentResponseDTO creatorStudent;
    private PojoTeacherResponseDTO creatorTeacher;
    private PojoExpertResponseDTO creatorExpert;
    private Comment parentComment;
    private CommentResponseDTO childComment;
    private HomeworkSubmissionResponseDTO homeworkSubmissionResponseDTO;
}
