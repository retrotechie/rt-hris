package com.retrotechie.rthris.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Indicate this class is a data repository that will contain CRUD operations
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
