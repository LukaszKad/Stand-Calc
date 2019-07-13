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

    public StandElement getStandElementById(Long id) {
        return standElementsRepository.findById(id).orElse(null);
    }

    public StandElement findFirstById(Long id){
        return standElementsRepository.findFirstById(id);
    }

    public StandElement findStandElementById(Long id){
        return standElementsRepository.findById(id).orElse(null);
    }

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

    public List<StandElement> findByType(String type){
        return standElementsRepository.findByType(type);
    }

    public List<StandElement> findByElementLikeRegex(String regex){
        return standElementsRepository.findByElementLikeRegex(regex.toLowerCase());
    }

    public List<StandElement> findAllByType(){
        return standElementsRepository.findAllByType();
    }

    public StandElement findByElement(String element){
        return standElementsRepository.findByElement(element.toLowerCase());
    }
}

