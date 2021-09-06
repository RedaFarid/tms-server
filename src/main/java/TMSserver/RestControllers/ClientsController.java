package TMSserver.RestControllers;

import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Repositories.TankRepository;
import TMSserver.Services.ClientsService;
import TMSserver.Services.DriversService;
import TMSserver.Services.TanksService;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ClientsController {
    private final ClientsService clientsService;

    @GetMapping("/clients")
    public ClientsController.Clients getClients(){
        return new ClientsController.Clients(Lists.newArrayList(clientsService.findAll()));

    }

    @PostMapping("/addClient")
    public ClientDTO addClient(@RequestBody ClientDTO client){
        return clientsService.addNewClient(client);
    }


    @PostMapping("/updateClientData")
    public ClientDTO updateClient(@RequestBody ClientDTO client){return  clientsService.updateClientData(client);}

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Clients{
        private List<ClientDTO> client;
    }
}
