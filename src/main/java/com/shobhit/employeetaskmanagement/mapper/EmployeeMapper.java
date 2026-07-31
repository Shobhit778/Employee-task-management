package com.shobhit.employeetaskmanagement.mapper;

import com.shobhit.employeetaskmanagement.dto.EmployeeRequestDTO;
import com.shobhit.employeetaskmanagement.dto.EmployeeResponseDTO;
import com.shobhit.employeetaskmanagement.entity.Employee;

public class EmployeeMapper {

    public static Employee toEntity(EmployeeRequestDTO dto){

        Employee employee = new Employee();
        employee.setDepartment(dto.getDepartment());
        employee.setName(dto.getName());
        employee.setEmail(dto.getEmail());

        return employee;
    }
    public static EmployeeResponseDTO toResponseDTO(Employee employee){

        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(employee.getId());
        dto.setDepartment(employee.getDepartment());
        dto.setEmail(employee.getEmail());
        dto.setName(employee.getName());

        return dto;
    }
}
