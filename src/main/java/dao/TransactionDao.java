package dao;

import java.util.List;
import java.sql.Date;

import models.Transaction;


public interface TransactionDao {

    List<Transaction> getAllTransactions();   

    void insertTransactionRecord(int userId, int bookId, Date date);
}
