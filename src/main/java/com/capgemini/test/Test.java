package com.capgemini.test;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capgemini.model.Address;
import com.capgemini.model.Company;
import com.capgemini.model.Employee;
import com.capgemini.repo.CompanyRepository;
import com.capgemini.repo.EmployeeRepositroy;

@Component
public class Test {

	@Autowired
	private EmployeeRepositroy employeeRepositroy;
	@Autowired
	private CompanyRepository companyRepository;

	public void saveEmployee(Employee emp) {
		Address address = new Address();
		address.setAddressId("address1");
		address.setState("Karnataka");
		address.setPincode("502652");
		
		Address address1 = new Address();
		address1.setAddressId("address2");
		address1.setState("Karnataka");
		address1.setPincode("502652");
		emp.setJoiningDate(new Date());
		emp.setEmployeeId("employee1");
		emp.setEmployeeName("Sukku");
		emp.setEmployeeEmail("Mail@gmail.com");
		emp.setAddress(Arrays.asList(address,address1));
		Company company = new Company();
		company.setCompanyId("company1");
		company.setCompanyName("Capgemini");
		emp.setCompany(company);
		company.setEmployee(Arrays.asList(emp));
		companyRepository.save(company);
	}

	
	public Object[] getEmployee() {
		System.out.println("3" + employeeRepositroy.findByAddressAddressIdOrEmployeeId("address1", "employee1").getAddress());
		return employeeRepositroy.findByEmployeeName("Sukku");
	}

	public Employee getEmpoyee1() {
		System.out.println("1" + employeeRepositroy
				.findByEmployeeIdAndEmployeeNameAndEmployeeEmail("employee1", "Sukku", "Mail@gmail.com").getAddress());
		System.out.println("Company output "+companyRepository.findByCompanyName("Capgemini").getEmployee());//getEmployee because in toString method of Company you cant print employee details looping happens
		System.out.println("2" + employeeRepositroy.findByEmployeeEmail("Mail@gmail.com")[0]);
		return employeeRepositroy.findByEmployeeIdAndEmployeeName("employee1", "Sukku");
	}

	public void getComapny() {
		//System.out.println("Custom company Query "+companyRepository.findByAddressId("address1"));
		System.out.println("Comapny with address"+companyRepository.findByEmployeeAddressAddressId("address2"));
	}
}
