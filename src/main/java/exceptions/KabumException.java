package exceptions;

public class KabumException extends Exception {

    public final String title = "Kabuuuum!";

    public KabumException(String message) {
        super(message);
    }

    public KabumException(String message, Throwable cause) {
        super(message, cause);
    }
}
