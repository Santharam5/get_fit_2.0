package GlobalExceptionHandler;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ErrorResponse {
    private LocalDate localDate;
    private int status;
    private String message;
    private String error;
    public ErrorResponse(LocalDate localDate, int status, String message, String error) {
        this.localDate = localDate;
        this.status = status;
        this.message = message;
        this.error = error;
    }
}
