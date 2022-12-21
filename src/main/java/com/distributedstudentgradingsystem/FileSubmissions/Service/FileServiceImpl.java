package com.distributedstudentgradingsystem.FileSubmissions.Service;

import com.distributedstudentgradingsystem.FileSubmissions.Repository.FileRepository;
import com.distributedstudentgradingsystem.FileSubmissions.entity.File;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import com.distributedstudentgradingsystem.Users.Student.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final StudentService studentService;

    @Override
    public File addFile(MultipartFile multipartFile, Long creatorID) throws IOException {
        Student student = studentService.findById(creatorID);
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

    public ResponseEntity<byte[]> downloadFile(Integer id, Long creator) {

        File file = fileRepository.findById(id).get();
        if (file.getSubmissioner().getId() != creator) {
            throw new RuntimeException("You can not Reach this file!");
        } else {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""
                            + file.getName() + "_" + file.getSubmissioner().getId().toString() + "\"")
                    .body(file.getData());
        }
    }
}
