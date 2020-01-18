package com.capgemini.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.model.Employee;

public interface EmployeeRepositroy extends JpaRepository<Employee, String> {

	@Query("SELECT EMP.employeeName FROM Employee EMP WHERE EMP.employeeName=?1") // Hql queries
	Object[] findByEmployeeName(String name);

	// Native queries
	Employee findByEmployeeIdAndEmployeeName(String employeeId, String employeeName);

	Employee findByEmployeeIdAndEmployeeNameAndEmployeeEmail(String employeeId, String employeeName, String email);

	Object[] findByEmployeeEmail(String employeeEmail);

	Employee findByAddressAddressIdOrEmployeeId(String id, String id1);

}
