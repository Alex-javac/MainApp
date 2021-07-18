package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;

import java.util.List;

public interface Dao {
    boolean addEmployee(Employee employee);
    boolean update(Employee employee);
    void deleteEmployee(long id);
    Employee getEmployeeById(long id);
    List<Employee> getAllEmployees();
    List<Employee> getEmployeesByLastName(String lastName);
    List<Employee> getEmployeesByGender(Gender gender);
    List<Employee> getEmployeesByDepartment(String department);
    List<Employee> getEmployeesByJobTitle(String jobTitle);
}
