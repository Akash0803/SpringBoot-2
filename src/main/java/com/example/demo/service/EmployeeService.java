package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.AddressRepo;
import com.example.demo.dao.EmployeeRepo;
import com.example.demo.model.Address;
import com.example.demo.model.Employee;
import com.example.demo.vm.EmployeeAddressVM;




@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	@Autowired
	private AddressRepo addressRepo;
	
	public List<Employee> getEmployees(){
		List<Employee> employees=employeeRepo.findAll();
		return employees;
	}
	
	public EmployeeAddressVM save(EmployeeAddressVM employeeAdreessVM) {
		Employee employee=employeeAdreessVM.getEmployee();
		employeeRepo.save(employee);
		for(Address address : employeeAdreessVM.getAddress()) {
			address.setEmployee(employee);
			addressRepo.save(address);
		}
		return employeeAdreessVM;
	}
}
