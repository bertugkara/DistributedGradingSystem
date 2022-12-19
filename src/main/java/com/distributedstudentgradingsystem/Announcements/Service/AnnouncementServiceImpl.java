package com.distributedstudentgradingsystem.Announcements.Service;

import com.distributedstudentgradingsystem.Announcements.DTO.AnnouncementResponseDTO;
import com.distributedstudentgradingsystem.Announcements.Entity.Announcement;
import com.distributedstudentgradingsystem.Announcements.Mapper.AnnouncementMapper;
import com.distributedstudentgradingsystem.Announcements.Repository.AnnouncementRepository;
import com.distributedstudentgradingsystem.utilities.DataResult;
import com.distributedstudentgradingsystem.utilities.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnouncementServiceImpl implements AnnouncementService {
    private final AnnouncementRepository announcementRepository;
    private final AnnouncementMapper announcementMapper;

    @Override
    public Result addAnnouncement(Announcement announcement) {
        return new Result(announcementRepository.save(announcement) != null);
    }

    @Override
    public DataResult<List<AnnouncementResponseDTO>> getAllAnnouncements() {
        return new DataResult<>(announcementMapper.entityListToResponseList(
                announcementRepository.findAll()),true);
    }

}
