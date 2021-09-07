package TMSserver.DAO;

import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.MaterialDTO;
import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Repositories.ClientRepository;
import TMSserver.SQL.Repositories.DriverRepository;

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
public class ClientsDAO {
    private final ClientRepository clientRepository;

    @Async
    public String createTable() {
        return clientRepository.createTable();
    }

    @Cacheable("clients")
    public List<ClientDTO> findAll() {
        return Lists.newArrayList(clientRepository.findAll());
    }

    public Optional<ClientDTO> findById(Long id) {
        return clientRepository.findById(id);
    }

    @CacheEvict(cacheNames = "clients", allEntries = true)
    public void deleteById(Long id) {
        clientRepository.deleteById(id);
    }

    @CacheEvict(cacheNames = "clients", allEntries = true)
    public void save(ClientDTO clientDTO) {
        clientRepository.save(clientDTO);
    }

}
