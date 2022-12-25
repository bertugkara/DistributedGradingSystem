package com.distributedstudentgradingsystem.Homework.Controller.GradeSubmissionController;

import com.distributedstudentgradingsystem.Homework.DTO.GradeSubmission.GradeSubmissionAddRequest;
import com.distributedstudentgradingsystem.Homework.DTO.GradeSubmission.GradeSubmissionUpdateRequest;
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

    @PostMapping("performObjection")
    @PreAuthorize("hasAuthority('STUDENT')")
    public Result performObjection(@RequestParam @NotBlank Long gradeSubmissionId,
                                   @RequestParam @NotBlank Long userPerformedObjectionId) {
        return gradeSubmissionService.performObjection(gradeSubmissionId, userPerformedObjectionId);
    }

    @PostMapping("updateSubmissionTeacher")
    @PreAuthorize("hasAnyAuthority('TEACHER')")
    public Result updateSubmissionTeacher(@RequestBody @NotBlank GradeSubmissionUpdateRequest request) {
        return gradeSubmissionService.updateSubmission(gradeSubmissionMapper.updateDtoToEntity(request), request.getCurrentGradeSubmissionId());
    }

    @PostMapping("redirectToExpert")
    @PreAuthorize("hasAnyAuthority('TEACHER')")
    public Result redirectToExpert(@RequestParam(name = "id") @NotBlank Long id) {
        return gradeSubmissionService.redirectToExpert(id);
    }

    @PostMapping("updateSubmissionExpert")
    @PreAuthorize("hasAnyAuthority('EXPERT')")
    public Result updateSubmissionExpert(@RequestBody @NotBlank GradeSubmissionUpdateRequest request) {
        return gradeSubmissionService.updateSubmission(gradeSubmissionMapper.updateDtoToEntity(request), request.getCurrentGradeSubmissionId());
    }


}
