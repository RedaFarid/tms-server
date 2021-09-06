package TMSserver.Services;

import TMSserver.DAO.ClientsDAO;
import TMSserver.DAO.TruckTrailersDAO;
import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.TruckTrailerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TruckTrailersService {
    private final TruckTrailersDAO truckTrailersDAO;


    public List<TruckTrailerDTO> findAll() {
        return new ArrayList<>(truckTrailersDAO.findAll());
    }

    public List<TruckTrailerDTO> findById(Long id) {
        return truckTrailersDAO.findById(id).stream().collect(Collectors.toList());
    }

    public List<TruckTrailerDTO> findByTrailer(String id) {
        return truckTrailersDAO.findByTrailer(id).stream().collect(Collectors.toList());
    }
    public List<TruckTrailerDTO> findByLicense(String id) {
        return truckTrailersDAO.findByLicense(id).stream().collect(Collectors.toList());
    }


    @Transactional
    public TruckTrailerDTO addNewTruckTrailer(TruckTrailerDTO trailerDTO) {
        truckTrailersDAO.findById(trailerDTO.getId()).ifPresentOrElse(clientDTO -> {

        }, () -> {
            truckTrailersDAO.save(trailerDTO);
        });

        return null;
    }

    @Transactional
    public TruckTrailerDTO updateTrailerData(TruckTrailerDTO trailerDTO) {
        truckTrailersDAO.findById(trailerDTO.getId()).map(clientDTO -> {
            // Update Instructions

            return truckTrailersDAO.save(trailerDTO);
        });


        return null;
    }

}
