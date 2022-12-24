package com.distributedstudentgradingsystem.FileSubmissions.controller;


import com.distributedstudentgradingsystem.FileSubmissions.Mapper.FileMapper;
import com.distributedstudentgradingsystem.FileSubmissions.Service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "file/")
public class FileController {
    private final FileService fileService;
    private final FileMapper fileMapper;

    @GetMapping("seeFile/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','EXPERT','TEACHER')")
    ResponseEntity<byte[]> seeFile(@PathVariable Long id, @RequestParam Long creatorID) {
        return fileService.downloadFile(id,creatorID);
    }
}
