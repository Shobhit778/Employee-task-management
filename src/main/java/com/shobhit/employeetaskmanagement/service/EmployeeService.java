package com.shobhit.employeetaskmanagement.service;

import com.shobhit.employeetaskmanagement.entity.Employee;
import com.shobhit.employeetaskmanagement.exception.ResourceNotFoundException;
import com.shobhit.employeetaskmanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee){
         return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new ResourceNotFoundException("Employee not found with id" + id);
    }

    public Employee updateEmployee(Long id, Employee employee){
        Employee existingEmployee = getEmployeeById(id);

        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail());
        existingEmployee.setDepartment(employee.getDepartment());

        return employeeRepository.save(existingEmployee);
    }

    public void deleteEmployee(Long id){
        Employee employee = getEmployeeById(id);
        employeeRepository.delete(employee);
    }
}
