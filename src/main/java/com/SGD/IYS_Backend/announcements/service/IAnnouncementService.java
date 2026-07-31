package com.SGD.IYS_Backend.announcements.service;


import com.SGD.IYS_Backend.entity.Announcements;

import java.util.List;


public interface IAnnouncementService {

    Announcements getAnnouncement(Long enentId);
    List<Announcements> getAllActiveAnnouncement();
    List<Announcements> getAllLiveAnnouncement();
    List<Announcements> getAllUpcommingLiveAnnouncement();

}
