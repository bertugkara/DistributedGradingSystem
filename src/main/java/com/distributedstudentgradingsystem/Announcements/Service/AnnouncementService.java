package com.distributedstudentgradingsystem.Announcements.Service;

import com.distributedstudentgradingsystem.Announcements.DTO.AnnouncementResponseDTO;
import com.distributedstudentgradingsystem.Announcements.Entity.Announcement;
import com.distributedstudentgradingsystem.utilities.DataResult;
import com.distributedstudentgradingsystem.utilities.Result;

import java.util.List;

public interface AnnouncementService {

    Result addAnnouncement(Announcement announcement);
    DataResult<List<AnnouncementResponseDTO>> getAllAnnouncements();

}
