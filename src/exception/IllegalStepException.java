package exception;

public class IllegalStepException extends RuntimeException {
    public IllegalStepException() {
    }

    public IllegalStepException(String message) {
        super(message);
    }
}
