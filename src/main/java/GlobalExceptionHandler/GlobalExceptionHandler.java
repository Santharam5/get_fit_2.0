package GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
        ErrorResponse errorResponse=new ErrorResponse(LocalDate.now(), HttpStatus.NOT_FOUND.value(),"Resource not Found",ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EntityMappedException.class)
    public ResponseEntity<ErrorResponse> handleEntityMappedException(EntityMappedException ex) {
        ErrorResponse errorResponse=new ErrorResponse(LocalDate.now(), HttpStatus.CONFLICT.value(),"Cannot Delete The Current Data",ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }
    @ExceptionHandler(HandleEntityAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEntityAlreadyExistsException(HandleEntityAlreadyExistsException ex) {
        ErrorResponse errorResponse=new ErrorResponse(LocalDate.now(), HttpStatus.CONFLICT.value(),"Entity Already Exists",ex.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

}
