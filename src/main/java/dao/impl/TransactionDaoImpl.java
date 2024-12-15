package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

import models.Transaction;
import dao.TransactionDao;
import utils.Database;

public class TransactionDaoImpl implements TransactionDao{

    private static final String LOOK_TRANSACTIONS = "SELECT * FROM transactions";
    private static final String INSERT_TRANSACTION = "INSERT INTO transactions (user_id, book_id, date) VALUES (?, ?, ?)";

    public List<Transaction> getAllTransactions(){

        List<Transaction> transactions = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();

        try{
            PreparedStatement ps = connection.prepareStatement(LOOK_TRANSACTIONS);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Transaction transaction = new Transaction();
                transaction.setTransactionId(rs.getInt("transaction_id"));
                transaction.setUserId(rs.getInt("user_id"));
                transaction.setBookId(rs.getInt("book_id"));
                transaction.setDate(rs.getDate("date"));
                transactions.add(transaction);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    public void insertTransactionRecord(int userId, int bookId, Date date){

        Connection connection = Database.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(INSERT_TRANSACTION);

            ps.setInt(1, userId);
            ps.setInt(2, bookId);
            ps.setDate(3, date);
            ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
