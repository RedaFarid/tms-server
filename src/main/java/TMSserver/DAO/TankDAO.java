package TMSserver.DAO;

import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Repositories.TankRepository;

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

    public Optional<TankDTO> findByNameAndStation(String name, Long station) {
        return tankRepository.findByNameAndStation(name,station);
    }

    @CacheEvict(cacheNames = "tanks", allEntries = true)
    public void deleteById(Long id) {
        tankRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "tanks", allEntries = true)
    public void save(TankDTO tankDTO) {
        tankRepository.save(tankDTO);
    }

    public List<TankDTO> findByMaterialAndStation(Long materialId, Long stationId) {
        return tankRepository.findByMaterialAndStation(materialId,stationId);
    }
}
