package com.railse.hiring.workforcemgmt.mapper;

import com.railse.hiring.workforcemgmt.model.Task;
import com.railse.hiring.workforcemgmt.dto.TaskDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto(Task task);
    Task toEntity(TaskDto dto);
}

