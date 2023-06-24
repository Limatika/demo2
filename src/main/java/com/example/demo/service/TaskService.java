package com.example.demo.service;

import com.example.demo.entity.Status;
import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.*;


@Service
public class TaskService {

    private TaskRepository taskRepository;

    public TaskService (TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    public List<Task> getAll(){
        return (List<Task>) taskRepository.findAll();
        }

    public Task addTask(Task task) {
         return taskRepository.save(task);
    }

    public  void deleteById (Long id){taskRepository.deleteById(id);}

    public Task getById(Long id) {
        Optional<Task> optional = taskRepository.findById(id);
        if (optional.isPresent()) {
            return optional.get();
        }
        return new Task();
    }
    public void update(Long id, Task task) {
        task.setId(id);
        taskRepository.save(task);
    }
    public List<Task> getByName(String name){
        return taskRepository.getByName(name);
    }

}
