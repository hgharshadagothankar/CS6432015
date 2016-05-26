package org.harshada.doa;

import java.util.List;

import org.harshada.model.Employee;

public interface EmployeeDao {
	
	public void addEmployee(Employee employee);

	 public List<Employee> listEmployeess();
	 
	 public Employee getEmployee(int empid);
	 
	 public void deleteEmployee(Employee employee);


}
