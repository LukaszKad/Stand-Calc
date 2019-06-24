package pl.coderslab.app.standelement;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StandElementRepository extends JpaRepository<StandElement, Long> {

    StandElement findFirstById(long id);

}