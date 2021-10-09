package TMSserver.Services;

import TMSserver.DAO.TransactionDAO;
import TMSserver.SQL.Entities.TransactionDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionsService {
    private final TransactionDAO TransactionDAO;

    public List<TransactionDTO> findAll() {
        return new ArrayList<>(TransactionDAO.findAll());
    }

    public Optional<TransactionDTO> findById(Long id) {
        return TransactionDAO.findById(id);
    }

    public void deleteById(Long id) {
        TransactionDAO.deleteById(id);
    }

    public void save(TransactionDTO TransactionDTO) {
        TransactionDAO.save(TransactionDTO);
    }

}
