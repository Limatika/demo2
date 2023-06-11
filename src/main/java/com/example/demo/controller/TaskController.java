package com.example.demo.controller;

import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import com.example.demo.service.TaskService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAll() {
        return taskService.getAll();
    }

    @PostMapping
    public void createTask(@RequestBody Task task) {
        System.out.println(task);
        taskService.addTask(task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        taskService.deleteById(id);

    }

    @GetMapping("/{id}")
    public Task getById(@PathVariable Long id) {
        return taskService.getById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody Task task) {
        taskService.update(id, task);
    }

    @GetMapping("/filter")
    public List<Task> getByname(@RequestParam String name) {
        return taskService.getByName(name);
    }
}

