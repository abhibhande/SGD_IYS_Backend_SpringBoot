package com.SGD.IYS_Backend.repository;

import com.SGD.IYS_Backend.entity.Announcements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnouncementRepo extends JpaRepository<Announcements,Long> {

    List<Announcements> findByIsActiveTrueOrderByStartDatetimeAsc();

    @Query("""
            Select a from Announcements a
            where a.isActive = true
            AND a.status = 'live'
            ORDER BY a.startDatetime ASC""")
    List<Announcements> findActiveLiveAnnouncements();

    @Query("""
            Select a from Announcements a
            where a.isActive = true
            AND a.status IN('upcoming','live')
            ORDER BY a.startDatetime ASC""")
    List<Announcements> findUpcommingLiveAnnouncement();
}
