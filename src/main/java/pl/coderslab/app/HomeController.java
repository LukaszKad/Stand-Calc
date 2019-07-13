package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.app.user.UserService;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String start(){
        return "home";
    }

    @GetMapping("/user/panel")
    public String start2(){
        return "panel";
    }
    @GetMapping("/user/panel/details")
    public String start3(){
        return "panelDetails";
    }
}
