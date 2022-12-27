package com.distributedstudentgradingsystem.Comment.Service;

import com.distributedstudentgradingsystem.Comment.Entity.Comment;
import com.distributedstudentgradingsystem.Comment.Repository.CommentRepository;
import com.distributedstudentgradingsystem.Homework.Repository.HomeworkSubmissionRepository;
import com.distributedstudentgradingsystem.utilities.Result;
import com.distributedstudentgradingsystem.utilities.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final HomeworkSubmissionRepository homeworkSubmissionRepository;

    @Override
    public Comment findById(Long id) {
        if (id != null) {
            return commentRepository.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public Result addParentComment(Comment comment) {
        if (comment != null) {
            comment.setAnchestorComment(null);
            commentRepository.save(comment);
            return new SuccessResult();
        }
        return null;
    }

    @Override
    @Transactional
    public Comment getByHomeworkSubmission(Long id) {
        if (id != null) {
            Comment comment = commentRepository.findCommentByHomeworkSubmission_IdAndAnchestorCommentNull(id);
            if (comment != null) {
                return comment;
            }
        }
        return null;
    }
}
