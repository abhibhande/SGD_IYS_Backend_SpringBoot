package com.SGD.IYS_Backend.repository;

import com.SGD.IYS_Backend.entity.Announcement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcement,Long> {

    List<Announcement> findByIsActiveTrueOrderByStartDatetimeAsc();

    @Query("""
            Select a from Announcement a
            where a.isActive = true
            AND a.status = 'live'
            ORDER BY a.startDatetime ASC""")
    List<Announcement> findActiveLiveAnnouncements();

    @Query("""
            Select a from Announcement a
            where a.isActive = true
            AND a.status IN('upcoming','live')
            ORDER BY a.startDatetime ASC""")
    List<Announcement> findUpcommingLiveAnnouncement();
}
