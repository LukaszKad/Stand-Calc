package pl.coderslab.app.user;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // znajdz po nazwisku

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    // znajdz po email

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public List<User> findAllByNip(String nip){
        return userRepository.findAllByNip(nip);
    }
    public List<User> findAllByEmail(String email){
        return userRepository.findAllByEmail(email);
    }

    // znajdz po id

    public User findUserById(Long id){
        return userRepository.findById(id).orElse(null);
    }

    // zapisywanie

    public void saveUser(User user){
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userRepository.save(user);
    }

    // edit

    public void updateUser(User user){
        userRepository.save(user);
    }

    // usuwanie

    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }

    public List<User> getUsersList(){
        return userRepository.findAll();
    }


}
