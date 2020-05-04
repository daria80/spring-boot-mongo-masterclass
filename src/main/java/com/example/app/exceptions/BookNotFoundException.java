package com.example.app.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode
public class BookNotFoundException extends RuntimeException {

    private String message;
    private HttpStatus status;

    public BookNotFoundException (String message) {
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }
}
