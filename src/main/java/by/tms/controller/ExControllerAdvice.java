package by.tms.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public String handleException(RuntimeException e, Model model) {
        model.addAttribute("error", e.getMessage());
        System.out.println(e.toString());
        return "error";
    }
}
