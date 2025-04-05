package exception;

public class InvalidGarmentException extends RuntimeException {
    public InvalidGarmentException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
