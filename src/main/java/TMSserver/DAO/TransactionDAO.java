package TMSserver.DAO;

import TMSserver.SQL.Entities.TransactionDTO;
import TMSserver.SQL.Repositories.TransactionRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TransactionDAO {

    private final TransactionRepository transactionRepository;

    @Async
    public String createTable() {
        return transactionRepository.createTable();
    }

    @Cacheable("transactions")
    public List<TransactionDTO> findAll() {
        return Lists.newArrayList(transactionRepository.findAll());
    }

    public Optional<TransactionDTO> findById(Long id) {
        return transactionRepository.findById(id);
    }

    @CacheEvict(cacheNames = "transactions", allEntries = true)
    public void deleteById(Long id) {
        transactionRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "transactions", allEntries = true)
    public void save(TransactionDTO TransactionDTO) {
        transactionRepository.save(TransactionDTO);
    }
}
