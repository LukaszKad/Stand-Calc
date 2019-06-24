package pl.coderslab.app.standcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.app.standelement.StandElement;
import pl.coderslab.app.standitem.StandItem;
import pl.coderslab.app.standelement.StandElementService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/user")
public class StandCartController {

    @Autowired
    private StandElementService standElementsService;


    @Autowired
    private StandCartService standCartService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public StandCart getStandCartById (@PathVariable Long id){
        return standCartService.getStandCartById(id);
    }


    @GetMapping("/advanced/addtostand")
    public String addToStandCart(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        Integer quantity = Integer.parseInt(request.getParameter("quantity"));
        int q = quantity;
        StandElement standElements = standElementsService.findFirstById(id);
        List<StandItem> standItems = standCartService.getStandItems();
        boolean inStandCart = false;

        for (int i = 0; i < standItems.size(); i++) {
            if (id == standCartService.getStandItems().get(i).getStandElements().getId()) {
                for (int j = 0; j < standItems.size(); j++) {
                    if (standItems.get(j).getStandElements().getId() == id) {
                        standItems.get(j).setQuantity(standItems.get(j).getQuantity() + q);
                        inStandCart = true;
                        return "redirect:/user/advanced";
                    }
                }
                if (!inStandCart) {
                    standElements = standItems.get(i).getStandElements();
                    standCartService.addToStandCart(new StandItem(standElements, q));
                    return "redirect:/user/advanced";
                }
            }
        }
        standCartService.addToStandCart(new StandItem(standElements, quantity));
        return "redirect:/user/advanced";
    }

    @RequestMapping("/advanced/stand")
    public String standCart(Model model) {
        model.addAttribute("standCartService", standCartService.getStandItems());
        int items = standCartService.getStandItems().size();
        int numbofElements = 0;
        double total = 0;

        for (int i = 0; i < standCartService.getStandItems().size() ; i++) {
            int q = standCartService.getStandItems().get(i).getQuantity();
            double tot = standCartService.getStandItems().get(i).getStandElements().getPrice() * q ;
            numbofElements += q;
            total += tot;
        }
        model.addAttribute("items", items);
        model.addAttribute("numbofElements", numbofElements);
        model.addAttribute("total", total);
        return "stand";
    }

    @RequestMapping("/advanced/stand/delete/{id}")
    public String delete(@PathVariable Long id, Model model) {
        int index = 0;
        for (int i = 0; i < standCartService.getStandItems().size(); i++) {
            if (id == standCartService.getStandItems().get(i).getStandElements().getId()) {
                index = i;
            }
        }
        standCartService.getStandItems().remove(index);
        model.addAttribute("standCartService", standCartService);
        return "redirect:/user/advanced/stand";
    }

}
