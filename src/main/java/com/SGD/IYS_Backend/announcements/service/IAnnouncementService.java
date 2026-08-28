package com.SGD.IYS_Backend.announcements.service;


import com.SGD.IYS_Backend.entity.Announcement;

import java.util.List;


public interface IAnnouncementService {

    Announcement getAnnouncement(Long enentId);
    List<Announcement> getAllActiveAnnouncement();
    List<Announcement> getAllLiveAnnouncement();
    List<Announcement> getAllUpcommingLiveAnnouncement();

}
