package pl.coderslab.app.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.coderslab.app.user.User;
import pl.coderslab.app.user.UserService;

import javax.validation.Valid;

@Controller
public class RegistrationController {

    private UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    // Dodawanie usera new User (email, password, login, NIP....) przez Usera

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("userAddNew", new User());
        return "userAdd";
    }

    @PostMapping("/add")
    public String addUser(@Valid @ModelAttribute User user, BindingResult result, Model model) {
        User isUser = userService.findByEmail(user.getEmail());
        if(isUser != null){
            model.addAttribute("emailMessage", "Już jest użytkownik o takim e-mailu");
            return "userAdd";
        }
        if (result.hasErrors()) {
            return "userAdd";
        } else {
            userService.saveUser(user);
        }
        return "login";
    }
}
