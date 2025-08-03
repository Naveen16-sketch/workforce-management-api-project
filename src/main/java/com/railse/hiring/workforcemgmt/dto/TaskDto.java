package com.railse.hiring.workforcemgmt.dto;

import lombok.*;
import com.railse.hiring.workforcemgmt.model.TaskStatus;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private String assignee;
    private TaskStatus status;
    private LocalDateTime assignedAt;
    private int priority;
}
