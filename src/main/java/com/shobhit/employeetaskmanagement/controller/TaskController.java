package com.shobhit.employeetaskmanagement.controller;

import com.shobhit.employeetaskmanagement.dto.TaskRequestDTO;
import com.shobhit.employeetaskmanagement.dto.TaskResponseDTO;
import com.shobhit.employeetaskmanagement.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    TaskService taskService;
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping
    public TaskResponseDTO saveTask(@RequestBody TaskRequestDTO taskRequestDTO){
        return taskService.saveTask(taskRequestDTO);
    }

    @GetMapping
    public List<TaskResponseDTO> getAllEmployees(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public TaskResponseDTO getTaskById(@PathVariable("id") Long taskId){
        return taskService.getTaskById(taskId);
    }

    @PutMapping("/{id}")
    public TaskResponseDTO updateTask(@PathVariable("id") Long taskId, @RequestBody TaskRequestDTO taskRequestDTO){
        return taskService.updateTaskById(taskId, taskRequestDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id){
        return taskService.deleteTaskById(id);
    }

    @GetMapping("/{employeeId}/tasks")
    public List<TaskResponseDTO> getTasksByEmployeeId(@PathVariable Long employeeId){
        return taskService.getTasksByEmployeeId(employeeId);
    }

    @GetMapping("/status/{status}")
    public List<TaskResponseDTO> getTasksByStatus(@PathVariable String status){
        return taskService.getTaskByStatus(status);
    }


}
