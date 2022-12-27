package com.distributedstudentgradingsystem.Comment.Service;

import com.distributedstudentgradingsystem.Comment.Entity.Comment;
import com.distributedstudentgradingsystem.utilities.Result;

public interface CommentService {

    Comment findById(Long id);

    Result addParentComment(Comment comment);

    Comment getByHomeworkSubmission(Long id);
}
