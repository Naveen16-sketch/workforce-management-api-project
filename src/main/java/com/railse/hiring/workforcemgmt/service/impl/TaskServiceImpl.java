package com.railse.hiring.workforcemgmt.service.impl;

import com.railse.hiring.workforcemgmt.Repository.TaskRepository;
import com.railse.hiring.workforcemgmt.dto.TaskDto;
import com.railse.hiring.workforcemgmt.exception.ResourceNotFoundException;
import com.railse.hiring.workforcemgmt.mapper.TaskMapper;
import com.railse.hiring.workforcemgmt.model.Task;
import com.railse.hiring.workforcemgmt.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public TaskDto getTaskById(Long id) {
        Task task = taskRepository.get(id);
        if (task == null) {
            throw new ResourceNotFoundException("Task not found with id " + id);
        }
        return taskMapper.toDto(task);
    }

    @Override
    public TaskDto createTask(TaskDto taskDto) {
        Task task = taskMapper.toEntity(taskDto);
        task.setId(TaskRepository.nextId());
        taskRepository.save(task);
        return taskMapper.toDto(task);
    }

    @Override
    public Task createTask(Task task) {
        task.setId(TaskRepository.nextId());
        taskRepository.save(task);
        return task;
    }

    @Override
    public Task reassignTask(Long id, String newAssignee) {
        Task task = taskRepository.get(id);
        if (task == null) {
            throw new ResourceNotFoundException("Task not found with id " + id);
        }
        task.setAssignee(newAssignee);
        return task;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.getAll();
    }
}