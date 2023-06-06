package com.cuddly.engine.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import com.cuddly.engine.entities.Employee;

@SpringBootApplication
@EntityScan( basePackages = {"com.cuddly.engine.entities"} )
public class DemoApplication implements CommandLineRunner{

	@Autowired
	private EmployeeDao employeeDao;
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		Employee employee = getEmployee();
		employeeDao.createEmployee(employee);
		employeeDao.readEmployee(employee);
		employee.setSalary(9000.0);
		employeeDao.updateEmployee(employee);
		employeeDao.deleteEmployee(employee);
	}
	private Employee getEmployee() {
		Employee employee= new  Employee();
		employee.setName("Sam Chatterjee");
		employee.setSalary(80000.00);
		employee.setDoj(new Date());
		return employee;
	}
}