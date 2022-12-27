package com.distributedstudentgradingsystem.Homework.Service.HomeworkSubmission;

import com.distributedstudentgradingsystem.Exception.StudentAlreadySubmittedThatHomeworkException;
import com.distributedstudentgradingsystem.FileSubmissions.Service.FileService;
import com.distributedstudentgradingsystem.FileSubmissions.entity.File;
import com.distributedstudentgradingsystem.Homework.Entity.GradeSubmission.MarkState;
import com.distributedstudentgradingsystem.Homework.Entity.Homework;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import com.distributedstudentgradingsystem.Homework.Repository.HomeworkSubmissionRepository;
import com.distributedstudentgradingsystem.Homework.Service.Homework.HomeworkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkSubmissionServiceImpl implements HomeworkSubmissionService {

    private final HomeworkSubmissionRepository homeworkSubmissionRepository;
    private final HomeworkService homeworkService;
    private final FileService fileService;

    @Override
    public HomeworkSubmission addHomeworkSubmission(HomeworkSubmission homeworkSubmission, MultipartFile multipartFile) throws IOException, StudentAlreadySubmittedThatHomeworkException {
        if (isStudentValidToAddSubmission
                (homeworkSubmission.getOwner().getId(), homeworkSubmission.getHomework().getId())) {
            throw new StudentAlreadySubmittedThatHomeworkException("You already Submitted to that class");
        } else {
            File file = fileService.addFile(multipartFile, homeworkSubmission.getOwner());
            if (file == null) {
                throw new IOException("File is corrupted");
            }
            homeworkSubmission.setFile(file);
            HomeworkSubmission savedSubmission = homeworkSubmissionRepository.save(homeworkSubmission);
            fileService.assignHomeworkSubmissionToFile(file.getId(), savedSubmission);
            return (homeworkSubmission);
        }
    }

    @Override
    public HomeworkSubmission getOneHomeworkSubmission(Long id) {
        if (id != null) {
            return homeworkSubmissionRepository.findById(id).orElse(null);
        }
        return null;
    }

    @Override
    public List<HomeworkSubmission> getAllSubmissions() {
        return homeworkSubmissionRepository.findAll();
    }

    @Override
    public List<HomeworkSubmission> getAllSubmissionByHomeworkId(Long id) {
        return homeworkSubmissionRepository.findAllByHomework_Id(id);
    }

    @Override
    public List<HomeworkSubmission> getAllByStudentId(Long id) {
        if (id != null) {
            return homeworkSubmissionRepository.findAllByOwner_Id(id);
        }
        return null;
    }

    @Override
    public List<HomeworkSubmission> getAllSubmissionsByClassIdAndScoreIsNull(Long id) {
        if (id != null) return homeworkSubmissionRepository.findAllByHomework_Lesson_IdAndGradeSubmissionNull(id);
        else return null;
    }

    @Override
    public List<HomeworkSubmission> getAllByStateObjection(MarkState markState) {
        return homeworkSubmissionRepository.findHomeworkSubmissionsByGradeSubmission_State(markState);
    }

    @Override
    public Boolean isStudentValidToAddSubmission(Long studentId, Long homeworkID) {
        Homework homework = homeworkService.getOneHomework(homeworkID);
        return homework.isStudentAlreadySubmittedBeforeForTheGivenHomework(studentId);
    }

}
