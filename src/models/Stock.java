package models;

import java.util.ArrayList;

public class Stock {
    private final ArrayList<Product> products;

    public Stock() {
        this.products = new ArrayList<>();
    }
    
    public Product getProduct(int code){
        return products.stream().filter(p -> code == p.getCode()).findFirst().orElse(null);
    }
    
    public void addNewProduct(Product product){
        products.add(product);
    }
    
    public boolean deleteProduct(int code){
        return products.removeIf(p -> p.getCode() == code);
    }
    
    public boolean addProduct(int code, int amount){
        Product product = getProduct(code);
        
        if(product == null)
            return false;
        
        product.add(amount);
        return true;
    }
    
    public boolean removeProduct(int code, int amount){
        Product product = getProduct(code);
        
        if(product == null)
            return false;
        
        product.remove(amount);
        return true;
    }
    
    public ArrayList<Product> getProducts(){
        return products;
    }
}
