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
    private String email;
    @ApiModelProperty(hidden = true, required = false)
    @Id
    private String id;
    @ApiModelProperty(required = false)
    private  HashMap<String, Employee> employeeMap;
    @ApiModelProperty(required = false)
    private  HashMap<String, Inventory> inventoryMap;
    @ApiModelProperty(hidden = true, required = false)
    private boolean isAdmin;
    public User()
    {
        name = "";
        password = "";
        email = "";
        employeeMap = new HashMap<String, Employee>();
        inventoryMap = new HashMap<String, Inventory>();
        isAdmin = false;
    }
    public User(String name,String password,String email)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        employeeMap = new HashMap<String, Employee>();
        inventoryMap = new HashMap<String, Inventory>();
        isAdmin = false;
        
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
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
    public String getID(){
        return id;
    }
    public Boolean getAdmin(){
        return isAdmin;
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
    public void setAdmin(Boolean admin){
        this.isAdmin = admin;
    }
    public void setEmail(String email){
        this.email = email;
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