package by.tms.controller;

import by.tms.entity.User;
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

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private ChangeService changeService;

    @Autowired
    private UserService userService;

    @GetMapping
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
    public String deleteUser(HttpSession session) {
        changeService.deleteUser((User) session.getAttribute("currentUser"));
        session.invalidate();
        return "redirect:/";
    }


    @GetMapping("/deleteOperation")
    public String deleteOperation(HttpSession session) {
        changeService.deleteOperation((User) session.getAttribute("currentUser"));
        return "account";
    }

    @GetMapping("/info")
    public String information(Model model, HttpSession session) {
        User currentUser = (User) session.getAttribute("currentUser");
        model.addAttribute("userInfo", userService.findByUsername(currentUser.getUsername()));
        return "info";
    }

    @GetMapping("/changeAddress")
    public String changeAddressForm() {
        return "changeAddress";
    }

    @PostMapping("/changeAddress")
    public String changeAddress(String newCity, String newStreet, HttpSession httpSession) {
        changeService.changeAddress(newCity, newStreet, (User) httpSession.getAttribute("currentUser"));
        return "account";
    }

    @GetMapping("/OperationsWithTelephone")
    public String OperationWithTelephone() {
        return "telephoneOperations";
    }

    @GetMapping("/addNewNumber")
    public String addTelephoneForm() {
        return "addNumber";
    }

    @PostMapping("/addNumber")
    public String addTelephone(String newNumber, HttpSession session) {
        changeService.addTelephone(newNumber, (User) session.getAttribute("currentUser"));
        return "account";
    }

    @GetMapping("/changeNumber")
    public String changeNumberForm() {
        return "changeNumber";
    }

    @PostMapping("/changeNumber")
    public String changeNumber(String oldNumber, String newNumber, HttpSession session, Model model) {
        if (!changeService.changeNumber(oldNumber, newNumber, (User) session.getAttribute("currentUser"))) {
            model.addAttribute("changeNumber", "Enter correct number");
            return "changeNumber";
        }
        return "account";
    }

    @GetMapping("/deleteNumber")
    public String deleteNumber() {
        return "deleteNumber";
    }

    @PostMapping("/deleteNumber")
    public String deleteNumber(String number, HttpSession session, Model model) {
        if (!changeService.deleteNumber(number, (User) session.getAttribute("currentUser"))) {
            model.addAttribute("deleteNumber", "Enter correct number");
            return "deleteNumber";
        }
        return "account";
    }

}
