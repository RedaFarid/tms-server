package TMSserver.RestControllers;

import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.Services.ClientsService;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ClientsController {
    private final ClientsService clientsService;

    @GetMapping("/clients")
    public Clients getClients(){
        return new Clients(Lists.newArrayList(clientsService.findAll()));

    }

    @PostMapping("/saveClient")
    public String  save(@RequestBody ClientDTO client){
        clientsService.save(client);
        return "saved";
    }

    @GetMapping("/clientById/{id}")
    public Optional<ClientDTO> getClientById(@PathVariable Long id){
        return clientsService.findById(id);
    }

    @GetMapping("/clientByName/{name}")
    public Optional<ClientDTO> getClientByName(@PathVariable String name){
        return clientsService.findByName(name);
    }

    @PostMapping("/deleteClientById")
    public String deleteClientById(@RequestBody Long id){
        clientsService.deleteById(id);
        return "deleted";
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Clients{
        private List<ClientDTO> client;
    }
}
