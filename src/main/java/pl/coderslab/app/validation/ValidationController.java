package pl.coderslab.app.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.app.user.User;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    private Validator validator;

    public ValidationController(Validator validator) {
        this.validator = validator;
    }

    @GetMapping("/add/validate")
    public String userValidate(Model model){
        User user = new User();
        List<Errors> list = new ArrayList<>();
        Set<ConstraintViolation<User>> errors = validator.validate(user);
        if(!errors.isEmpty()){
            for(ConstraintViolation<User> error:errors){
                String path = error.getPropertyPath().toString();
                String message = error.getMessage();
                list.add(new Errors(path, message));
            }
        }
        model.addAttribute("errors", list);
        return "errors";
    }
}
