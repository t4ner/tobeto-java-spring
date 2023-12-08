package com.tobeto.homework.controllers;

import com.tobeto.homework.entities.Employee;
import com.tobeto.homework.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employees")
public class EmployeesController {
    private final EmployeeRepository employeeRepository;
    public EmployeesController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }
    @GetMapping
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("{id}")
    public Employee getById(@PathVariable int id){
        //Optionel<T> =>ilgili filtreden bir veri dönmeyebilir.
        return employeeRepository.findById(id).orElseThrow();
    }
    @PostMapping
    public void add(@RequestBody Employee employee){employeeRepository.save(employee);}

    @PutMapping
    public void update(@RequestBody Employee employee){
        Employee employeeToUpdate = employeeRepository.findById(employee.getId()).orElseThrow();
        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeRepository.save(employeeToUpdate);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable int id){employeeRepository.deleteById(id);
    }
}
