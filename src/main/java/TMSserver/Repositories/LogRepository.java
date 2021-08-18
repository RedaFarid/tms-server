package TMSserver.Repositories;

import TMSserver.Entities.LogDTO;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<LogDTO, Long> {
}
