package my.app.site.repo;

import my.app.site.models.PawnTicket;
import org.springframework.data.repository.CrudRepository;

public interface PawnRepository extends CrudRepository<PawnTicket, Integer> {
}
