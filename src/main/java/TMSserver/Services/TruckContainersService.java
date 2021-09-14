package TMSserver.Services;

import TMSserver.DAO.TruckContainersDAO;
import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.TruckContainerDTO;
import TMSserver.SQL.Entities.TruckTrailerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TruckContainersService {
    private final TruckContainersDAO truckContainersDAO;


    public List<TruckContainerDTO> findAll() {
        return new ArrayList<>(truckContainersDAO.findAll());
    }

    public Optional<TruckContainerDTO> findById(Long id) {
        return truckContainersDAO.findById(id);
    }

    public Optional<TruckContainerDTO> findByContainer(String name) {
        return truckContainersDAO.findByContainer(name);
    }

    public Optional<TruckContainerDTO> findByLicence(String name) {
        return truckContainersDAO.findByLicense(name);
    }

    public void deleteById(Long id) {
        truckContainersDAO.deleteById(id);
    }

    public void save(TruckContainerDTO truckContainerDTO) {
        truckContainersDAO.save(truckContainerDTO);
    }


}
