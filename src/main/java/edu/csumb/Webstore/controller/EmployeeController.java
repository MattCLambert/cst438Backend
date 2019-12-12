//The controller file determines where someone can access your service.
//The controller shouldn't be doing any logic, and you should NEVER import the database into controller.
//Use the service for any logic, or even one line functions. 99 % of the time, the controller should only have
//the return statement, and nothing else!

package edu.csumb.Webstore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import edu.csumb.Webstore.model.Employee;
import edu.csumb.Webstore.service.EmployeeService;
import io.swagger.annotations.ApiOperation;
@RestController
public class EmployeeController
{

    @Autowired
    EmployeeService employeeService;

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/employee/add")
    @ApiOperation(value = "Adds an Employee to the database." )
    public Employee add(@RequestBody Employee p)
    {
        return employeeService.add(p);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/employee/remove")
    @ApiOperation(value = "Removes an Employee from the database." )
    public void remove(@RequestParam String p)
    {
        employeeService.remove(p);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/employee/changeName")
    @ApiOperation(value = "Changes the name of an Employee by ID" )
    public void changeName(@RequestParam String ID,@RequestParam String Name)
    {
        employeeService.changeName(ID,Name);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/inventory/changeSalary")
    @ApiOperation(value = "Changes the Salary of Inventory object by ID" )
    public void changeSalary(@RequestParam String ID,@RequestParam Double Salary)
    {
        employeeService.changeSalary(ID,Salary);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/employee/getAll")
    @ApiOperation(value = "Gets all the Employees in the database." )
    public List<Employee> getAll()
    {
        
        return employeeService.getAll();
    }
}