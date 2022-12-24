package com.distributedstudentgradingsystem.Homework.Controller.GradeSubmissionController;

import com.distributedstudentgradingsystem.Homework.DTO.HomeworkSubmission.GradeSubmissionAddRequest;
import com.distributedstudentgradingsystem.Homework.Mapper.GradeSubmission.GradeSubmissionMapper;
import com.distributedstudentgradingsystem.Homework.Service.GradeSubmission.GradeSubmissionService;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "grade/")
public class GradeSubmissionController {

    private final GradeSubmissionService gradeSubmissionService;
    private final GradeSubmissionMapper gradeSubmissionMapper;

    @PostMapping("gradeSubmission")
    @PreAuthorize("hasAnyAuthority('EXPERT','STUDENT')")
    public Result gradeSubmission(@RequestBody @NotBlank GradeSubmissionAddRequest request) {
        return gradeSubmissionService.gradeSubmission(gradeSubmissionMapper.dtoToEntity(request));
    }
}
