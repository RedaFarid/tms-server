package TMSserver.RestControllers;

import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.Services.DriversService;
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
    public Drivers getDrivers(){
        Drivers drivers;
        try {
            drivers = new Drivers(Lists.newArrayList(driversService.findAll()), null);
        } catch (Exception e) {
            drivers = new Drivers(null, e);
        }
        return drivers;

    }

    @PostMapping("/saveDriver")
    public String  save(@RequestBody DriverDTO driverDTO){
        String msg = "saved";
        try {
            driversService.save(driverDTO);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/driverById/{id}")
    public Optional<DriverDTO> getDriverById(@PathVariable Long id){
        return driversService.findById(id);
    }

    @PostMapping("/deleteDriverById")
    public String deleteClientById(@RequestBody Long id){
        String msg = "deleted";
        try {
            driversService.deleteById(id);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/driverByLicenceId/{licenceId}")
    public Optional<DriverDTO> getDriverByLicenceId(@PathVariable String licenceId){
        return driversService.findByLicenceId(licenceId);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Drivers{
        private List<DriverDTO> drivers;
        private Exception exception;
    }
}
