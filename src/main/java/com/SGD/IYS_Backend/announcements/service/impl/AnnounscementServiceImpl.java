package com.SGD.IYS_Backend.announcements.service.impl;

import com.SGD.IYS_Backend.announcements.service.IAnnouncementService;
import com.SGD.IYS_Backend.entity.Announcements;
import com.SGD.IYS_Backend.repository.AnnouncementRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnounscementServiceImpl implements IAnnouncementService {


    public final AnnouncementRepo announcementRepo;

    @Override
    public Announcements getAnnouncement(Long eventId) {
        return announcementRepo.findById(eventId).orElse(null);
    }

    @Override
    public List<Announcements> getAllActiveAnnouncement() {
        return announcementRepo.findByIsActiveTrueOrderByStartDatetimeAsc();
    }

    @Override
    public List<Announcements> getAllLiveAnnouncement() {
        return announcementRepo.findActiveLiveAnnouncements();
    }

    @Override
    public List<Announcements> getAllUpcommingLiveAnnouncement() {
        return announcementRepo.findUpcommingLiveAnnouncement();
    }


}
