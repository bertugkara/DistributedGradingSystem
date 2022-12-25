package com.distributedstudentgradingsystem.Homework.Service.GradeSubmission;

import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.GradeSubmission;
import com.distributedstudentgradingsystem.utilities.Result;

public interface GradeSubmissionService {

    Result gradeSubmission(GradeSubmission gradeSubmission);

    Result performObjection(Long gradeSubmissionId, Long userPerformObjection);

    Result updateSubmission(GradeSubmission gradeSubmission, Long currentSubmissionId);

    Result redirectToExpert(Long id);
}
