package TMSserver.DAO;

import TMSserver.SQL.Entities.LogDTO;
import TMSserver.SQL.Entities.LogDTO;
import TMSserver.SQL.Entities.MaterialDTO;
import TMSserver.SQL.Repositories.LogRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogDAO {

    private final LogRepository logRepository;
    @Async
    public String createTable() {
        return logRepository.createTable();
    }

    public List<LogDTO> findAll() {
        return Lists.newArrayList(logRepository.findAll());
    }

    public void save(LogDTO LogDTO) {
        logRepository.save(LogDTO);
    }
}
