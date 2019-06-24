package pl.coderslab.app;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

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
