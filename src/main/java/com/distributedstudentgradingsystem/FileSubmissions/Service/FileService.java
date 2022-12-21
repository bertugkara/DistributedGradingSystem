package com.distributedstudentgradingsystem.FileSubmissions.Service;

import com.distributedstudentgradingsystem.FileSubmissions.entity.File;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    File addFile(MultipartFile multipartFile, Long creatorIO) throws IOException;

    List<File> getAllFiles();

    ResponseEntity<byte[]> downloadFile(Integer id, Long creatorID);

}
