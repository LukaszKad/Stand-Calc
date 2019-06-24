package pl.coderslab.app.standitem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.app.standcart.StandCart;

import java.util.List;

@Service
public class StandItemService {

    @Autowired
    private StandItemRepository standItemRepository;

    public void saveStandItem(StandItem standItem){
        standItemRepository.save(standItem);
    }


    public void deleteStandItem(StandItem standItem) {
        standItemRepository.delete(standItem);
    }

    public void deleteAllStandCartItems(StandCart standCart){
        List<StandItem> standItems = standCart.getStandItems();
        standItemRepository.deleteAll(standItems);
    }
    public void deleteStandItemById(Long id){
        standItemRepository.deleteStandItemById(id);
    }

    public StandItem getStandItemByStandElementId(Long id){
        return standItemRepository.getStandItemById(id);
    }

}
