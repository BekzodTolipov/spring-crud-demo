package com.bek.spring.crud.demo.employeecruddemo.service;

import com.bek.spring.crud.demo.employeecruddemo.dao.EmployeeDAO;
import com.bek.spring.crud.demo.employeecruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO theEmployeeDAO){
        employeeDAO = theEmployeeDAO;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    @Transactional
    public void saveEmpl(Employee theEmployee) {
        employeeDAO.saveEmployee(theEmployee);
    }

    @Override
    @Transactional
    public void deleteEmplById(int theId) {
        employeeDAO.deleteEmployeeById(theId);
    }
}
