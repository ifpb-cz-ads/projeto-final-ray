package models;

import java.util.concurrent.atomic.AtomicInteger;

public class Product {
    private static final AtomicInteger count = new AtomicInteger(0); 
    private final int code;
    private String name;
    private float price;
    private String model;
    private String description;
    private int amount = 0;

    public Product(String name, float price, String description) {
        this.code = count.incrementAndGet();
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

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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