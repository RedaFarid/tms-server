package TMSserver.Services;

import TMSserver.DAO.DriverDAO;
import TMSserver.DAO.TankDAO;
import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.TankDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DriversService {
    private final DriverDAO driverDAO;


    public List<DriverDTO> findAll() {
        return new ArrayList<>(driverDAO.findAll());
    }

    public List<DriverDTO> findByLicenseNumber( String license) {
        return driverDAO.findByLicenseNumber(license).stream().collect(Collectors.toList());
    }

    @Transactional
    public DriverDTO addNewDriver(DriverDTO driver) {
        driverDAO.findByLicenseNumber(driver.getLicenceNumber()).ifPresentOrElse(DriverDTO -> {

        }, () -> {
            driverDAO.save(driver);
        });

        return null;
    }

    @Transactional
    public DriverDTO updateDriverData(DriverDTO driver) {
        driverDAO.findByLicenseNumber(driver.getLicenceNumber()).map(driverDTO -> {
           // Update Instructions

            return driverDAO.save(driver);
        });


        return null;
    }
}
