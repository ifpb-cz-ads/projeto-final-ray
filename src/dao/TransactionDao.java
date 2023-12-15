package dao;

import java.io.*;
import java.util.ArrayList;
import models.Transaction;

public class TransactionDao implements Serializable{
    private int lastCode;
    private ArrayList<Transaction> transactions;

    public TransactionDao() {
        this.transactions = new ArrayList<Transaction>();
        this.lastCode = 0;
    }
    
    public void save() throws FileNotFoundException, IOException{
        var fileOut = new FileOutputStream("Transactions.ser");
        var out = new ObjectOutputStream(fileOut);
        out.writeObject(this);
        out.close();
        fileOut.close();
    }
    
    public void load() throws IOException, ClassNotFoundException{
        try{
            var fileIn = new FileInputStream("Transactions.ser");
            var in = new ObjectInputStream(fileIn);
            var dao = (TransactionDao) in.readObject();
            this.lastCode = dao.lastCode;
            this.transactions = dao.transactions;
            in.close();
            fileIn.close();
        } catch(FileNotFoundException ex){
            
        }
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
        return transactions.removeIf(t -> t.getCode() == code);
    }
    
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }
}
