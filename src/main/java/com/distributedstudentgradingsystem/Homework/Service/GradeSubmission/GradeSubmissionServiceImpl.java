package com.distributedstudentgradingsystem.Homework.Service.GradeSubmission;

import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.GradeSubmission;
import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.MarkState;
import com.distributedstudentgradingsystem.Homework.Repository.GradeSubmission.GradeSubmissionRepository;
import com.distributedstudentgradingsystem.utilities.ErrorResult;
import com.distributedstudentgradingsystem.utilities.Result;
import com.distributedstudentgradingsystem.utilities.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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

    @Override
    public Result performObjection(Long gradeSubmissionId, Long userPerformedObjection) {
        if (gradeSubmissionId != null && userPerformedObjection != null) {
            GradeSubmission gradeSubmission = gradeSubmissionRepository.findById(gradeSubmissionId).orElse(null);
            if (gradeSubmission != null && gradeSubmission.getSubmission().getOwner().getId().equals(userPerformedObjection)) {
                gradeSubmission.setState(MarkState.OBJECTION_FROM_GRADED);
                gradeSubmissionRepository.save(gradeSubmission);
                return new SuccessResult();
            } else {
                throw new EntityNotFoundException("No such Grade Submission!");
            }
        }
        return null;
    }

    @Override
    public Result updateSubmission(GradeSubmission tempGradeSubmission, Long currentSubmissionId) {
        GradeSubmission gradeSubmissionDB = gradeSubmissionRepository.findById(currentSubmissionId).orElse(null);
        if (gradeSubmissionDB != null && tempGradeSubmission != null) {
            gradeSubmissionDB.setGivenPoint(tempGradeSubmission.getGivenPoint());
            if (tempGradeSubmission.getGraderTeacher() != null) {
                gradeSubmissionDB.setGraderTeacher(tempGradeSubmission.getGraderTeacher());
                gradeSubmissionDB.setState(MarkState.GRADED_AFTER_OBJECTION_BY_TEACHER);
            } else {
                gradeSubmissionDB.setGraderExpert(tempGradeSubmission.getGraderExpert());
                gradeSubmissionDB.setState(MarkState.GRADED_AFTER_OBJECTION_BY_EXPERT);
            }
            gradeSubmissionRepository.save(gradeSubmissionDB);
            return new SuccessResult();
        }
        return new ErrorResult();
    }

    @Override
    public Result redirectToExpert(Long id) {
        if (id != null) {
            GradeSubmission gradeSubmission = gradeSubmissionRepository.findById(id).orElse(null);
            if (gradeSubmission != null) {
                gradeSubmission.setState(MarkState.SENT_TO_THE_EXPERT_BY_TEACHER);
                gradeSubmissionRepository.save(gradeSubmission);
                return new SuccessResult();
            }
        }
        return new ErrorResult();
    }
}
