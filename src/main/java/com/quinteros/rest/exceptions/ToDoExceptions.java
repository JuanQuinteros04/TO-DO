package com.quinteros.rest.exceptions;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class ToDoExceptions extends RuntimeException{
    private String message;
    private HttpStatus httpstatus;

    public ToDoExceptions(String message, HttpStatus httpstatus) {
        super(message);
        this.message = message;
        this.httpstatus = httpstatus;
    }
}
