package pl.coderslab.app.standitem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface StandItemRepository extends JpaRepository<StandItem, Long> {

    @Query(value = "SELECT * FROM StandItem WHERE standElements_id = ?", nativeQuery = true)
    StandItem getStandItemById(long id);

    @Query(value = "DELETE FROM StandItem where id = ?", nativeQuery = true)
    StandItem deleteStandItemById(long id);
}
