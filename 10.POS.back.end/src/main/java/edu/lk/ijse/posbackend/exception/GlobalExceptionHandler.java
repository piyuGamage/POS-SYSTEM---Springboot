package edu.lk.ijse.posbackend.exception;

import edu.lk.ijse.posbackend.util.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<APIResponse<String>> handleGeneralException(Exception e) {
        return new ResponseEntity<>(new APIResponse<>
                (HttpStatus.INTERNAL_SERVER_ERROR.value(),"Internel Server error",e.getMessage())
        , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<APIResponse<String>> handleNullPointerException(NullPointerException e) {
        return new ResponseEntity<>(
                new APIResponse<>(
                        HttpStatus.INTERNAL_SERVER_ERROR.value(),
                        "Null Value",
                        e.getMessage() != null ? e.getMessage() : "Null pointer exception occurred"
                ),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<APIResponse<String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return new ResponseEntity<>(
                new APIResponse<>
                        (HttpStatus.BAD_REQUEST.value(), "Validation",errors.toString()),
                HttpStatus.BAD_REQUEST
        );
    }
}
