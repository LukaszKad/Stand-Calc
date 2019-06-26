package pl.coderslab.app.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.standelement.StandElement;
import pl.coderslab.app.standelement.StandElementService;
import pl.coderslab.app.user.User;
import pl.coderslab.app.user.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private StandElementService standElementsService;

    @Autowired
    private UserService userService;


    @GetMapping("/admin/stand/add")
    public String addStandElement(Model model) {
        model.addAttribute("standElement", new StandElement());
        return "newStandElement";  // formularz dodania elementu
    }

    @PostMapping("/admin/stand/add")
    public String addStandElement(@ModelAttribute @Valid StandElement element, BindingResult result) {
        if (result.hasErrors()) {
            return "newStandElement";
        } else {
            standElementsService.saveStandElement(element);
            return "redirect:add";
        }
    }

    // Lista elementów w tabeli

    @GetMapping("/admin/stand/list")
    public String standElementsList(Model model){
        List<StandElement> standElements = standElementsService.getAllStandElements();
        model.addAttribute("standElements", standElements);
        return "elementsList";
    }

    // Lista users w tabeli

    @GetMapping("/admin/user/list")
    public String usersList(Model model){
        List<User> users = userService.getUsersList();
        model.addAttribute("users", users);
        return "usersList";
    }

    @GetMapping("/admin/stand/update/{id}")
    public String updateStandElement(@PathVariable Long id, Model model) {
        StandElement standElement = standElementsService.findFirstById(id);
        model.addAttribute("standElement", standElement);
        return "elementListEdit";
    }


    @PostMapping("/admin/stand/update/{id}")
    public String updateStandElement(@ModelAttribute @Valid StandElement standElement, BindingResult result) {
        if (result.hasErrors()) {
            return "elementListEdit";
        }
        standElementsService.updateStandElement(standElement);
        return "redirect:../list";
    }

    @GetMapping("/admin/stand/delete/{id}")
    public String deleteStandElement(@PathVariable Long id) {
        standElementsService.deleteStandElement(id);
        return "redirect:../list";
    }

    // Edycja usera przez admina

    @GetMapping("/admin/user/update/{id}")
    public String updateUser(@PathVariable Long id, Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("userSession");
        model.addAttribute("user", userService.findUserById(id));
        return "usersListEdit";
    }

    // Edycja usera przez admina

    @PostMapping("/admin/user/update/{id}")
    public String updateUser(@ModelAttribute @Valid User user, BindingResult result, HttpServletRequest request) {
        if (result.hasErrors()) {
            return "usersListEdit";
        }
        HttpSession session = request.getSession();
        User users = (User) session.getAttribute("userSession");
        users.setId(users.getId());
        userService.updateUser(user);
        return "redirect:../list";
    }

    // Usuwanie Usera przez Admina

    @GetMapping("/admin/user/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:../list";
    }

    // Wyszukiwanie elementów

    @RequestMapping("/admin/menu")
    public String searchElements(@ModelAttribute @RequestParam(value = "keyword", required = false) String keyword,
                                 @RequestParam(value = "type", required = false) String type,
                                 Model model, HttpSession session) {
        if (keyword != null && !keyword.isEmpty()) {
            model.addAttribute("standElements", standElementsService.findByElementLikeRegex(keyword));
        } else if (type != null && !type.isEmpty()) {
            model.addAttribute("standElements", standElementsService.findByType(type));
        } else {
            model.addAttribute("standElements", standElementsService.getAllStandElements());
        }
        model.addAttribute("types", standElementsService.findAllByType());
        return "elementsList";
    }

    @RequestMapping("/admin/menu/user")
    public String searchUserByDetails(@ModelAttribute @RequestParam(value = "email", required = false) String email,
                                 @RequestParam(value = "nip", required = false) String nip,
                                 Model model, HttpSession session) {
        if (email != null && !email.isEmpty()) {
            model.addAttribute("users", userService.findAllByEmail(email));
        } else if (nip != null && !nip.isEmpty()) {
            model.addAttribute("users", userService.findAllByNip(nip));
        } else {
            model.addAttribute("users", userService.getUsersList());
        }
        return "usersList";
    }
}
