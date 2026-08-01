package com.shobhit.employeetaskmanagement.service;

import com.shobhit.employeetaskmanagement.dto.TaskRequestDTO;
import com.shobhit.employeetaskmanagement.dto.TaskResponseDTO;
import com.shobhit.employeetaskmanagement.entity.Employee;
import com.shobhit.employeetaskmanagement.entity.Task;
import com.shobhit.employeetaskmanagement.exception.ResourceNotFoundException;
import com.shobhit.employeetaskmanagement.exception.TaskNotFoundException;
import com.shobhit.employeetaskmanagement.mapper.TaskMapper;
import com.shobhit.employeetaskmanagement.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    EmployeeService employeeService;
    TaskRepository taskRepository;

    public TaskService(EmployeeService employeeService, TaskRepository taskRepository){
        this.taskRepository = taskRepository;
        this.employeeService = employeeService;
    }

    private Task findTaskById(Long id){
        Optional<Task> task = taskRepository.findById(id);

        if(task.isPresent()){
            return task.get();
        }
        throw new ResourceNotFoundException("Task not found with id " + id);
    }

    public TaskResponseDTO saveTask(TaskRequestDTO dto){

        Task task = TaskMapper.toEntity(dto);
        Employee employee = employeeService.findEmployeeById(dto.getEmployeeId());
        task.setEmployee(employee);
        Task savedTask = taskRepository.save(task);

        return TaskMapper.toResponseDTO(savedTask);
    }

    public List<TaskResponseDTO> getAllTasks(){
       List<Task> tasks = taskRepository.findAll();
       List<TaskResponseDTO> response = new ArrayList<>();

       for(Task task : tasks){
        response.add(TaskMapper.toResponseDTO(task));
       }
        return response;
    }

    public TaskResponseDTO getTaskById(Long taskId) {
        Optional<Task> task = taskRepository.findById(taskId);
        if(task.isPresent()){
            return TaskMapper.toResponseDTO(task.get());
        }
        throw new TaskNotFoundException("Task not found with Task Id "+ taskId);
    }

    public TaskResponseDTO updateTaskById(Long taskId, TaskRequestDTO dto) {

        Task existingTask = findTaskById(taskId);
        Employee employee = employeeService.findEmployeeById(dto.getEmployeeId());

        existingTask.setStatus(dto.getStatus());
        existingTask.setTitle(dto.getTitle());
        existingTask.setDueDate(dto.getDueDate());
        existingTask.setDescription(dto.getDescription());
        existingTask.setEmployee(employee);
        Task updatedTask = taskRepository.save(existingTask);

        return TaskMapper.toResponseDTO(updatedTask);
    }

    public String deleteTaskById(Long id){

        Task task = findTaskById(id);
        taskRepository.delete(task);
        return "The Task with id " + id +" has been deleted ";
    }

    public List<TaskResponseDTO> getTasksByEmployeeId(Long employeeId){

        employeeService.findEmployeeById(employeeId);
        List<TaskResponseDTO> response = new ArrayList<>();
        List<Task> tasks = taskRepository.findByEmployee_Id(employeeId);
        for(Task task : tasks){
            response.add(TaskMapper.toResponseDTO(task));
        }
        return response;
    }

    public List<TaskResponseDTO> getTaskByStatus(String status){

        List<Task> tasks = taskRepository.findByStatus(status);
        if(tasks.isEmpty()){
            throw new TaskNotFoundException("No tasks found with status:" + status);
        }
        List<TaskResponseDTO> response = new ArrayList<>();
        for(Task task : tasks){
            response.add(TaskMapper.toResponseDTO(task));
        }
        return response;
    }

}
