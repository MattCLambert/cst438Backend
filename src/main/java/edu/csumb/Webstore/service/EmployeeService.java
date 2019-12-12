//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Employee;
import edu.csumb.Webstore.repositories.EmployeeRepository;

//Remember to annotate what type of class this is!
@Service
public class EmployeeService
{
    @Autowired
    EmployeeRepository employeeRepository;
    public Employee add(Employee p)
    {
        return employeeRepository.insert(p);
    }
    public void remove(String ID)
    {
        employeeRepository.deleteById(ID);
    }
    public List<Employee> getAll()
    {
        return employeeRepository.findAll();
    }
    
    public void changeSalary(String ID, Double salary)
    {
        Optional<Employee> e = employeeRepository.findById(ID);
        if(e != null)
        {
            Employee temp = e.get();
            temp.setSalary(salary);
            employeeRepository.save(temp);

        }
    }
    public void changeName(String ID, String name)
    {
        Optional<Employee> e = employeeRepository.findById(ID);
        if(e != null)
        {
            Employee temp = e.get();
            temp.setName(name);
            employeeRepository.save(temp);

        }
    }
}
