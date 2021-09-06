package TMSserver.Services;

import TMSserver.DAO.TankDAO;
import TMSserver.SQL.Entities.TankDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TanksService {

    private final TankDAO tankDAO;


    public List<TankDTO> findAll() {
        return tankDAO.findAll().stream().peek(this::calculateQty).collect(Collectors.toList());
    }



    private TankDTO calculateQty(TankDTO tankDTO) {
        return tankDTO;
    }

    @Transactional
    public TankDTO addNewTank(TankDTO tank) {
        tankDAO.findByNameAndStation(tank.getId()).ifPresentOrElse(tankDTO -> {

        }, () -> {
            tankDAO.save(tank);
        });

        return null;
    }

    @Transactional
    public TankDTO updateTankData(TankDTO tank) {
        tankDAO.findByNameAndStation(tank.getId()).map(tankDTO -> {
            tankDTO.setCapacity(tank.getCapacity());
            // and so on

            return tankDAO.save(tankDTO);
        }).map(this::calculateQtyOptional).get();


        return null;
    }

    private Optional<TankDTO> calculateQtyOptional(Optional<TankDTO> tankDTO) {
        return Optional.of(calculateQty(tankDTO.get()));
    }
}
