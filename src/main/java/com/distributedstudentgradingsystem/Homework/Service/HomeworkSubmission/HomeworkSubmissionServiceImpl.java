package com.distributedstudentgradingsystem.Homework.Service.HomeworkSubmission;

import com.distributedstudentgradingsystem.FileSubmissions.Service.FileService;
import com.distributedstudentgradingsystem.FileSubmissions.entity.File;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import com.distributedstudentgradingsystem.Homework.Repository.HomeworkSubmissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkSubmissionServiceImpl implements HomeworkSubmissionService {

    private final HomeworkSubmissionRepository homeworkSubmissionRepository;
    private final FileService fileService;

    @Override
    public HomeworkSubmission addHomeworkSubmission(HomeworkSubmission homeworkSubmission, MultipartFile multipartFile) throws IOException {
        File file = fileService.addFile(multipartFile, homeworkSubmission.getOwner());
        if (file == null) {
            throw new IOException("File is corrupted");
        }
        homeworkSubmission.setFile(file);
        homeworkSubmissionRepository.save(homeworkSubmission);
        return (homeworkSubmission);
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


}
