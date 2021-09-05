package TMSserver.DAO;

import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Repositories.DriverRepository;

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
public class DriverDAO {

    private final DriverRepository driverRepository;

    @Async
    public String createTable() {
        return driverRepository.createTable();
    }


    @Cacheable("drivers")
    public List<DriverDTO> findAll() {
        return Lists.newArrayList(driverRepository.findAll());
    }


    public Optional<DriverDTO> findById(Long id) {
        return driverRepository.findById(id);
    }

    public Optional<DriverDTO> findByLicenseNumber(String licenseNumber) {
        return driverRepository.findByLicenseNumber(licenseNumber);
    }

    public Optional<DriverDTO> save(DriverDTO driver) {
        return Optional.of(driverRepository.save(driver));
    }
}
