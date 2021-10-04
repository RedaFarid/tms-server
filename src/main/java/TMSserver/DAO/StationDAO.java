package TMSserver.DAO;

import TMSserver.SQL.Entities.StationDTO;
import TMSserver.SQL.Repositories.StationRepository;
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
public class StationDAO {

    private final StationRepository stationRepository;

    @Async
    public String createTable() {
        return stationRepository.createTable();
    }

    @Cacheable("drivers")
    public List<StationDTO> findAll() {
        return Lists.newArrayList(stationRepository.findAll());
    }


    public Optional<StationDTO> findById(Long id) {
        return stationRepository.findById(id);
    }

    public Optional<StationDTO> findByStationName(String stationName) {
        return stationRepository.findByStationName(stationName);
    }

    @CacheEvict(cacheNames= "stations", allEntries = true)
    public void deleteById(Long id) {
        stationRepository.deleteById(id);
    }

    @CacheEvict(cacheNames= "stations", allEntries = true)
    public void save(StationDTO stationDTO) {
       stationRepository.save(stationDTO);
    }
}
