package com.shobhit.employeetaskmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {

    private Long employeeId;
    private String title;
    private String description;
    private String status;
    private LocalDate dueDate;
}
