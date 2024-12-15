package services;

import java.util.List;
import models.Book;
import utils.DataAccessException;
import dao.impl.BookDaoImpl;
import dao.BookDao;

public class BookService {

    private BookDao bookDao = new BookDaoImpl();

    public List<Book> displayAllBooks() throws DataAccessException{
        return bookDao.getAllBooks();
    }

    public Book displayBookById(int bookId){
        return bookDao.getBookById(bookId);
    }

    public void addBook(String title, String author, boolean isAvailable) throws DataAccessException{
        bookDao.insertBookRecord(title, author, isAvailable);
    }

    public void updateBookAvailability(int bookId, boolean isAvailable){
        bookDao.setBookAvailability(bookId, isAvailable);
    }

    public List<Book> displayAvailableBooks(boolean isAvailable){
        return bookDao.getAvailableBooks(isAvailable);
    }
    
}
