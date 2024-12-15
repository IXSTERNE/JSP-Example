package utils;

public class DataAccessException extends Exception {
    // Default constructor
    public DataAccessException() {
        super();
    }

    // Constructor that accepts a message
    public DataAccessException(String message) {
        super(message);
    }

    // Constructor that accepts a message and a cause
    public DataAccessException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor that accepts only a cause
    public DataAccessException(Throwable cause) {
        super(cause);
    }
}
