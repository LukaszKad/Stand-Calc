package pl.coderslab.app.standelement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandElementService {

    private StandElementRepository standElementsRepository;

    @Autowired
    public StandElementService(StandElementRepository standElementsRepository) {
        this.standElementsRepository = standElementsRepository;
    }

    // znajdz po id to moje getProduct

    public StandElement getStandElementById(Long id) {
        return standElementsRepository.findById(id).orElse(null);
    }

    public StandElement findFirstById(Long id){
        return standElementsRepository.findFirstById(id);
    }

    public StandElement findStandElementById(Long id){
        return standElementsRepository.findById(id).orElse(null);
    }

    // Znajdowanie listy elementów to moje getList

    public List<StandElement> getAllStandElements(){
        return standElementsRepository.findAll();
    }

    // zapisywanie

    public void saveStandElement(StandElement elements){
        standElementsRepository.save(elements);
    }

    // edit

    public void updateStandElement(StandElement standElements){
        standElementsRepository.save(standElements);
    }

    // usuwanie

    public void deleteStandElement(Long id){
        standElementsRepository.deleteById(id);
    }

    //

    public void deleteStandElementBy(Long id){
        StandElement standElements = standElementsRepository.findFirstById(id);
        standElementsRepository.delete(standElements);
    }

    // Znajduje jeden element z listy standelement elements

    public StandElement getOneElement(Long id){
        return getAllStandElements().stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }


}

