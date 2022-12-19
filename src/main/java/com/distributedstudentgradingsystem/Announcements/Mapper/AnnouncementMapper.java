package com.distributedstudentgradingsystem.Announcements.Mapper;

import com.distributedstudentgradingsystem.Announcements.DTO.AddAnnouncementRequestDTO;
import com.distributedstudentgradingsystem.Announcements.DTO.AnnouncementResponseDTO;
import com.distributedstudentgradingsystem.Announcements.Entity.Announcement;
import com.distributedstudentgradingsystem.Users.Admin.Mapper.AdminMapper;
import com.distributedstudentgradingsystem.Users.Admin.Service.AdminService;
import com.distributedstudentgradingsystem.Users.Teacher.Mapper.TeacherMapper;
import com.distributedstudentgradingsystem.Users.Teacher.Service.TeacherService;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT,
        unmappedTargetPolicy = ReportingPolicy.WARN,
        uses = {AdminService.class, TeacherService.class, AdminMapper.class, TeacherMapper.class})
public abstract class AnnouncementMapper {

    @Autowired
    protected AdminService adminService;
    @Autowired
    protected TeacherService teacherService;

    @Mappings({
            @Mapping(source = "admin", target = "adminPojoResponseDTO" ),
            @Mapping(source = "instructor", target = "pojoTeacherResponseDTO")
    })
    public abstract AnnouncementResponseDTO entityToResponseDTO(Announcement announcement);

    public abstract List<AnnouncementResponseDTO> entityListToResponseList(List<Announcement> announcements);

    @Mappings({
            @Mapping(target="instructor" , expression = "java(teacherService.findById(addAnnouncementRequestDTO.getInstructorID()))"),
            @Mapping(target="admin" , expression = "java(adminService.findById(addAnnouncementRequestDTO.getAdminID()))"),

    })
    public abstract Announcement addRequestDtoToEntity(AddAnnouncementRequestDTO addAnnouncementRequestDTO);
}
