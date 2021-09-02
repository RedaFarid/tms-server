package TMSserver.DAO;

import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Repositories.TankRepository;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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


    public Optional<TankDTO> findById(Long id) {
        return tankRepository.findById(id);
    }

    public Optional<TankDTO> findByNameAndStation(Long id) {
        return null;
    }

    public Optional<TankDTO> save(TankDTO tank) {
        return Optional.of(tankRepository.save(tank));
    }
}
