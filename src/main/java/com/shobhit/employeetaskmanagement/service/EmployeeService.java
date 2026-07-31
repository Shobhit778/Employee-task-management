package com.shobhit.employeetaskmanagement.service;

import com.shobhit.employeetaskmanagement.dto.EmployeeRequestDTO;
import com.shobhit.employeetaskmanagement.dto.EmployeeResponseDTO;
import com.shobhit.employeetaskmanagement.entity.Employee;
import com.shobhit.employeetaskmanagement.exception.DuplicateResourceException;
import com.shobhit.employeetaskmanagement.exception.ResourceNotFoundException;
import com.shobhit.employeetaskmanagement.mapper.EmployeeMapper;
import com.shobhit.employeetaskmanagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponseDTO saveEmployee(EmployeeRequestDTO employeeRequestDTO){

        if(employeeRepository.existsByEmail(employeeRequestDTO.getEmail())){
            throw new DuplicateResourceException("Employee with this Email already exists ");
        }
        Employee employee = EmployeeMapper.toEntity(employeeRequestDTO);
        employeeRepository.save(employee);
         return EmployeeMapper.toResponseDTO(employee);
    }

    public List<EmployeeResponseDTO> getAllEmployee(){
        List<Employee> employees = employeeRepository.findAll();
        List<EmployeeResponseDTO> response = new ArrayList<>();

        for(Employee employee : employees){
            response.add(EmployeeMapper.toResponseDTO(employee));
        }
         return response;
    }

    private Employee findEmployeeById(Long id){
        Optional<Employee> employee = employeeRepository.findById(id);
        if(employee.isPresent()){
            return employee.get();
        }
        throw new ResourceNotFoundException("Employee not found with id " + id);
    }

    public EmployeeResponseDTO getEmployeeById(Long id){
       Employee employee = findEmployeeById(id);

       return EmployeeMapper.toResponseDTO(employee);
    }

    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO dto){

        Employee existingEmployee = findEmployeeById(id);
        if(!existingEmployee.getEmail().equals(dto.getEmail()) && employeeRepository.existsByEmail(dto.getEmail())){
            throw new DuplicateResourceException("Employee with this Email already exists ");
        }
        existingEmployee.setName(dto.getName());
        existingEmployee.setEmail(dto.getEmail());
        existingEmployee.setDepartment(dto.getDepartment());
        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return EmployeeMapper.toResponseDTO(updatedEmployee);
    }

    public String deleteEmployee(Long id){
        Employee employee = findEmployeeById(id);
        employeeRepository.delete(employee);
        return "Employee deleted successfully";
    }
}
