package models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Transaction implements Serializable{
    private int code;
    private final Product product;
    private float totalValue;
    private String dealerIdentity;
    private String dealerPhoneNumber;
    private PaymentMethod paymentMethod;
    private LocalDateTime dateTime;
    private TransactionType type;
    
    public enum TransactionType { venda, compra};
    public enum PaymentMethod { boleto, cartaodecredito, aVista}; 

    public Transaction(Product product, float totalValue, String dealerIdentity, String dealerPhoneNumber, PaymentMethod paymentMethod, LocalDateTime dateTime, TransactionType type) {
        this.product = product;
        this.totalValue = totalValue;
        this.dealerIdentity = dealerIdentity;
        this.dealerPhoneNumber = dealerPhoneNumber;
        this.paymentMethod = paymentMethod;
        this.dateTime = dateTime;
        this.type = type;
    }

    public int getCode() {
        return code;
    }
    
    public void setCode(int code){
        this.code = code;
    }

    public Product getProducts() {
        return product;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(float totalValue) {
        this.totalValue = totalValue;
    }

    public String getDealerIdentity() {
        return dealerIdentity;
    }

    public void setDealerIdentity(String dealer) {
        this.dealerIdentity = dealer;
    }

    public String getDealerPhoneNumber() {
        return dealerPhoneNumber;
    }

    public void setDealerPhoneNumber(String phoneNumber) {
        this.dealerPhoneNumber = phoneNumber;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }
}
