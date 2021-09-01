package TMSserver.Services;

import TMSserver.SQL.DAO.LogDAO;
import TMSserver.SQL.Entities.LogDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final LogDAO logDAO;

    @Transactional
    public String addNewTransaction(LogDTO logDTO, String var, String var2){

        logDAO.findAllLogs();

        return "";
    }

}
