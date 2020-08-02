package com.bek.spring.crud.demo.employeecruddemo.service;

import com.bek.spring.crud.demo.employeecruddemo.dao.EmployeeDAO;
import com.bek.spring.crud.demo.employeecruddemo.dao.EmployeeRepository;
import com.bek.spring.crud.demo.employeecruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

//    private EmployeeDAO employeeDAO;
//
//    @Autowired
//    public EmployeeServiceImpl(@Qualifier("employeeDAOHibernateImpl") EmployeeDAO theEmployeeDAO){
//        employeeDAO = theEmployeeDAO;
//    }
//    private EmployeeDAO employeeDAO;
//
//    @Autowired
//    public EmployeeServiceImpl(@Qualifier("employeeDAOJpaImpl") EmployeeDAO theEmployeeDAO){
//        employeeDAO = theEmployeeDAO;
//    }

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository theEmployeeRepository){
        employeeRepository = theEmployeeRepository;
    }

    @Override
//    @Transactional  // Spring JPA auto provides it, no need for it
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
//    @Transactional
    public Employee findById(int theId) {
        Optional<Employee> result = employeeRepository.findById(theId);

        Employee theEmployee = null;
        if(result.isPresent()){
            theEmployee = result.get();
        }
        else{
            // we did not find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }
        return theEmployee;
    }

    @Override
//    @Transactional
    public void saveEmpl(Employee theEmployee) {
        employeeRepository.save(theEmployee);
    }

    @Override
//    @Transactional
    public void deleteEmplById(int theId) {
        employeeRepository.deleteById(theId);
    }
}
