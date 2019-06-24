package pl.coderslab.app.standcart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.app.standitem.StandItem;

import java.util.ArrayList;
import java.util.List;

@Service
public class StandCartService {


    @Autowired
    private StandCartRepository standCartRepository;


    public StandCart getStandCartById(long id){
        return standCartRepository.findById(id);
    }

    private List<StandItem> standItems = new ArrayList<>();

    public List<StandItem> getStandItems() {
        return standItems;
    }

    public void setStandItems(List<StandItem> standItems) {
        this.standItems = standItems;
    }

    public void addToStandCart(StandItem standItem){
        standItems.add(standItem);
    }
}
