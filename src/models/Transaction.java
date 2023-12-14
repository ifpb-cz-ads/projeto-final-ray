package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaction implements Serializable{
    private int code;
    private final ArrayList<Product> products;
    private float totalValue;
    private float taxes;
    private String paymentMethod;
    private LocalDateTime dateTime;
    private boolean isPayed = false;

    public Transaction(ArrayList<Product> products, float totalValue, String paymentMethod, LocalDateTime dateTime) {
        this.products = products;
        this.totalValue = totalValue;
        this.paymentMethod = paymentMethod;
        this.dateTime = dateTime;
    }

    public int getCode() {
        return code;
    }
    
    public void setCode(int code){
        this.code = code;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setTaxes(float taxes) {
        this.taxes = taxes;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public boolean isIsPayed() {
        return isPayed;
    }

    public void setIsPayed(boolean isPayed) {
        this.isPayed = isPayed;
    }
}
