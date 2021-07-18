package com.mastery.java.task.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;


@Getter
@Setter
@ToString
public class Employee {
    private Long employeeId;
    private String firstName;
    private String lastName;
    private String department;
    private String jobTitle;
    private Gender gender;
    private Date dateOfBirth;
}
