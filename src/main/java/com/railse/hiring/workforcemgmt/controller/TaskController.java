package com.railse.hiring.workforcemgmt.controller;

import com.railse.hiring.workforcemgmt.dto.TaskDto;
import com.railse.hiring.workforcemgmt.mapper.TaskMapper;
import com.railse.hiring.workforcemgmt.model.Task;
import com.railse.hiring.workforcemgmt.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    @PostMapping
    public TaskDto create(@RequestBody TaskDto dto) {
        Task task = taskService.createTask(taskMapper.toEntity(dto));
        return taskMapper.toDto(task);
    }

    @PutMapping("/{id}/reassign")
    public TaskDto reassign(@PathVariable Long id, @RequestParam String newAssignee) {
        Task task = taskService.reassignTask(id, newAssignee);
        return taskMapper.toDto(task);
    }

    @GetMapping
    public List<TaskDto> list() {
        return taskService.getAllTasks().stream()
                .map(taskMapper::toDto)
                .collect(Collectors.toList());
    }
    @GetMapping("/{id}")
    public TaskDto getById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }
}
