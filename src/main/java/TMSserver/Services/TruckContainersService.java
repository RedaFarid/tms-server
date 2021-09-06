package TMSserver.Services;

import TMSserver.DAO.TruckContainersDAO;
import TMSserver.SQL.Entities.TruckContainerDTO;
import TMSserver.SQL.Entities.TruckTrailerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TruckContainersService {
    private final TruckContainersDAO truckContainersDAO;


    public List<TruckContainerDTO> findAll() {
        return new ArrayList<>(truckContainersDAO.findAll());
    }

    public List<TruckContainerDTO> findById(Long id) {
        return truckContainersDAO.findById(id).stream().collect(Collectors.toList());
    }

    public List<TruckContainerDTO> findByContainer(String id) {
        return truckContainersDAO.findByContainer(id).stream().collect(Collectors.toList());
    }
    public List<TruckContainerDTO> findByLicense(String id) {
        return truckContainersDAO.findByLicense(id).stream().collect(Collectors.toList());
    }


    @Transactional
    public TruckContainerDTO addNewTruckContainer(TruckContainerDTO containerDTO) {
        truckContainersDAO.findById(containerDTO.getId()).ifPresentOrElse(clientDTO -> {

        }, () -> {
            truckContainersDAO.save(containerDTO);
        });

        return null;
    }

    @Transactional
    public TruckContainerDTO updateContainerData(TruckContainerDTO containerDTO) {
        truckContainersDAO.findById(containerDTO.getId()).map(clientDTO -> {
            // Update Instructions

            return truckContainersDAO.save(containerDTO);
        });


        return null;
    }

}
