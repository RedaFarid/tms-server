package TMSserver.SQL.DAO;

import TMSserver.SQL.Repositories.TankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


//Here you can cache data from database
@Service
@RequiredArgsConstructor
public class TankDAO {

 private final TankRepository tankRepository;

    @Async
    public String createTable() {
        return tankRepository.createTable();
    }


}
