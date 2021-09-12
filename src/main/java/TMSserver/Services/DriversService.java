package TMSserver.Services;

import TMSserver.DAO.DriverDAO;
import TMSserver.DAO.TankDAO;
import TMSserver.SQL.Entities.ClientDTO;
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

    public Optional<DriverDTO> findById(Long id) {
        return driverDAO.findById(id);
    }

    public Optional<DriverDTO> findByLicenceId(String licenceId) {
        return driverDAO.findByLicenseNumber(licenceId);
    }

    public void deleteById(Long id) {
        driverDAO.deleteById(id);
    }

    public void save(DriverDTO driverDTO) {
        driverDAO.save(driverDTO);
    }

}
