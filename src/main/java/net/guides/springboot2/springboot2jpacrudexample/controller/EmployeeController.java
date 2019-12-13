package net.guides.springboot2.springboot2jpacrudexample.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
import net.guides.springboot2.springboot2jpacrudexample.model.Employee;
import net.guides.springboot2.springboot2jpacrudexample.repository.EmployeeRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeRepository EmployeeRepository;

	@GetMapping("/Employees")
	public List<Employee> getAllEmployees() {
		return EmployeeRepository.findAll();
	}

	@GetMapping("/Employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long EmployeeId)
			throws ResourceNotFoundException {
		Employee Employee = EmployeeRepository.findById(EmployeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + EmployeeId));
		return ResponseEntity.ok().body(Employee);
	}

	@PostMapping("/Employees")
	public Employee createEmployee(@Valid @RequestBody Employee Employee) {
		return EmployeeRepository.save(Employee);
	}

	@PutMapping("/Employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long EmployeeId,
			@Valid @RequestBody Employee EmployeeDetails) throws ResourceNotFoundException {
		Employee Employee = EmployeeRepository.findById(EmployeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + EmployeeId));

		Employee.setEmailId(EmployeeDetails.getEmailId());
		Employee.setLastName(EmployeeDetails.getLastName());
		Employee.setFirstName(EmployeeDetails.getFirstName());
		final Employee updatedEmployee = EmployeeRepository.save(Employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/Employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long EmployeeId)
			throws ResourceNotFoundException {
		Employee Employee = EmployeeRepository.findById(EmployeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + EmployeeId));

		EmployeeRepository.delete(Employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
