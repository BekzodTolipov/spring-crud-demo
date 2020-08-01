package com.bek.spring.crud.demo.employeecruddemo.dao;

import com.bek.spring.crud.demo.employeecruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    // define field for entitymanager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeeDAOHibernateImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery =
                currentSession.createQuery("FROM Employee", Employee.class);

        // execute query and get result list
        List<Employee> employees = theQuery.getResultList();

        // return the results
        return employees;

    }

    @Override
    public Employee findById(int theId) {

        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery =
                currentSession.createQuery("FROM Employee WHERE id=" + theId, Employee.class);
            // OR
        /*
        Employee theEmployee = currentSeesion.get(Employee.class, theId);
         */


        // execute query and get an employee
        Employee employee = theQuery.getSingleResult();

        // return the results
        return employee;
    }

    @Override
    public void saveEmployee(Employee theEmployee) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save
        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteEmployeeById(int theId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employee> theQuery =
                currentSession.createQuery("DELETE FROM Employee WHERE id=:employeeId");
        theQuery.setParameter("employeeId", theId);

        theQuery.executeUpdate();
    }

}
