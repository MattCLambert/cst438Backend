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
    @RequestMapping(method = RequestMethod.POST, value = "/users/add")
    @ApiOperation(value = "Adds a user to the database." )
    public User add(@RequestBody User p)
    {
        
        return userService.add(p);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/users/addEmployee")
    @ApiOperation(value = "Adds an employee to a user." )
    public Employee addEmployee(@RequestParam String id, @RequestBody Employee e)
    {
        
        return userService.addEmployee(id,e);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users/addInventory")
    @ApiOperation(value = "Adds a Inventory object to a user." )
    public Inventory addInventory(@RequestParam String id, @RequestBody Inventory i)
    {
        
        return userService.addInventory(id,i);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users/remove")
    @ApiOperation(value = "Removes a user from the database." )
    public void remove(@RequestParam String p)
    {
        
        userService.remove(p);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users/removeEmployee")
    @ApiOperation(value = "Removes a employee from the user." )
    public void removeEmployee(@RequestParam String p,@RequestParam String p2)
    {
        
        userService.removeEmployee(p,p2);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users/removeInventory")
    @ApiOperation(value = "Removes an inventory object from the user." )
    public void removeInventory(@RequestParam String p,@RequestParam String p2)
    {
        
        userService.removeInventory(p,p2);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/users/authenticate")
    @ApiOperation(value = "Authenticates a user." )
    public String authenticate(@RequestParam String username,@RequestParam String password)
    {
        
        return userService.authenticate(username,password);
    }
    @RequestMapping(method = RequestMethod.GET, value = "/users/getAll")
    @ApiOperation(value = "Gets all the users in a database." )
    public List<User> getAll()
    {
        
        return userService.getAll();
    }

    
}