package com.distributedstudentgradingsystem.Comment.Controller;

import com.distributedstudentgradingsystem.Comment.DTO.CommentResponseDTO;
import com.distributedstudentgradingsystem.Comment.DTO.CreateParentCommentRequest;
import com.distributedstudentgradingsystem.Comment.Entity.Comment;
import com.distributedstudentgradingsystem.Comment.Mapper.CommentMapper;
import com.distributedstudentgradingsystem.Comment.Service.CommentService;
import com.distributedstudentgradingsystem.utilities.DataResult;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "comment/")
public class CommentController {

    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @PostMapping("addParentComment")
    @PreAuthorize("hasAnyAuthority('TEACHER','STUDENT','EXPERT')")
    public Result addParentComment(@RequestBody @Valid CreateParentCommentRequest createParentCommentRequest) {
        return commentService.addParentComment(commentMapper.dtoToEntity(createParentCommentRequest));
    }

    @GetMapping("getByHomeworkSubmissionId")
    @PreAuthorize("hasAnyAuthority('TEACHER','STUDENT','EXPERT')")
    public DataResult<CommentResponseDTO> getByHomeworkSubmissionId(@RequestParam @NotBlank Long homeworkSubmissionID) {
        Comment byHomeworkSubmission = commentService.getByHomeworkSubmission(homeworkSubmissionID);
        return new DataResult<>(commentMapper.parentEntityToDto(byHomeworkSubmission), byHomeworkSubmission != null);
    }
}
