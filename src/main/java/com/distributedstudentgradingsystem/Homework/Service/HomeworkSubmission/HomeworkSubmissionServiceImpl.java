package com.distributedstudentgradingsystem.Homework.Service.HomeworkSubmission;

import com.distributedstudentgradingsystem.FileSubmissions.Service.FileService;
import com.distributedstudentgradingsystem.FileSubmissions.entity.File;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import com.distributedstudentgradingsystem.Homework.Repository.HomeworkSubmissionRepository;
import com.distributedstudentgradingsystem.utilities.Result;
import com.distributedstudentgradingsystem.utilities.SuccessResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class HomeworkSubmissionServiceImpl implements HomeworkSubmissionService {

    private final HomeworkSubmissionRepository homeworkSubmissionRepository;
    private final FileService fileService;
    @Override
    public Result addHomeworkSubmission(HomeworkSubmission homeworkSubmission, MultipartFile multipartFile) throws IOException {
        File file = fileService.addFile(multipartFile, homeworkSubmission.getOwner().getId());
        if (file == null) {
            throw new IOException("File is corrupted");
        }
        homeworkSubmission.setFile(file);
        homeworkSubmissionRepository.save(homeworkSubmission);
        return new SuccessResult();
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
}
