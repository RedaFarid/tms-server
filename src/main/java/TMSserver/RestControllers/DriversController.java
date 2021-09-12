package TMSserver.RestControllers;

import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Repositories.TankRepository;
import TMSserver.Services.DriversService;
import TMSserver.Services.TanksService;
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

public class DriversController {

    private final DriversService driversService;

    @GetMapping("/drivers")
    public Drivers getClients(){
        return new Drivers(Lists.newArrayList(driversService.findAll()));

    }

    @PostMapping("/saveDriver")
    public String  save(@RequestBody DriverDTO driverDTO){
        driversService.save(driverDTO);
        return "saved";
    }

    @GetMapping("/driverById/{id}")
    public Optional<DriverDTO> getClientById(@PathVariable Long id){
        return driversService.findById(id);
    }

    @PostMapping("/deleteDriverById")
    public String deleteClientById(@RequestBody Long id){
        driversService.deleteById(id);
        return "deleted";
    }
    @GetMapping("/driverByLicenceId/{licenceId}")
    public Optional<DriverDTO> getClientById(@PathVariable String licenceId){
        return driversService.findByLicenceId(licenceId);
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Drivers{
        private List<DriverDTO> drivers;
    }
}
