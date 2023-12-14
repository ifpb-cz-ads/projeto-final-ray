package models;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Sale extends Transaction{
    private String buyer;
    private String address;
    private String phone;
    private String quarantee;

    public Sale(String buyer, String address, String phone, String quarantee, ArrayList<Product> products, float totalValue, String paymentMethod, LocalDateTime dateTime) {
        super(products, totalValue, paymentMethod, dateTime);
        this.buyer = buyer;
        this.address = address;
        this.phone = phone;
        this.quarantee = quarantee;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
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

    public String getQuarantee() {
        return quarantee;
    }

    public void setQuarantee(String quarantee) {
        this.quarantee = quarantee;
    }
    
    
}
