package pl.coderslab.app.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    @Query(value = "SELECT  * FROM User WHERE username = ?", nativeQuery = true)
    User findByUsername(String username);

    @Query(value = "SELECT * FROM User WHERE email =?", nativeQuery = true)
    User findByEmail(String email);

}
