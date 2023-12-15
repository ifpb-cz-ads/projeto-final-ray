package dao;

import java.io.*;
import java.util.ArrayList;
import models.Product;

public class StockDao implements Serializable{
    private int lastCode;
    private ArrayList<Product> products;

    public StockDao() {
        products = new ArrayList<Product>();
        lastCode = 0;
    }
    
    
    public void save() throws FileNotFoundException, IOException{
        var fileOut = new FileOutputStream("Stock.ser");
        var out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    }
    
    public void load() throws IOException, ClassNotFoundException{
        try{
            var fileIn = new FileInputStream("Stock.ser");
            var in = new ObjectInputStream(fileIn);
            var obj = (StockDao) in.readObject();
            this.products = obj.products;
            this.lastCode = obj.lastCode;
            
            in.close();
            fileIn.close();
        } catch(FileNotFoundException ex){
            
        }
    }
    
    public Product getProduct(int code){
        return products.stream().filter(p -> code == p.getCode()).findFirst().orElse(null);
    }
    
    public void addNewProduct(Product product){
        lastCode++;
        product.setCode(lastCode);
        products.add(product);
    }
    
    public boolean updateProduct(Product product){
        var p = getProduct(product.getCode());
        if(p != null){
            p.setAmount(product.getAmount());
            p.setDescription(product.getDescription());
            p.setName(product.getName());
            p.setPrice(product.getPrice());
            return true;
        }
        return false;
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
