package TMSserver.RestControllers;


import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Repositories.TankRepository;
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
public class TanksController {

    private final TanksService tanksService;

    @GetMapping("/tank")
    public Tanks getTanks(){
        return new Tanks(Lists.newArrayList(tanksService.findAll()));
    }

    @PostMapping("/addTank")
    public TankDTO addTank(@RequestBody TankDTO tank){
        return tanksService.addNewTank(tank);
    }


    @PostMapping("/updateTankData")
    public TankDTO updateTank(@RequestBody TankDTO tankDTO){return  tanksService.updateTankData(tankDTO);}

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tanks{
        private List<TankDTO> tanks;
    }
}
