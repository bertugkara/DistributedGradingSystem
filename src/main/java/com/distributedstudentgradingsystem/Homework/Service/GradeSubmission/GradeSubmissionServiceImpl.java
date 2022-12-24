package com.distributedstudentgradingsystem.Homework.Service.GradeSubmission;

import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.GradeSubmission;
import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.MarkState;
import com.distributedstudentgradingsystem.Homework.Repository.GradeSubmission.GradeSubmissionRepository;
import com.distributedstudentgradingsystem.utilities.ErrorResult;
import com.distributedstudentgradingsystem.utilities.Result;
import com.distributedstudentgradingsystem.utilities.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GradeSubmissionServiceImpl implements GradeSubmissionService {

    private final GradeSubmissionRepository gradeSubmissionRepository;

    @Override
    public Result gradeSubmission(GradeSubmission gradeSubmission) {
        if (gradeSubmission != null) {
            if (gradeSubmission.getGraderStudent().getId().equals(gradeSubmission.getSubmission().getOwner().getId())) {
                throw new RuntimeException("You can not grade your own submission");
            } else {
                gradeSubmission.setState(MarkState.GRADED);
                gradeSubmissionRepository.save(gradeSubmission);
                return new SuccessResult();
            }
        }
        return new ErrorResult();
    }
}
