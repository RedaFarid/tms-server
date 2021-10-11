package TMSserver.Services;

import TMSserver.DAO.TankDAO;
import TMSserver.DAO.TransactionDAO;
import TMSserver.SQL.Entities.OperationType;
import TMSserver.SQL.Entities.TankDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TanksService {

    private final TankDAO tankDAO;

    private final TransactionDAO transactionDAO;

    public List<TankDTO> findAll() {
        return tankDAO.findAll().stream().map(this::calculateQty).collect(Collectors.toList());
    }

    private TankDTO calculateQty(TankDTO tankDTO) {
        double qty = tankDTO.getQty();
        AtomicReference<Double> transactionQty = new AtomicReference<>(0.0);
        transactionDAO.findByTankIdAndDate(tankDTO.getId(),tankDTO.getDateOfQtySet()).ifPresentOrElse(transactionDTOS -> {
            transactionDTOS.stream().forEach(transaction-> {
                if(transaction.getOperationType().equals(OperationType.In)){
                    transactionQty.updateAndGet(v -> v + transaction.getQty());
                }
                if(transaction.getOperationType().equals(OperationType.Out)){
                    transactionQty.updateAndGet(v -> v - transaction.getQty());
                }
            });
        },()->{
            transactionQty.set(0.0);
        });
        tankDTO.setCalculatedQty(qty + transactionQty.get());

        return tankDTO;
    }

    public Optional<TankDTO> findById(Long id) {
        return tankDAO.findById(id).map(this::calculateQty);
    }

    public Optional<TankDTO> findByNameAndStation(String name, Long station) {
        return tankDAO.findByNameAndStation(name, station).map(this::calculateQty);
    }

    public void deleteById(Long id) {
        tankDAO.deleteById(id);
    }

    public void save(TankDTO tankDTO) {
        tankDAO.save(tankDTO);
    }

    public List<TankDTO> findByMaterialAndStation(Long materialId, Long stationId) {
        return tankDAO.findByMaterialAndStation(materialId,stationId).stream().map(this::calculateQty).collect(Collectors.toList());
    }
}
