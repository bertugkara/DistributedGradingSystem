package com.distributedstudentgradingsystem.Homework.Controller;

import com.distributedstudentgradingsystem.Homework.DTO.Homework.HomeworkAddRequestDTO;
import com.distributedstudentgradingsystem.Homework.DTO.Homework.HomeworkResponseDTO;
import com.distributedstudentgradingsystem.Homework.Mapper.HomeworkMapper;
import com.distributedstudentgradingsystem.Homework.Service.Homework.HomeworkService;
import com.distributedstudentgradingsystem.utilities.DataResult;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "homework/")
public class HomeworkController {
    private final HomeworkService homeworkService;
    private final HomeworkMapper homeworkMapper;

    @PostMapping("addHomework")
    @PreAuthorize("hasAnyAuthority('ADMIN','TEACHER')")
    public Result addHomework(@RequestBody @Valid HomeworkAddRequestDTO request) {
        return homeworkService.addHomework(homeworkMapper.dtoToEntity(request));
    }

    @GetMapping("getOneHomework")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','EXPERT','TEACHER')")
    public DataResult<HomeworkResponseDTO> getHomework(@NotBlank Long id) {
        HomeworkResponseDTO homeworkResponseDTO = homeworkMapper.entityToDTO(homeworkService.getOneHomework(id));
        return new DataResult<>(homeworkResponseDTO, homeworkResponseDTO != null);
    }

    @GetMapping("getAllHomeworks")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','EXPERT','TEACHER')")
    public DataResult<List<HomeworkResponseDTO>> getAllHomeworks(@RequestParam Long id) {
        List<HomeworkResponseDTO> homeworkResponseDTOList = homeworkMapper.entityListToDtoList(homeworkService.getAllHomeworksByClassID(id));
        return new DataResult<>(homeworkResponseDTOList, !homeworkResponseDTOList.isEmpty());
    }

}
