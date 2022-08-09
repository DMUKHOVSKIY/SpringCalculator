package by.tms.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e) {
    return "error";
    }
}
