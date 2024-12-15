package dao;

import java.util.List;
import models.Book;

public interface BookDao {
    
    List<Book> getAllBooks();

    Book getBookById(int bookId);

    void insertBookRecord(String title, String author, boolean isAvailable);
    
    void setBookAvailability(int bookId, boolean isAvailable);

    List<Book> getAvailableBooks(boolean isAvailable);
}
