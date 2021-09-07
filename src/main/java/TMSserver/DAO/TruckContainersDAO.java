package TMSserver.DAO;

import TMSserver.SQL.Entities.TruckContainerDTO;
import TMSserver.SQL.Entities.TruckTrailerDTO;

import TMSserver.SQL.Repositories.TruckContainerRepository;
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
public class TruckContainersDAO {

    private final TruckContainerRepository truckContainerRepository;

    @Async
    public String createTable() {
        return truckContainerRepository.createTable();
    }

    @Cacheable("truckContainers")
    public List<TruckContainerDTO> findAll() {
        return Lists.newArrayList(truckContainerRepository.findAll());
    }

    public Optional<TruckContainerDTO> findById(Long id) {
        return truckContainerRepository.findById(id);
    }

    public Optional<TruckContainerDTO> findByLicense(String licenseNumber) {
        return truckContainerRepository.findByLicense(licenseNumber);
    }

    public Optional<TruckContainerDTO> findByContainer(String container) {
        return truckContainerRepository.findByContainer(container);
    }

    @CacheEvict(cacheNames= "truckContainers", allEntries = true)
    public Optional<TruckContainerDTO> save(TruckContainerDTO truckContainer) {
        return Optional.of(truckContainerRepository.save(truckContainer));
    }

}
