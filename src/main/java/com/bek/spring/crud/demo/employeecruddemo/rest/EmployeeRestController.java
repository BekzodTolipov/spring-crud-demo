package com.bek.spring.crud.demo.employeecruddemo.rest;

import com.bek.spring.crud.demo.employeecruddemo.dao.EmployeeDAO;
import com.bek.spring.crud.demo.employeecruddemo.entity.Employee;
import com.bek.spring.crud.demo.employeecruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    // quick and dirty: inject employee dao (use constructor injection)
    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService){
        employeeService = theEmployeeService;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    // expose "/employee/:id" and return an employee matching ID
    @GetMapping("/employee/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        return theEmployee;
    }

    // expose "/employee and save the employee passed thru body
    @PostMapping("employee")
    public Employee saveEmployee(@RequestBody Employee theEmployee){

        // also jst in case they pass an id in JSON .. set id to 0
        // this is to force a save of new item ... instead of update

        theEmployee.setId(0);

        employeeService.saveEmpl(theEmployee);

        return theEmployee;
    }

    // expose "/employee" and update the employee
    @PutMapping("/employee")
    public Employee updateAnEmployee(@RequestBody Employee theEmployee){
        employeeService.saveEmpl(theEmployee);

        return theEmployee;
    }

    // expose "/employee/{employeeId}" and delete the employee by id
    @DeleteMapping("/employee/{employeeId}")
    public String deleteEmployeeById(@PathVariable int employeeId){

        Employee theEmployee = employeeService.findById(employeeId);

        if(theEmployee == null){
            throw new RuntimeException("Employee id not found - " + employeeId);
        }

        employeeService.deleteEmplById(employeeId);

        return "Deleted employee id - " + employeeId;

    }
}
