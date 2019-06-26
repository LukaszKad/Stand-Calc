package pl.coderslab.app.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT  * FROM User WHERE username = ?", nativeQuery = true)
    User findByUsername(String username);

    @Query(value = "SELECT * FROM User WHERE email =?", nativeQuery = true)
    User findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.nip = :nip")
    List<User> findAllByNip(String nip);

    @Query("select u FROM User u WHERE u.email = :email")
    List<User> findAllByEmail(String email);
}
