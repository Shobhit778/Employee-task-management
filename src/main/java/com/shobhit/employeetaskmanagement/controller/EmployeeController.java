package com.shobhit.employeetaskmanagement.controller;

import com.shobhit.employeetaskmanagement.dto.EmployeeRequestDTO;
import com.shobhit.employeetaskmanagement.dto.EmployeeResponseDTO;
import com.shobhit.employeetaskmanagement.entity.Employee;
import com.shobhit.employeetaskmanagement.service.EmployeeService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeResponseDTO saveEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO){
        return employeeService.saveEmployee(employeeRequestDTO);
    }

    @GetMapping
    public List<EmployeeResponseDTO> getALlEmployees(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable Long id){
    return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(@PathVariable Long id, @RequestBody EmployeeRequestDTO employeeRequestDTO){
        return employeeService.updateEmployee(id, employeeRequestDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployeeById(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }
}
