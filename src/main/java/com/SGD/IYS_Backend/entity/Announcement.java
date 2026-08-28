package com.SGD.IYS_Backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.OffsetDateTime;

@Entity
@Table(name = "announcements_event", schema = "public")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Announcement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "Category is required")
    @Pattern(
            regexp = "event|workshop|announcement|notice",
            message = "Category must be one of: event, workshop, announcement, notice"
    )
    @Column(name = "category", nullable = false)
    private String category = "event";

    @NotBlank(message = "Title is required")
    @Size(max = 200, message = "Title cannot exceed 200 characters")
    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @NotNull(message = "Description is required")
    @Column(name = "description", nullable = false, columnDefinition = "text")
    private String description = "";

    @Column(name = "poster", columnDefinition = "text")
    private String poster;

    @NotBlank(message = "Event type is required")
    @Pattern(
            regexp = "offline|online|hybrid",
            message = "Event type must be one of: offline, online, hybrid"
    )
    @Column(name = "event_type", nullable = false)
    private String eventType = "offline";

    @NotBlank(message = "Status is required")
    @Pattern(
            regexp = "upcoming|live|completed",
            message = "Status must be one of: upcoming, live, completed"
    )
    @Column(name = "status", nullable = false)
    private String status = "upcoming";

    @NotNull(message = "Start datetime is required")
    @Column(name = "start_datetime", nullable = false)
    private OffsetDateTime startDatetime;

    @Column(name = "end_datetime")
    private OffsetDateTime endDatetime;

    @Column(name = "youtube_live_url", columnDefinition = "text")
    private String youtubeLiveUrl;

    @Column(name = "youtube_replay_url", columnDefinition = "text")
    private String youtubeReplayUrl;

    @Column(name = "youtube_thumbnail", columnDefinition = "text")
    private String youtubeThumbnail;

    @NotBlank(message = "Location name is required")
    @Size(max = 200, message = "Location name cannot exceed 200 characters")
    @Column(name = "location_name", nullable = false, length = 200)
    private String locationName = "";

    @Column(name = "location_map_link", columnDefinition = "text")
    private String locationMapLink;

    @Column(name = "registration_link", columnDefinition = "text")
    private String registrationLink;

    @NotNull(message = "Active status is required")
    @Column(name = "is_active", nullable = false)
    private Boolean isActive = true;

    @Column(name = "created_at", nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @PrePersist
    public void prePersist() {
        if (createdAt == null) {
            createdAt = OffsetDateTime.now();
        }
    }
}