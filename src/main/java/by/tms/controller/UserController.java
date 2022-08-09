package by.tms.controller;

import by.tms.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/registration")
    public String formReg(Model model) {
        model.addAttribute("newUser", new User());
        return "reg";
    }

    @PostMapping("/registration")
    public ModelAndView postReg(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, ModelAndView model) {
        if(bindingResult.hasErrors()){
            model.setViewName("reg");
            return model;
        }
        model.setViewName("calc");
        return model;
    }
}
