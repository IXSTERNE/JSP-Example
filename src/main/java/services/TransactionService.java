package services;

import java.util.List;
import java.sql.Date;

import models.Transaction;
import utils.DataAccessException;
import dao.impl.TransactionDaoImpl;
import dao.TransactionDao;

public class TransactionService {

    private TransactionDao transactionDao = new TransactionDaoImpl();

    public List<Transaction> displayAllTransactions() throws DataAccessException{
        return transactionDao.getAllTransactions();
    }

    public void addTransaction(int userId, int bookId, Date date) throws DataAccessException{
        transactionDao.insertTransactionRecord(userId, bookId, date);
    }
    
}
