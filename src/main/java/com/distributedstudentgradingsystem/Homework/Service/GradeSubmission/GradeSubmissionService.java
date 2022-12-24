package com.distributedstudentgradingsystem.Homework.Service.GradeSubmission;

import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.GradeSubmission;
import com.distributedstudentgradingsystem.utilities.Result;

public interface GradeSubmissionService {


    Result gradeSubmission(GradeSubmission gradeSubmission);
}
