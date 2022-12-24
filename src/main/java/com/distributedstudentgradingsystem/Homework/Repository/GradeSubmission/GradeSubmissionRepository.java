package com.distributedstudentgradingsystem.Homework.Repository.GradeSubmission;

import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.GradeSubmission;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeSubmissionRepository extends JpaRepository<GradeSubmission,Long> {
}
