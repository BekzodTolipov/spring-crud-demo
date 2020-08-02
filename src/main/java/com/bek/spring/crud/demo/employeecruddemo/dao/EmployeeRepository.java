package com.bek.spring.crud.demo.employeecruddemo.dao;

import com.bek.spring.crud.demo.employeecruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {



}
