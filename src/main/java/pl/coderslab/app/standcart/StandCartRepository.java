package pl.coderslab.app.standcart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StandCartRepository extends JpaRepository<StandCart, Long> {

    @Query(value = "SELECT  * FROM StandCart WHERE id = ?", nativeQuery = true)
    StandCart findById(long id);
}
