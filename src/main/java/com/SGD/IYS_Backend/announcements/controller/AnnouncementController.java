package com.SGD.IYS_Backend.announcements.controller;

import com.SGD.IYS_Backend.announcements.service.IAnnouncementService;
import com.SGD.IYS_Backend.entity.Announcement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class AnnouncementController {
    private final IAnnouncementService announscementService;

    @GetMapping
    public List<Announcement> getAllActiveAnnouncement()
    {
        return announscementService.getAllActiveAnnouncement();
    }


    @GetMapping("/{eventId}")
    public ResponseEntity<?> getAnnouncement(@PathVariable(name = "eventId") Long eventId)
    {
        Announcement announcements = announscementService.getAnnouncement(eventId);
        if(announcements == null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Announcements found for Announcements id: "+eventId);
        }
        return ResponseEntity.ok().body(announcements);
    }

    @GetMapping("/live")
    public List<Announcement> getAllLiveAnnouncement()
    {
        return announscementService.getAllLiveAnnouncement();
    }

    @GetMapping("/home")
    public List<Announcement> getAllUpcommingLiveAnnouncement()
    {
        return announscementService.getAllUpcommingLiveAnnouncement();
    }

}
