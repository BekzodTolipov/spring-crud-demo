package com.bek.spring.crud.demo.employeecruddemo.dao;

import com.bek.spring.crud.demo.employeecruddemo.entity.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface EmployeeDAO {

    public List<Employee> findAll();

    public Employee findById(int theId);

    public void saveEmployee(Employee theEmployee);

    public void deleteEmployeeById(int theId);
}
