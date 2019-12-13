//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.HashMap; 
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.model.Employee;
import edu.csumb.Webstore.model.Inventory;

import edu.csumb.Webstore.service.InventoryService;
import edu.csumb.Webstore.service.EmployeeService;

import edu.csumb.Webstore.repositories.UserRepository;

//Remember to annotate what type of class this is!
@Service
public class UserService
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    InventoryService inventoryService;

    public User add(User p)
    {
        return userRepository.insert(p);
    }
    public void remove(String ID)
    {
        userRepository.deleteById(ID);
    }
    public List<User> getAll()
    {
        return userRepository.findAll();
    }
    public List<User> getUsers(String username)
    {
        List<User> users = userRepository.findAll();
        List<User> ret = new ArrayList<User>();
        for(int i=0;i< users.size();i++)
        {
            if(users.get(i).getName().equals(username))
            {
                ret.add(users.get(i));
            }
        }
        return ret;
    }
    public User getUser(String id)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            return u;
        }
        return null;
    }
    public String authenticate(String username,String password)
    {
        List<User> users = userRepository.findAll();
        for(int i=0;i< users.size();i++)
        {
            if(users.get(i).getName().equals(username))
            {
                if(users.get(i).getPassword().equals(password))
                {
                    return "Logged in.";
                }
                else{
                    return "Invalid Username or password.";
                }
            }
        }
        return "Username does not exist.";
    }
    
    public Employee addEmployee(String id, Employee e)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            HashMap<String, Employee> map = u.getemployeeMap();
            Employee adder = employeeService.add(e);
            map.put(adder.getID(),adder);
            userRepository.save(u);
            return adder;
        }
        return null;
    }
    public Inventory addInventory(String id, Inventory i)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            HashMap<String, Inventory> map = u.getInventoryMap();
            Inventory adder = inventoryService.add(i);
            map.put(adder.getID(),adder);
            userRepository.save(u);
            return adder;
        }
        return null;
    }
    public void removeEmployee(String id, String employeeId)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            HashMap<String, Employee> map = u.getemployeeMap();
            employeeService.remove(employeeId);
            map.remove(employeeId);
            userRepository.save(u);
        }
    }
    public void changeName(String id, String name)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            u.setName(name);
            userRepository.save(u);
        }
    }
    public String getName(String id)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            return u.getName();
        }
        return null;
    }
    public void changePass(String id, String pass)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            u.setPassword(pass);
            userRepository.save(u);
        }
    }
    public String getPass(String id)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            return u.getPassword();
        }
        return null;
    }
    public void changeEmail(String id, String email)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            u.setEmail(email);
            userRepository.save(u);
        }
    }
    public String getEmail(String id)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            return u.getEmail();
        }
        return null;
    }
    public HashMap<String,Employee> getEmployees(String id)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            return u.getemployeeMap();
        }
        return null;
    }
    public HashMap<String,Inventory> getInventory(String id)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            return u.getInventoryMap();
        }
        return null;
    }
    public void removeInventory(String id, String inventoryId)
    {
        if(userRepository.findById(id)!= null)
        {
            User u = userRepository.findById(id).get();
            HashMap<String, Inventory> map = u.getInventoryMap();
            inventoryService.remove(inventoryId);
            map.remove(inventoryId);
            userRepository.save(u);
        }
    }
    
}
