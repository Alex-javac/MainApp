package com.mastery.java.task.dao;

import com.mastery.java.task.dto.Employee;
import com.mastery.java.task.dto.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public class EmployeeDao implements Dao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
 private final String SELECT = "SELECT employee.employee_id, " +
          "employee.first_name, " +
          "employee.last_name, " +
          "employee.department_id," +
          "employee.job_title," +
          "employee.gender," +
          "employee.date_of_birth " +
          "FROM employee ";

    @Override
    public boolean addEmployee(Employee employee) {
        return jdbcTemplate.update("INSERT INTO employee(first_name, last_name, department_id, job_title, gender, date_of_birth) " +
                        "VALUES (?, ?, ?, ?, ?, ?)",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getDepartment(),
                employee.getJobTitle(),
                String.valueOf(employee.getGender()),
                employee.getDateOfBirth()) > 0;
    }

    @Override
    public boolean update(Employee employee) {
        return jdbcTemplate.update("update employee set first_name = ?, " +
                        "last_name = ?, job_title = ?, gender = ?, date_of_birth = ? " +
                        "where employee_id = ?",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle(),
                String.valueOf(employee.getGender()),
                employee.getDateOfBirth(),
                employee.getEmployeeId()) > 0;
    }

    @Override
    public void deleteEmployee(long id) {
        jdbcTemplate.update("DELETE FROM employee WHERE employee_id = ?", id);
    }

    @Override
    public Employee getEmployeeById(long id) {
        return jdbcTemplate.query(SELECT +
                "WHERE employee.employee_id = ?", new BeanPropertyRowMapper<>(Employee.class), id).stream().findAny().orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return jdbcTemplate.query(SELECT, new BeanPropertyRowMapper<>(Employee.class));
    }

    @Override
    public List<Employee> getEmployeesByLastName(String lastName) {
        return jdbcTemplate.query( SELECT +
                "WHERE employee.last_name = ?", new BeanPropertyRowMapper<>(Employee.class), lastName);
    }

    @Override
    public List<Employee> getEmployeesByGender(Gender gender) {
        return jdbcTemplate.query(SELECT +
                "WHERE employee.gender = ?", new BeanPropertyRowMapper<>(Employee.class), String.valueOf(gender));
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
    int num = Integer.parseInt(department);
        return jdbcTemplate.query(SELECT +
                "WHERE employee.department_id = ?", new BeanPropertyRowMapper<>(Employee.class), num);
    }

    @Override
    public List<Employee> getEmployeesByJobTitle(String jobTitle) {
        return jdbcTemplate.query(SELECT +
                "WHERE employee.job_title = ?", new BeanPropertyRowMapper<>(Employee.class), jobTitle);
    }
}
