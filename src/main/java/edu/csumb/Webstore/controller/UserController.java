//The controller file determines where someone can access your service.
//The controller shouldn't be doing any logic, and you should NEVER import the database into controller.
//Use the service for any logic, or even one line functions. 99 % of the time, the controller should only have
//the return statement, and nothing else!

package edu.csumb.Webstore.controller;

import java.util.List;
import java.util.Optional;
import java.util.HashMap; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.model.Inventory;
import edu.csumb.Webstore.model.Employee;
import edu.csumb.Webstore.service.UserService;
import io.swagger.annotations.ApiOperation;
@RestController
public class UserController
{
    //This is autowiring(Telling spring to just connect to the dang service automatically) for us.
    @Autowired
    UserService userService;

    //REQUESTMAPPING
    //We are setting a request mapping with request type GET. You can change these to POST or anything else you want!
    //The value is the location of the api. So this would be HEROKU/products/example

    //APIOPERATION
    //This is comments that will be displayed in swagger. Remember to do this or you will lose points!
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/users/add")
    @ApiOperation(value = "Adds a user to the database." )
    public User add(@RequestBody User p)
    {
        
        return userService.add(p);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/users/addEmployee/{id}")
    @ApiOperation(value = "Adds an employee to a user." )
    public Employee addEmployee(@RequestParam String id, @RequestBody Employee e)
    {
        
        return userService.addEmployee(id,e);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/users/addInventory")
    @ApiOperation(value = "Adds a Inventory object to a user." )
    public Inventory addInventory(@RequestParam String id, @RequestBody Inventory i)
    {
        
        return userService.addInventory(id,i);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/users/remove/{id}")
    @ApiOperation(value = "Removes a user from the database." )
    public void remove(@RequestParam String id)
    {
        
        userService.remove(id);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/users/removeEmployee/{userID}{employeeID}")
    @ApiOperation(value = "Removes a employee from the user." )
    public void removeEmployee(@RequestParam String userID,@RequestParam String employeeID)
    {
        
        userService.removeEmployee(userID,employeeID);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/users/removeInventory/{userID}{inventoryID}")
    @ApiOperation(value = "Removes an inventory object from the user." )
    public void removeInventory(@RequestParam String userID,@RequestParam String inventoryID)
    {
        
        userService.removeInventory(userID,inventoryID);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/users/authenticate/{username}{password}")
    @ApiOperation(value = "Authenticates a user." )
    public String authenticate(@RequestParam String username,@RequestParam String password)
    {
        
        return userService.authenticate(username,password);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/users/getAll")
    @ApiOperation(value = "Gets all the users in a database." )
    public List<User> getAll()
    {
        
        return userService.getAll();
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/users/getUsers/{name}")
    @ApiOperation(value = "Gets all the users in a with the given name." )
    public List<User> getUsers(@RequestParam String name)
    {
        
        return userService.getUsers(name);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/users/getUser/{id}")
    @ApiOperation(value = "Gets one user with given ID." )
    public User getUser(@RequestParam String id)
    {
        return userService.getUser(id);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/users/getName/{ID}")
    @ApiOperation(value = "Gets the name of a user a with given ID." )
    public String getName(@RequestParam String ID)
    {
        return userService.getName(ID);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/users/changeName/{id}{name}")
    @ApiOperation(value = "Changes the name of a User." )
    public void changeName(@RequestParam String id,@RequestParam String name)
    {
        userService.changeName(id,name);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/users/getPass/{ID}")
    @ApiOperation(value = "Gets the password of a user a with given ID." )
    public String getPass(@RequestParam String ID)
    {
        return userService.getPass(ID);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/users/changePassword/{id}{pass}")
    @ApiOperation(value = "Changes the password of a User." )
    public void changePass(@RequestParam String id,@RequestParam String pass)
    {
        userService.changePass(id,pass);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/users/getEmail/{ID}")
    @ApiOperation(value = "Gets the Email a with given ID." )
    public String getEmail(@RequestParam String ID)
    {
        return userService.getEmail(ID);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, value = "/users/changeEmail/{id}{email}")
    @ApiOperation(value = "Changes the Email of a User." )
    public void changeEmail(@RequestParam String id,@RequestParam String email)
    {
        userService.changeEmail(id,email);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/users/getEmployees/{id}")
    @ApiOperation(value = "Gets all the employees from a user." )
    public HashMap<String,Employee> getEmployees(@RequestParam String id)
    {
        return userService.getEmployees(id);
    }
    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.GET, value = "/users/getInventory/{ID}")
    @ApiOperation(value = "Gets all the inventory from a user." )
    public HashMap<String,Inventory> getInventory(@RequestParam String ID)
    {
        return userService.getInventory(ID);
    }
}