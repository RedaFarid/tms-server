package TMSserver.Services;

import TMSserver.DAO.LogDAO;
import TMSserver.SQL.Entities.LogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LogsService {
    private final LogDAO logDAO;

    public List<LogDTO> findAll() {
        return new ArrayList<>(logDAO.findAll());
    }

    public void save(LogDTO LogDTO) {
        logDAO.save(LogDTO);
    }

}
