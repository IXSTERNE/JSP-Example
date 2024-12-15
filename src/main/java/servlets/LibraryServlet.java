package servlets;

import java.io.IOException;
import java.util.List;
import java.sql.Date;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import models.Book;
import models.User;
import models.Transaction;
import services.BookService;
import services.UserService;
import utils.DataAccessException;
import services.TransactionService;

public class LibraryServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;

    private BookService bookService = new BookService();
    private UserService userService = new UserService();
    private TransactionService transactionService = new TransactionService();

    List<Book> books;
    List<User> users;
    List<Transaction> transactions;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String path = request.getServletPath();

        try{
            switch(path) {
                case "/books":
                    handleBooks(request, response);
                    break;
                case "/users":
                    handleUsers(request, response);
                    break;
                case "/transactions":
                    handleTransactions(request, response);
                default:
                    response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private void handleBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DataAccessException {

        String availability = request.getParameter("availability");
        List<Book> books;

        if (availability == null || "all".equals(availability)) {
            books = bookService.displayAllBooks();
        } else if ("available".equals(availability)) {
            books = bookService.displayAvailableBooks(true);
        } else if ("unavailable".equals(availability)) {
            books = bookService.displayAvailableBooks(false);
        } else {
            books = bookService.displayAllBooks();
        }
        request.setAttribute("title", "Books");
        request.setAttribute("books", books);
        request.getRequestDispatcher("/WEB-INF/views/view_books.jsp").forward(request, response);
    }

    private void handleUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DataAccessException {
        List<User> users = userService.displayAllUsers();
        request.setAttribute("title", "Users");
        request.setAttribute("users", users);
        request.getRequestDispatcher("/WEB-INF/views/view_users.jsp").forward(request, response);
    }

    private void handleTransactions(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, DataAccessException {
        List<Transaction> transactions = transactionService.displayAllTransactions();
        List<User> users = userService.displayAllUsers(); // 1
        List<Book> books = bookService.displayAllBooks(); // 1
        request.setAttribute("title", "Transactions");
        request.setAttribute("transactions", transactions);
        request.setAttribute("users", users); // 1
        request.setAttribute("books", books); // 1
        request.getRequestDispatcher("/WEB-INF/views/view_transactions.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");

        if("addBook".equals(action)){
            String title = request.getParameter("title");
            String author = request.getParameter("author");
            boolean isAvailable = request.getParameter("isAvailable") != null;

            try{
                bookService.addBook(title, author, isAvailable);
            }
            catch(DataAccessException e){
                e.printStackTrace();
            }
        }
        else if("addUser".equals(action)){
            String name = request.getParameter("name");
            String email = request.getParameter("email");

            try{
                userService.addUser(name, email);
            }
            catch(DataAccessException e){
                e.printStackTrace();
            }
        }
        else if("addTransaction".equals(action)){
            int userId = Integer.parseInt(request.getParameter("userId"));
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            Date date = Date.valueOf(request.getParameter("date"));

            try{
                transactionService.addTransaction(userId, bookId, date);
                Book book = bookService.displayBookById(bookId);
                boolean currentAvailability = book.isAvailable();

                boolean newAvailability = !currentAvailability; // Just reverse it!
                bookService.updateBookAvailability(bookId, newAvailability);

            }
            catch(DataAccessException e){
                e.printStackTrace();
            }
        }
        
        doGet(request, response);
    }
}
