package com.railse.hiring.workforcemgmt.Repository;

import com.railse.hiring.workforcemgmt.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class TaskRepository {

    private final Map<Long, Task> tasks = new HashMap<>();
    private static Long idCounter = 1L;

    public Task get(Long id) {
        return tasks.get(id);
    }

    public void save(Task task) {
        tasks.put(task.getId(), task);
    }

    public static Long nextId() {
        return idCounter++;
    }

    public List<Task> getAll() {
        return new ArrayList<>(tasks.values());
    }
}

