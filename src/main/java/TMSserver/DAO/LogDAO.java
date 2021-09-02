package TMSserver.DAO;

import TMSserver.SQL.Entities.LogDTO;
import TMSserver.SQL.Repositories.LogRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


//Here you can cache data from database
@Service
@RequiredArgsConstructor
public class LogDAO {

    private final LogRepository logRepository;

    @Cacheable("logs")
    public List<LogDTO> findAllLogs(){
        return Lists.newArrayList(logRepository.findAll());
    }

}
