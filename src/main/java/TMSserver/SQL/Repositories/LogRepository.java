package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.LogDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LogRepository extends PagingAndSortingRepository<LogDTO, Long> {
}
