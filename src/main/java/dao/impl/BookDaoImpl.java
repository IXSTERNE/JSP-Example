package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Book;
import dao.BookDao;
import utils.Database;


public class BookDaoImpl implements BookDao{

    private static final String LOOK_BOOKS = "SELECT * FROM books";
    private static final String INSERT_BOOK = "INSERT INTO books (title, author, is_available) VALUES (?, ?, ?)";
    private static final String SET_AV = "UPDATE books SET is_available = ? WHERE book_id = ?";
    private static final String GET_A_BOOK = "SELECT * FROM books WHERE book_id = ?";
    private static final String GET_AV_BOOKS = "SELECT * FROM books WHERE is_available = ?";


    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        Connection connection = Database.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(LOOK_BOOKS);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Book book = new Book();
                book.setBookId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setAvailable(rs.getBoolean("is_available"));
                books.add(book);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    public List<Book> getAvailableBooks(boolean isAvailable){

        Connection connection = Database.getInstance().getConnection();
        try{
            PreparedStatement statement = connection.prepareStatement(GET_AV_BOOKS);
            statement.setBoolean(1, isAvailable);
            ResultSet resultSet = statement.executeQuery();

            List<Book> books = new ArrayList<>();
            while (resultSet.next()) {
                books.add(new Book(
                    resultSet.getInt("book_id"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getBoolean("is_available")
                ));
            }
            return books;
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Book getBookById(int bookId){
        Connection connection = Database.getInstance().getConnection();
        try{
            PreparedStatement st = connection.prepareStatement(GET_A_BOOK);
            st.setInt(1, bookId);
            ResultSet resultSet = st.executeQuery();

            if (resultSet.next()) {
                return new Book(
                    resultSet.getInt("book_id"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getBoolean("is_available"));
            } 
            else {
                throw new SQLException();
            }
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void insertBookRecord(String title, String author, boolean isAvailable){
        
        Connection connection = Database.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(INSERT_BOOK);

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setBoolean(3, isAvailable);
            ps.executeUpdate();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBookAvailability(int bookId, boolean isAvailable){

        Connection connection = Database.getInstance().getConnection();
        try{
            PreparedStatement ps = connection.prepareStatement(SET_AV);
            ps.setBoolean(1, isAvailable);
            ps.setInt(2, bookId);
            ps.executeUpdate();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
