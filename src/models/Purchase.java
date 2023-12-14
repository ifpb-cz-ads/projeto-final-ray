package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Purchase extends Transaction{
    private String supplier;
    private String address;
    private String phone;
    private String email;
    
    public Purchase(String supplier, String address, String phone, String email, ArrayList<Product> products, float totalValue, String paymentMethod, LocalDateTime dateTime) {
        super(products, totalValue, paymentMethod, dateTime);
        this.supplier = supplier;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
