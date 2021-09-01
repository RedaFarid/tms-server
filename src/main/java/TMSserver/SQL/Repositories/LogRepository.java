package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.LogDTO;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<LogDTO, Long> {
}
