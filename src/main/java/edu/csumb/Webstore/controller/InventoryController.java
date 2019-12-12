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

import edu.csumb.Webstore.model.Inventory;
import edu.csumb.Webstore.service.InventoryService;
import io.swagger.annotations.ApiOperation;
@RestController
public class InventoryController
{
    @Autowired
    InventoryService inventoryService;

    //REQUESTMAPPING
    //We are setting a request mapping with request type GET. You can change these to POST or anything else you want!
    //The value is the location of the api. So this would be HEROKU/products/example

    //APIOPERATION
    //This is comments that will be displayed in swagger. Remember to do this or you will lose points!
   
    @RequestMapping(method = RequestMethod.POST, value = "/inventory/changePrice")
    @ApiOperation(value = "Changes the price of Inventory object by ID" )
    public void changePrice(@RequestParam String ID,@RequestParam Double Price)
    {
        inventoryService.changePrice(ID,Price);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/inventory/changeStock")
    @ApiOperation(value = "Changes the Stock of Inventory object by ID" )
    public void changeStock(@RequestParam String ID,@RequestParam Integer Stock)
    {
        inventoryService.changeStock(ID,Stock);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/inventory/add")
    @ApiOperation(value = "Adds a inventory object to the database." )
    public Inventory add(@RequestBody Inventory p)
    {
        return inventoryService.add(p);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/inventory/remove")
    @ApiOperation(value = "Removes a inventory object from the database." )
    public void remove(@RequestParam String p)
    {
        inventoryService.remove(p);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/inventory/changeName")
    @ApiOperation(value = "Changes the name of Inventory object by ID" )
    public void changeName(@RequestParam String ID,@RequestParam String Name)
    {
        inventoryService.changeName(ID,Name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/inventory/changeDescription")
    @ApiOperation(value = "Changes the description of Inventory object by ID" )
    public void changeDescription(@RequestParam String ID,@RequestParam String description)
    {
        inventoryService.changeDescription(ID,description);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/inventory/changeImage")
    @ApiOperation(value = "Changes the Image of Inventory object by ID" )
    public void changeImage(@RequestParam String ID,@RequestParam String imageURL)
    {
        inventoryService.changeImage(ID,imageURL);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/inventory/getAll")
    @ApiOperation(value = "Gets all the inventory objects in a database." )
    public List<Inventory> getAll()
    {
        
        return inventoryService.getAll();
    }
}