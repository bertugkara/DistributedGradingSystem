package com.distributedstudentgradingsystem.Announcements.Controller;


import com.distributedstudentgradingsystem.Announcements.DTO.AddAnnouncementRequestDTO;
import com.distributedstudentgradingsystem.Announcements.DTO.AnnouncementResponseDTO;
import com.distributedstudentgradingsystem.Announcements.Mapper.AnnouncementMapper;
import com.distributedstudentgradingsystem.Announcements.Service.AnnouncementService;
import com.distributedstudentgradingsystem.utilities.DataResult;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@CrossOrigin
@RestController
@RequestMapping(path = "announcement/")
public class AnnouncementController {

    private final AnnouncementService announcementService;
    private final AnnouncementMapper announcementMapper;

    @PostMapping(value = "add")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Result add(@RequestBody @Valid AddAnnouncementRequestDTO addAnnouncementRequestDTO){
        return announcementService.addAnnouncement(announcementMapper.addRequestDtoToEntity(addAnnouncementRequestDTO));
    }

    @GetMapping(value = "getAll")
    @PreAuthorize("hasAnyAuthority('ADMIN','STUDENT','TEACHER','EXPERT')")
    public DataResult<List<AnnouncementResponseDTO>> getAllAnnouncements(){
        return announcementService.getAllAnnouncements();
    }
}
