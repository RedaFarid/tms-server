package TMSserver.DAO;

import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Repositories.ClientRepository;
import TMSserver.SQL.Repositories.DriverRepository;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Here you can cache data from database
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



    public Optional<ClientDTO> save(ClientDTO client) {
        return Optional.of(clientRepository.save(client));
    }
}
