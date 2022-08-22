package by.tms.controller;

import by.tms.entity.User;
import by.tms.model.LoginUserModel;
import by.tms.model.PasswordModel;
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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
@Autowired
private UserService userService;

    @Autowired
    private ChangeService changeService;

    @GetMapping("/reg")
    public String registrationForm(Model model) {
        model.addAttribute("newUser", new User());
        return "reg";
    }

    @PostMapping("/reg")
    public String registration(@Valid @ModelAttribute("newUser") User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "reg";
        }
        if (!userService.save(user)) {
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

    @GetMapping("/account")
    public String account() {
        return "account";
    }

    @GetMapping("/changeName")
    public String changeNameForm() {
        return "changeName";
    }

    @PostMapping("/changeName")
    public String changeName(String name, HttpSession session) {
        if (!name.isEmpty() && !name.isBlank()) {
            changeService.changeName(name, (User) session.getAttribute("currentUser"));
        }
        return "account";
    }

    @GetMapping("/changePassword")
    public String changePasswordForm(Model model) {
        model.addAttribute("passwordModel", new PasswordModel());
        return "changePassword";
    }

    @PostMapping("/changePassword")
    public String changePassword(@Valid @ModelAttribute("passwordModel") PasswordModel passwordModel, BindingResult bindingResult, Model model, HttpSession session) {
        if (bindingResult.hasErrors()) {
            return "changePassword";
        }

        User user = (User) session.getAttribute("currentUser");
        if (!(passwordModel.getOldPassword().equals(user.getPassword()))) {
            model.addAttribute("messagePassword", "Incorrect old password");
            return "changePassword";
        }

        changeService.changePassword(passwordModel.getNewPassword(), user);
        model.addAttribute("messagePassword", "Password has changed");
        return "changePassword";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(HttpSession session){
        changeService.deleteUser((User) session.getAttribute("currentUser"));
        session.invalidate();
        return "redirect:/";
    }


    @GetMapping("/deleteOperation")
    public String deleteOperation(HttpSession session){
        changeService.deleteOperation((User)session.getAttribute("currentUser"));
        return "account";
    }

}
