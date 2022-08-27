package by.tms.controller;

import by.tms.converter.Converter;
import by.tms.entity.Address;
import by.tms.entity.Telephone;
import by.tms.entity.User;
import by.tms.model.LoginUserModel;
import by.tms.model.PasswordModel;
import by.tms.model.RegistrationModel;
import by.tms.service.ChangeService;
import by.tms.service.UserService;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private Converter converter;

    @GetMapping("/reg")
    public String registrationForm(Model model) {
        model.addAttribute("newUser", new RegistrationModel());
        return "reg";
    }

    @PostMapping("/reg")
    public String registration(@Valid @ModelAttribute("newUser") RegistrationModel user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        if (!userService.save(converter.convertModelToUser(user))) {
            model.addAttribute("isExist", true);
            return "reg";
        }
        model.addAttribute("false");
        return "redirect:/";
    }

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("userModel", new LoginUserModel());
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("userModel") LoginUserModel userModel, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        Optional<User> byUsername = userService.findByUsername(userModel.getUsername());
        if (byUsername.isPresent()) {
            User user1 = byUsername.get();
            if (user1.getPassword().equals(userModel.getPassword())) {
                session.setAttribute("currentUser", user1);
                return "redirect:/";
            } else {
                model.addAttribute("message", "Wrong password");
                return "login";
            }
        } else {
            model.addAttribute("message", "User not found!");
            return "login";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
