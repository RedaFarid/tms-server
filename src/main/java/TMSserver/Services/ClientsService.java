package TMSserver.Services;

import TMSserver.DAO.ClientsDAO;
import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.DriverDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ClientsService {
    private final ClientsDAO clientsDAO;


    public List<ClientDTO> findAll() {
        return new ArrayList<>(clientsDAO.findAll());
    }

    public List<ClientDTO> findById(Long id) {
        return clientsDAO.findById(id).stream().collect(Collectors.toList());
    }

    @Transactional
    public ClientDTO addNewClient(ClientDTO client) {
        clientsDAO.findById(client.getId()).ifPresentOrElse(clientDTO -> {

        }, () -> {
            clientsDAO.save(client);
        });

        return null;
    }

    @Transactional
    public ClientDTO updateClientData(ClientDTO client) {
        clientsDAO.findById(client.getId()).map(clientDTO -> {
            // Update Instructions

            return clientsDAO.save(client);
        });


        return null;
    }
}
