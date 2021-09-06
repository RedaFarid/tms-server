package TMSserver.DAO;

import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Entities.TruckTrailerDTO;
import TMSserver.SQL.Repositories.TankRepository;

import TMSserver.SQL.Repositories.TruckTrailerRepository;
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
public class TruckTrailersDAO {

    private final TruckTrailerRepository truckTrailerRepository;


    @Async
    public String createTable() {
        return truckTrailerRepository.createTable();
    }


    @Cacheable("truckTrailers")
    public List<TruckTrailerDTO> findAll() {
        return Lists.newArrayList(truckTrailerRepository.findAll());
    }


    public Optional<TruckTrailerDTO> findById(Long id) {
        return truckTrailerRepository.findById(id);
    }

    public Optional<TruckTrailerDTO> findByLicense(String licenseNumber) {
        return truckTrailerRepository.findByLicense(licenseNumber);
    }

    public Optional<TruckTrailerDTO> findByTrailer(String trailerNumber) {
        return truckTrailerRepository.findByTrailer(trailerNumber);
    }

    public Optional<TruckTrailerDTO> save(TruckTrailerDTO truckTrailerDTO) {
        return Optional.of(truckTrailerRepository.save(truckTrailerDTO));
    }
}
