package TMSserver.DAO;

import TMSserver.SQL.Entities.ComputerDTO;
import TMSserver.SQL.Repositories.ComputerRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ComputersDAO {
    private final ComputerRepository computerRepository;

    @Async
    public String createTable() {
        return computerRepository.createTable();
    }

    @Cacheable("computers")
    public List<ComputerDTO> findAll() {
        return Lists.newArrayList(computerRepository.findAll());
    }

    @CacheEvict(cacheNames = "computers", allEntries = true)
    public void deleteAll() {
        computerRepository.deleteAll();
    }

    @CacheEvict(cacheNames = "computers", allEntries = true)
    public void save(ComputerDTO computerDTO) {
        computerRepository.save(computerDTO);
    }

}
