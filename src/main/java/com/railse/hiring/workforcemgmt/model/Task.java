package com.railse.hiring.workforcemgmt.model;

import lombok.*;
import java.time.LocalDateTime;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public class Task {
        private Long id;
        private String title;
        private String description;
        private String assignee;
        private TaskStatus status;
        private LocalDateTime assignedAt;
        private int priority;
    }



