package com.shobhit.employeetaskmanagement.repository;

import com.shobhit.employeetaskmanagement.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findByEmployee_Id(Long employeeId);
    List<Task> findByStatus(String status);
}
