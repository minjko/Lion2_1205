package app.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(NoSuchElementException.class)
    public ErrorAPIResponse apiExceptionHandler(NoSuchElementException e) {
        return new ErrorAPIResponse(e.getMessage());
    }

    @Getter
    @AllArgsConstructor
    public static class ErrorAPIResponse {
        private String msg;
    }

}
