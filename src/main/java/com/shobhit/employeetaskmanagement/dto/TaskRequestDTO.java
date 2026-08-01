package com.shobhit.employeetaskmanagement.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequestDTO {

    @NotBlank(message = "Title cannot be blank")
    private String title;

    @NotBlank(message = "Description cannot be blank")
    private String description;

    @NotBlank(message = "Status cannot be blank")
    private String status;

    @NotNull(message = "Due date cannot be null")
    private LocalDate dueDate;

    @NotNull(message = "Employee ID cannot be null")
    private Long employeeId;

}
