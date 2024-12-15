package models;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable{
    private int transactionId;
    private int userId;
    private int bookId;
    private Date date;

    public Transaction(){}

    public Transaction(int transactionId, int userId, int bookId, Date date){
        this.transactionId = transactionId;
        this.userId = userId;
        this.bookId = bookId;
        this.date = date;
    }

    public int getTransactionId(){ return transactionId; }
    public int getUserId(){ return userId; }
    public int getBookId(){ return bookId; }
    public Date getDate(){ return date; }

    public void setTransactionId(int transactionId){ this.transactionId = transactionId; } 
    public void setUserId(int userId){ this.userId = userId; } 
    public void setBookId(int bookId){ this.bookId = bookId; } 
    public void setDate(Date date){ this.date = date; } 
}
