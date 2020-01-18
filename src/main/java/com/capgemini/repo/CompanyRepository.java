package com.capgemini.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.model.Company;

public interface CompanyRepository extends JpaRepository<Company, String>{

	Company  findByCompanyName(String companyName);
	
	Company findByEmployeeAddressAddressId(String addressId);

	/*
	 * @Query("SELECT com FROM Company com, Employee emp, Address addr WHERE" +
	 * " com.id = emp.company and " +
	 * "emp.address = addr.addressId and addr.addressId=?1") Company
	 * findByAddressId(String addressId);
	 */
}
