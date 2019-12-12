//The service file is where the heavy lifting is done.
//You will do all logic, all database access(Special database operations defined in the repository).
//Basically all your actual code is here!
package edu.csumb.Webstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.csumb.Webstore.model.Inventory;
import edu.csumb.Webstore.repositories.InventoryRepository;

//Remember to annotate what type of class this is!
@Service
public class InventoryService
{
    @Autowired
    InventoryRepository inventoryRepository;
    public Inventory add(Inventory i)
    {
        return inventoryRepository.insert(i);
    }
    public void remove(String ID)
    {
        inventoryRepository.deleteById(ID);
    }
    public void changePrice(String ID, Double price)
    {
        Optional<Inventory> i = inventoryRepository.findById(ID);
        if(i != null)
        {
            Inventory temp = i.get();
            temp.setPrice(price);
            inventoryRepository.save(temp);

        }
    }
    public void changeStock(String ID, Integer stock)
    {
        Optional<Inventory> i = inventoryRepository.findById(ID);
        if(i != null)
        {
            Inventory temp = i.get();
            temp.setStock(stock);
            inventoryRepository.save(temp);

        }
    }
    public void changeName(String ID, String name)
    {
        Optional<Inventory> i = inventoryRepository.findById(ID);
        if(i != null)
        {
            Inventory temp = i.get();
            temp.setName(name);
            inventoryRepository.save(temp);

        }
    }
    public void changeDescription(String ID, String description)
    {
        Optional<Inventory> i = inventoryRepository.findById(ID);
        if(i != null)
        {
            Inventory temp = i.get();
            temp.setName(description);
            inventoryRepository.save(temp);
        }
    }
    public void changeImage(String ID, String imageUrl)
    {
        Optional<Inventory> i = inventoryRepository.findById(ID);
        if(i != null)
        {
            Inventory temp = i.get();
            temp.setImageURL(imageUrl);
            inventoryRepository.save(temp);
        }
    }
    public List<Inventory> getAll()
    {
        return inventoryRepository.findAll();
    }
    
}
