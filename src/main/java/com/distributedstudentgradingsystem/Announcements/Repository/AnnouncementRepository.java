package com.distributedstudentgradingsystem.Announcements.Repository;

import com.distributedstudentgradingsystem.Announcements.Entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {
}
