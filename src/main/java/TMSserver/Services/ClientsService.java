package TMSserver.Services;

import TMSserver.DAO.ClientsDAO;
import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.MaterialDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientsService {
    private final ClientsDAO clientsDAO;

    public List<ClientDTO> findAll() {
        return new ArrayList<>(clientsDAO.findAll());
    }

    public Optional<ClientDTO> findById(Long id) {
        return clientsDAO.findById(id);
    }

    public Optional<ClientDTO> findByName(String name) {
        return clientsDAO.findByName(name);
    }

    public void deleteById(Long id) {
        clientsDAO.deleteById(id);
    }

    public void save(ClientDTO clientDTO) {
        clientsDAO.save(clientDTO);
    }


}
