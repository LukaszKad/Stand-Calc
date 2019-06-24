package pl.coderslab.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // Łączenie koszyka z userem

    @RequestMapping("/advanced/stand/{id}")
    public String getStandCart(Model model, User user){
        Long id = userService.findByUsername(user.getUsername()).getStandCart().getId();
        model.addAttribute("id", id);
        return "stand";
    }

}