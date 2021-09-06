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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor

public class DriversController {

    private final DriversService driversService;


    @GetMapping("/driver")
    public DriversController.Drivers getDrivers(){
        return new DriversController.Drivers(Lists.newArrayList(driversService.findAll()));
    }

    @PostMapping("/addDriver")
    public DriverDTO addDriver(@RequestBody DriverDTO driver){
        return driversService.addNewDriver(driver);
    }



    @PostMapping("/updateDriverData")
    public DriverDTO updateDriver(@RequestBody DriverDTO driverDTO){return  driversService.updateDriverData(driverDTO);}


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Drivers{
        private List<DriverDTO> drivers;
    }
}
