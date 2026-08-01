package com.shobhit.employeetaskmanagement.mapper;

import com.shobhit.employeetaskmanagement.dto.TaskRequestDTO;
import com.shobhit.employeetaskmanagement.dto.TaskResponseDTO;
import com.shobhit.employeetaskmanagement.entity.Task;

public class TaskMapper {

    public static Task toEntity(TaskRequestDTO dto){

        Task task = new Task();
        task.setDescription(dto.getDescription());
        task.setTitle(dto.getTitle());
        task.setStatus(dto.getStatus());
        task.setDueDate(dto.getDueDate());
        return task;
    }

    public static TaskResponseDTO toResponseDTO(Task task){

        TaskResponseDTO dto = new TaskResponseDTO();
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus());
        dto.setTitle(task.getTitle());
        dto.setDueDate(task.getDueDate());
        dto.setId(task.getId());
        dto.setEmployeeId(task.getEmployee().getId());
        dto.setEmployeeName(task.getEmployee().getName());

        return dto;
    }
}
