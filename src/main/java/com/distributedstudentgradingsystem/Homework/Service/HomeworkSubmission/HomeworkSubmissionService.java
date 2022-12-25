package com.distributedstudentgradingsystem.Homework.Service.HomeworkSubmission;

import com.distributedstudentgradingsystem.Exception.StudentAlreadySubmittedThatHomeworkException;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface HomeworkSubmissionService {

    HomeworkSubmission addHomeworkSubmission(HomeworkSubmission homeworkSubmission, MultipartFile file) throws IOException, StudentAlreadySubmittedThatHomeworkException;

    HomeworkSubmission getOneHomeworkSubmission(Long id);

    List<HomeworkSubmission> getAllSubmissions();

    List<HomeworkSubmission> getAllSubmissionByHomeworkId(Long id);

    List<HomeworkSubmission> getAllByStudentId(Long id);

    List<HomeworkSubmission> getAllSubmissionsByClassIdAndScoreIsNull(Long id);

    List<HomeworkSubmission> getAllByStateObjection();

    Boolean isStudentValidToAddSubmission(Long studentId, Long homeworkID);

}
