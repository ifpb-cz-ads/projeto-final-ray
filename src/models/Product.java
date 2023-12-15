package models;

import java.io.Serializable;

public class Product implements Serializable{
    private int code = 0;
    private String name;
    private float price;
    private String description;
    private int amount = 0;
    
    public Product(Product product){
        this.code = product.code;
        this.name = product.name;
        this.price = product.price;
        this.description = product.description;
        this.amount = product.amount;
    }
    
    public Product(String name, float price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }
    
    public void add(int amount){
        this.amount += amount;
    }
    
    public void remove(int amount){
        this.amount -= amount;
    }

    public int getCode() {
        return code;
    }
    
    public void setCode(int code) {
        this.code = code;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}