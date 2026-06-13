package vlad.way.order.service.exception;

public class OrderNotFountException extends RuntimeException {
    public OrderNotFountException(String message) {
        super(message);
    }
}
