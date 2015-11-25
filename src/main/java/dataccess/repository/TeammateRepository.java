package dataccess.repository;

import dataccess.domain.Teammate;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TeammateRepository extends CrudRepository<Teammate, Long> {
    List<Teammate> findByPosition(String position);
}
