package com.distributedstudentgradingsystem.Homework.Repository;

import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.MarkState;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface HomeworkSubmissionRepository extends JpaRepository<HomeworkSubmission,Long> {

    List<HomeworkSubmission> findAllByHomework_Id(Long id);

    List<HomeworkSubmission> findAllByOwner_Id(Long id);

    List<HomeworkSubmission> findAllByHomework_Lesson_IdAndGradeSubmissionNull(Long id);

    List<HomeworkSubmission> findHomeworkSubmissionsByGradeSubmission_State(MarkState markState);

}
