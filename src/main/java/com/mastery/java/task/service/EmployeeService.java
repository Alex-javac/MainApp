package com.mastery.java.task.service;

import com.mastery.java.task.dao.Dao;
import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final Dao dao;

    @Autowired
    public EmployeeService(@Qualifier("employeeDao") Dao dao) {
        this.dao = dao;
    }

    public boolean addEmployee(Employee employee) {
        return dao.addEmployee(employee);
    }

    public boolean update(Employee employee) {
        return dao.update(employee);
    }

    public void deleteEmployee(long id) {
        dao.deleteEmployee(id);
    }

    public Employee getEmployeeById(long id) {
        return dao.getEmployeeById(id);
    }

    public List<Employee> getAllEmployees() {
        return dao.getAllEmployees();
    }

    public List<Employee> getEmployeesByLastName(String lastName) {
        return dao.getEmployeesByLastName(lastName);
    }

    public List<Employee> getEmployeesByGender(Gender gender) {
        return dao.getEmployeesByGender(gender);
    }

    public List<Employee> getEmployeesByDepartment(String department) {
        return dao.getEmployeesByDepartment(department);
    }

    public List<Employee> getEmployeesByJobTitle(String jobTitle) {
        return dao.getEmployeesByJobTitle(jobTitle);
    }
}
