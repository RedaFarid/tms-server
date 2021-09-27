package TMSserver.Services;

import TMSserver.DAO.TruckTrailersDAO;
import TMSserver.SQL.Entities.TruckTrailerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TruckTrailersService {
    private final TruckTrailersDAO truckTrailersDAO;

    public List<TruckTrailerDTO> findAll() {
        return new ArrayList<>(truckTrailersDAO.findAll());
    }

    public Optional<TruckTrailerDTO> findById(Long id) {
        return truckTrailersDAO.findById(id);
    }

    public Optional<TruckTrailerDTO> findByContainer(String name) {
        return truckTrailersDAO.findByTrailer(name);
    }

    public Optional<TruckTrailerDTO> findByLicence(String name) {
        return truckTrailersDAO.findByLicense(name);
    }

    public void deleteById(Long id) {
        truckTrailersDAO.deleteById(id);
    }

    public void save(TruckTrailerDTO truckTrailerDTO) {
        truckTrailersDAO.save(truckTrailerDTO);
    }


}
