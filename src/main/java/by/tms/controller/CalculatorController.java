package by.tms.controller;


import by.tms.entity.Operation;
import by.tms.entity.User;
import by.tms.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/calculator")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/calc")
    public String calcForm(Model model) {
        model.addAttribute("operation", new Operation());
        return "calc";
    }

    @PostMapping("/calc")
    public String calc(@Valid @ModelAttribute("operation") Operation operation, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "calc";
        }
        if (operation.getNum2() == 0 && operation.getOperation().equals("div")) {
            throw new RuntimeException();
        }
        Object currentUser = session.getAttribute("currentUser");
        Optional<Operation> operation1 = calculatorService.calculate(operation, (User) currentUser);
        if (operation1.isPresent()) {
            model.addAttribute("result", operation.getResult());
        } else {
            model.addAttribute("result", "Upsss");
        }
        return "calc";
    }

    @GetMapping("/history")
    public String historyOfOperationForm(Model model, HttpSession session) {
        model.addAttribute("operations",
                calculatorService.findAllOperationByUsername(((User) session.getAttribute("currentUser")).getUsername()));
        return "history";
    }
}
