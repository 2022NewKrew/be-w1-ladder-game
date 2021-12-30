package exception;

public class NoSuchNameException extends RuntimeException{
    public NoSuchNameException(String msg) {
        super(msg);
    }
}
