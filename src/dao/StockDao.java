package dao;

import java.io.*;
import java.util.ArrayList;
import models.Product;

public class StockDao {
    private int lastCode;
    private ArrayList<Product> products;

    public StockDao() {
        products = new ArrayList<Product>();
    }
    
    
    public void save() throws FileNotFoundException, IOException{
        var fileOut = new FileOutputStream("Stock.ser");
        var out = new ObjectOutputStream(fileOut);
        out.writeObject(products);
        out.close();
        fileOut.close();
    }
    
    public void load() throws FileNotFoundException, IOException, ClassNotFoundException{
        var fileIn = new FileInputStream("Stock.ser");
        var in = new ObjectInputStream(fileIn);
        products = (ArrayList<Product>) in.readObject();
        in.close();
        fileIn.close();
    }
    
    public Product getProduct(int code){
        return products.stream().filter(p -> code == p.getCode()).findFirst().orElse(null);
    }
    
    public void addNewProduct(Product product){
        lastCode++;
        product.setCode(lastCode);
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
        var product = getProduct(code);
        
        if(product == null)
            return false;
        
        product.remove(amount);
        return true;
    }
    
    public ArrayList<Product> getProducts(){
        return products;
    }
}
