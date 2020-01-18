package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capgemini.model.Employee;
import com.capgemini.test.Test;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{// Here there is no end point uri/RestController so we use CommandLineRunner

	@Autowired
	Test test;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Hi");
		
	}

	@Override
	public void run(String... args) throws Exception { // unimplemented method
		test.saveEmployee(new Employee());
		
		  System.out.println(test.getEmployee()[0]);
		 System.out.println(test.getEmpoyee1());
		 test.getComapny();
		 
	}

}
