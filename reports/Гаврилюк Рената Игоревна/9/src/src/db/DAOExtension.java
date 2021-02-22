package db;

public class DAOExtension extends Exception {
    public DAOExtension() {
    }

    public DAOExtension(String message) {
        super(message);
    }

    public DAOExtension(String message, Throwable cause) {
        super(message, cause);
    }

    public DAOExtension(Throwable cause) {
        super(cause);
    }
}