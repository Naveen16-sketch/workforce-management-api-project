package com.railse.hiring.workforcemgmt.service;

import com.railse.hiring.workforcemgmt.dto.TaskDto;
import com.railse.hiring.workforcemgmt.exception.ResourceNotFoundException;
import com.railse.hiring.workforcemgmt.model.Task;

import java.util.List;

public interface TaskService {
    TaskDto getTaskById(Long id) throws ResourceNotFoundException;

    TaskDto createTask(TaskDto taskDto);

    Task createTask(Task task);
    Task reassignTask(Long id, String newAssignee);
    List<Task> getAllTasks();
}
