package com.bek.spring.crud.demo.employeecruddemo.dao;

import com.bek.spring.crud.demo.employeecruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        Query theQuery =
                entityManager.createQuery("FROM Employee");

        List<Employee> employees = theQuery.getResultList();

        return employees;
    }

    @Override
    public Employee findById(int theId) {



        return null;
    }

    @Override
    public void saveEmployee(Employee theEmployee) {

    }

    @Override
    public void deleteEmployeeById(int theId) {

    }
}
