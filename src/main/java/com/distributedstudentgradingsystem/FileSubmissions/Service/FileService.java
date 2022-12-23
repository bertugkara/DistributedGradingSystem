package com.distributedstudentgradingsystem.FileSubmissions.Service;

import com.distributedstudentgradingsystem.FileSubmissions.entity.File;
import com.distributedstudentgradingsystem.Users.Student.Entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    File addFile(MultipartFile multipartFile, Student student) throws IOException;

    List<File> getAllFiles();

    ResponseEntity<byte[]> downloadFile(Long id, Long creatorID);

    String getFileUrl(File file);

}
