package pl.coderslab.app.standelement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StandElementRepository extends JpaRepository<StandElement, Long> {

    StandElement findFirstById(long id);

    @Query("SELECT s FROM StandElement s WHERE s.type = :type")
    List<StandElement> findByType(String type);

    @Query("select s FROM StandElement s WHERE s.element LIKE :regex")
    List<StandElement> findByElementLikeRegex(String regex);

    @Query("SELECT DISTINCT type FROM StandElement")
    List<StandElement> findAllByType();
}