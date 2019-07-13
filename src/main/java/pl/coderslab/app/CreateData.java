package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.coderslab.app.standelement.StandElement;
import pl.coderslab.app.user.User;
import pl.coderslab.app.user.UserService;
import pl.coderslab.app.standelement.StandElementService;

import javax.annotation.PostConstruct;

@Component
public class CreateData {

    @Autowired
    private UserService userService;

    @Autowired
    private StandElementService standElementService;

    @PostConstruct
    public void addAdmin(){
        User findUser = userService.findByUsername("admin");
        if(findUser == null) {
            User user = new User();
            user.setUsername("admin");
            user.setPassword("password");
            user.setEmail("admin@admin.pl");
            userService.saveUser(user);
        }
    }

    @PostConstruct
    public void addTestUser(){
        User findUser = userService.findByUsername("user");
        if(findUser == null) {
            User user = new User();
            user.setUsername("user");
            user.setPassword("password");
            user.setEmail("user@user.com");
            user.setFirstName("John");
            user.setLastName("Kovalski");
            userService.saveUser(user);
        }
    }

    @PostConstruct
    public void addTestElements(){
        StandElement findElement = standElementService.findByElement("wykładzina");
        if(findElement == null) {
            StandElement standElement = new StandElement();
            standElement.setElement("wykładzina");
            standElement.setPrice(20);
            standElement.setDescription("Wykładzina targowa zgodna ze wzornikiem");
            standElement.setType("mkv.");
            standElementService.saveStandElement(standElement);
        }
        findElement = standElementService.findByElement("krzesła");
        if(findElement == null) {
            StandElement standElement = new StandElement();
            standElement.setElement("krzesła");
            standElement.setPrice(100);
            standElement.setDescription("Krzesła typu VIP");
            standElement.setType("sztuki");
            standElementService.saveStandElement(standElement);
        }
    }
}
