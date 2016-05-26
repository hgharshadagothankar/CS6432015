package org.harshada.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.transaction.annotation.Propagation;

import org.harshada.doa.EmployeeDao;
import org.harshada.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("employeeService")
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

 @Autowired
 private EmployeeDao employeeDao;
 
 //@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
 public void addEmployee(Employee employee) {
  employeeDao.addEmployee(employee);
 }
 
 public List<Employee> listEmployeess() {
  return employeeDao.listEmployeess();
 }

 public Employee getEmployee(int empid) {
  return employeeDao.getEmployee(empid);
 }
 
 public void deleteEmployee(Employee employee) {
  employeeDao.deleteEmployee(employee);
 }


}
