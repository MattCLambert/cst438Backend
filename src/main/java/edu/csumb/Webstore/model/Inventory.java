//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import org.springframework.data.annotation.Id;

import io.swagger.annotations.ApiModelProperty;
public class Inventory
{
    private String name;
    @ApiModelProperty(hidden = true, required = false)
    @Id
    private String id;
    private String description;
    private String imageURL;
    private Double price;
    private Integer stock;

    public Inventory()
    {
        name = "";
        description = "";
        imageURL = "";
        price = 0.0;
        stock = 0;
    }
    public Inventory(String name,String description,String imageURL,Double price,Integer stock)
    {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.stock = stock;
    }
    public String getName(){
        return name;
    }
    public String getID(){
        return id;
    }
    public String getDescription(){
        return description;
    }
    public String getImageURL(){
        return imageURL;
    }
    public Double getPrice(){
        return price;
    }
    public Integer getStock(){
        return stock;
    }

    public void setName(String name){
        this.name = name;
    }
    public void setID(String id){
        this.id = id;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public void setStock(Integer stock){
        this.stock = stock;
    }
}