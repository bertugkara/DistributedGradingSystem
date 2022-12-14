package com.distributedstudentgradingsystem.FileSubmissions.Service;

import com.distributedstudentgradingsystem.FileSubmissions.Repository.FileRepository;
import com.distributedstudentgradingsystem.FileSubmissions.entity.File;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    @Override
    public File addFile(MultipartFile multipartFile, Student student) throws IOException {
        String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
        File file = new File(fileName, multipartFile.getContentType(), multipartFile.getBytes(), student);
        fileRepository.save(file);
        return file;
    }

    @Override
    public List<File> getAllFiles() {

        List<File> fileList = fileRepository.findAll();

        if (fileRepository.findAll().isEmpty()) {
            throw new EntityNotFoundException("No files found");
        }
        return fileList;
    }

    public ResponseEntity<byte[]> downloadFile(Long id, Long creator) {

        File file = fileRepository.findById(id).get();
        if (!file.getSubmissioner().getId().equals(creator)) {
            throw new RuntimeException("You can not Reach this file!");
        } else {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                            + file.getName() + "_" + file.getSubmissioner().getId().toString() + "\"")
                    .body(file.getData());
        }
    }

    @Override
    public String getFileUrl(File file) {
        String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/file/files/")
                .path(file.getId().toString())
                .toUriString();
        return fileDownloadUri;
    }

    @Override
    public void assignHomeworkSubmissionToFile(Long fileID, HomeworkSubmission homeworkSubmission) {
       File file = fileRepository.findById(fileID).orElse(null);
       file.setHomeworkSubmission(homeworkSubmission);
       fileRepository.save(file);
    }
}
