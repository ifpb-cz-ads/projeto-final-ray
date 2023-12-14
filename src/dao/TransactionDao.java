package dao;

import java.io.*;
import java.util.ArrayList;
import models.Transaction;

public class TransactionDao {
    private int lastCode = 0;
    private ArrayList<Transaction> transactions;

    public TransactionDao() {
        this.transactions = new ArrayList<Transaction>();
    }
    
    public void save() throws FileNotFoundException, IOException{
        var fileOut = new FileOutputStream("Transactions.ser");
        var out = new ObjectOutputStream(fileOut);
        out.writeObject(transactions);
        out.close();
        fileOut.close();
    }
    
    public void load() throws FileNotFoundException, IOException, ClassNotFoundException{
        var fileIn = new FileInputStream("Transactions.ser");
        var in = new ObjectInputStream(fileIn);
        transactions = (ArrayList<Transaction>) in.readObject();
        in.close();
        fileIn.close();
    }
    
    public void addTransaction(Transaction transaction){
        lastCode++;
        transaction.setCode(lastCode);
        transactions.add(transaction);
    }
    
    public Transaction getTransaction(int code){
        return transactions.stream().filter(t -> code == t.getCode()).findFirst().orElse(null);
    }
    
    public boolean deleteTransaction(int code){
        return transactions.removeIf(p -> p.getCode() == code);
    }
    
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions) {
        this.transactions = transactions;
    }
}
