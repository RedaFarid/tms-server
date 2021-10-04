package TMSserver.Services;

import TMSserver.DAO.StationDAO;
import TMSserver.SQL.Entities.StationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StationsService {
    private final StationDAO stationDAO;

    public List<StationDTO> findAll() {
        return new ArrayList<>(stationDAO.findAll());
    }

    public Optional<StationDTO> findById(Long id) {
        return stationDAO.findById(id);
    }

    public Optional<StationDTO> findByStationName(String stationName) {
        return stationDAO.findByStationName(stationName);
    }

    public void deleteById(Long id) {
        stationDAO.deleteById(id);
    }

    public void save(StationDTO StationDTO) {
        stationDAO.save(StationDTO);
    }

}
