//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import org.springframework.data.annotation.Id;
import java.util.HashMap; 
import java.util.Map;

import io.swagger.annotations.ApiModelProperty;
public class Employee
{
    private String name;
    private Double salary;
    @ApiModelProperty(hidden = true, required = false)
    @Id
    private String id;
    
    public Employee()
    {
        name = "";
        salary = 0.0;
        
    }
    public Employee(String name,Double salary)
    {
        this.name = name;
        this.salary = salary;
    }
    public Double getSalary(){
        return salary;
    }
    public String getName(){
        return name;
    }
    public String getID(){
        return id;
    }
    public void setSalary(Double salary){
        this.salary = salary;
    }
    public void setName(String name){
        this.name = name;
    }
}