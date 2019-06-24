package pl.coderslab.app.login;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.user.User;
import pl.coderslab.app.user.UserService;

import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes("userSession")
public class LoginController {

    private UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.findByUsername(username);
        model.addAttribute("isLogged", false);
        if (user == null) {
            return "login";
        }
        if (BCrypt.checkpw(password, user.getPassword())) {
            model.addAttribute("userSession", user);
            model.addAttribute("isLogged", true);
            if(user.getUsername().equals("admin")){
                return "adminPanel";
            }
            return "redirect:/user/advanced";
        }
        return "login";
    }

    @GetMapping("/user/logout")
    public String logout(HttpSession session, Model model) {
        model.addAttribute("userSession", null);
        session.invalidate();
        return "redirect:/home";
    }
}