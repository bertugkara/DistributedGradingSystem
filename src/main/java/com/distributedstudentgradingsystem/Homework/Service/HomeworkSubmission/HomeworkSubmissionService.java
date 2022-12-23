package com.distributedstudentgradingsystem.Homework.Service.HomeworkSubmission;

import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HomeworkSubmissionService {

    HomeworkSubmission addHomeworkSubmission(HomeworkSubmission homeworkSubmission, MultipartFile file) throws IOException;

    HomeworkSubmission getOneHomeworkSubmission(Long id);

    List<HomeworkSubmission> getAllSubmissions();

    List<HomeworkSubmission> getAllSubmissionByHomeworkId(Long id);

    List<HomeworkSubmission> getAllByStudentId(Long id);
}
