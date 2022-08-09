package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/program")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calculator")
    public String expression(){
        return "calc";
    }

    @PostMapping("/calculator")
    public ModelAndView calc(Operation operation, ModelAndView model){
        if(operation.getNum2() == 0 && operation.getOperation().equals("div"))
            throw new RuntimeException();
        model.addObject("result",calculatorService.calculate(operation));
        model.setViewName("calc");
        return model;
    }
}
