package pl.coderslab.app.standelement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/user")
public class StandElementController {

    @Autowired
    private StandElementService standElementsService;


    // Zaawansowana wycena:

    @RequestMapping("/advanced")
    public String elementsListWithPrice(Model model){
        List<StandElement> standElements = standElementsService.getAllStandElements();
        model.addAttribute("standElements", standElements);
        return "standForm";
    }

    // Przekazanie ID do quantityElement

    @GetMapping("/advanced/addtostand/{id}")
    public String elementGet(@PathVariable Long id, Model model) {
        StandElement standElement = standElementsService.findStandElementById(id);
        model.addAttribute(standElement);
        return "quantityElement";
    }
}
