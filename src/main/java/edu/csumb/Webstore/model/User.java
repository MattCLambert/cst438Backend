//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import org.springframework.data.annotation.Id;
import java.util.HashMap; 
import java.util.Map;

import edu.csumb.Webstore.model.Inventory;
import edu.csumb.Webstore.model.Employee;
import io.swagger.annotations.ApiModelProperty;
public class User
{
    private String name;
    private String password;
    @ApiModelProperty(hidden = true, required = false)
    @Id
    private String id;
    @ApiModelProperty(required = false)
    private  HashMap<String, Employee> employeeMap;
    @ApiModelProperty(required = false)
    private  HashMap<String, Inventory> inventoryMap;

    public User()
    {
        name = "";
        password = "";
        employeeMap = new HashMap<String, Employee>();
        inventoryMap = new HashMap<String, Inventory>();
    }
    public User(String name,String password)
    {
        this.name = name;
        this.password = password;
        employeeMap = new HashMap<>();
        
    }
    public String authenticate(String password){
        if(this.password.equals(password))
        {
            return "Logged in";
        }
        return "Wrong Username or Password";
    }
    public String getName(){
        return name;
    }
    public String getPassword(){
        return password;
    }
    public String getID(){
        return id;
    }
    public HashMap<String, Employee> getemployeeMap(){
        return employeeMap;
    }
    public HashMap<String, Inventory> getInventoryMap(){
        return inventoryMap;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setEmployeeMap(HashMap<String, Employee> employeeMap){
        this.employeeMap = employeeMap;
    }
    public void setInventoryMap(HashMap<String, Inventory> inventoryMap){
        this.inventoryMap = inventoryMap;
    }
}