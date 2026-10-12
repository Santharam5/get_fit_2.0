package GlobalExceptionHandler;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = org.springframework.http.HttpStatus.CONFLICT)
public class HandleEntityAlreadyExistsException extends RuntimeException {
    public HandleEntityAlreadyExistsException(String message) {
        super(message);
    }
}
