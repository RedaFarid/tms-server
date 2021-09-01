package TMSserver.SQL.DAO;

import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Repositories.TankRepository;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;


//Here you can cache data from database
@Service
@RequiredArgsConstructor
public class TankDAO {

 private final TankRepository tankRepository;

    @Async
    public String createTable() {
        return tankRepository.createTable();
    }

    @Cacheable("tanks")
    public List<TankDTO> findAll() {
        return Lists.newArrayList(tankRepository.findAll());
    }


}
