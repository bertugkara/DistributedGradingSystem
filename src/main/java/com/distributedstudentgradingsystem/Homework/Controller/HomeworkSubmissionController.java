package com.distributedstudentgradingsystem.Homework.Controller;

import com.distributedstudentgradingsystem.FileSubmissions.Service.FileService;
import com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission.HomeworkSubmissionAddRequest;
import com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission.HomeworkSubmissionResponseDTO;
import com.distributedstudentgradingsystem.Homework.Entity.HomeworkSubmission;
import com.distributedstudentgradingsystem.Homework.Mapper.HomeworkSubmissionMapper;
import com.distributedstudentgradingsystem.Homework.Service.HomeworkSubmission.HomeworkSubmissionService;
import com.distributedstudentgradingsystem.utilities.DataResult;
import com.distributedstudentgradingsystem.utilities.SuccessDataResult;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "homeworkSubmissions/")
public class HomeworkSubmissionController {

    private final HomeworkSubmissionService homeworkSubmissionService;
    private final HomeworkSubmissionMapper homeworkSubmissionMapper;
    private final FileService fileService;

    @PostMapping(value = "addSubmission")
    @PreAuthorize("hasAnyAuthority('STUDENT')")
    public DataResult addSubmission(@RequestPart("request") @Valid HomeworkSubmissionAddRequest request,
                                    @RequestPart("file") MultipartFile file) throws IOException {

        HomeworkSubmission homeworkSubmission = homeworkSubmissionService.addHomeworkSubmission(
                homeworkSubmissionMapper.dtoToEntity(request)
                , file);
        return new SuccessDataResult(homeworkSubmissionMapper.entityToDTO(homeworkSubmission));
    }

    @GetMapping("getOneSubmission")
    @PreAuthorize("hasAnyAuthority('ADMIN','EXPERT','TEACHER','STUDENT')")
    public DataResult<HomeworkSubmissionResponseDTO> getOneSubmission(@RequestParam @NotBlank Long id) {
        HomeworkSubmissionResponseDTO homeworkSubmissionResponseDTO =
                homeworkSubmissionMapper.entityToDTO(homeworkSubmissionService.getOneHomeworkSubmission(id));
        return new DataResult<>(homeworkSubmissionResponseDTO, homeworkSubmissionResponseDTO != null);
    }

    @GetMapping("getAllSubmissions")
    @PreAuthorize("hasAnyAuthority('ADMIN','EXPERT','TEACHER')")
    public DataResult<List<HomeworkSubmissionResponseDTO>> getAllSubmissions() {
        List<HomeworkSubmissionResponseDTO> homeworkSubmissionResponseDTOList =
                homeworkSubmissionMapper.entityListToDTOList(homeworkSubmissionService.getAllSubmissions());
        return new DataResult<>(homeworkSubmissionResponseDTOList, !homeworkSubmissionResponseDTOList.isEmpty());
    }

    @GetMapping("getSubmissionsWithTheHomeworkId")
    @PreAuthorize("hasAnyAuthority('ADMIN','EXPERT','TEACHER','STUDENT')")
    public DataResult<List<HomeworkSubmissionResponseDTO>> getSubmissionsWithTheHomeworkId(@RequestParam @NotBlank Long id) {
        List<HomeworkSubmissionResponseDTO> homeworkSubmissionResponseDTOList =
                homeworkSubmissionMapper.entityListToDTOList(homeworkSubmissionService.getAllSubmissionByHomeworkId(id));
        return new DataResult<>(homeworkSubmissionResponseDTOList, !homeworkSubmissionResponseDTOList.isEmpty());
    }

}
