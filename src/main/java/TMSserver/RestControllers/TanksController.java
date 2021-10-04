package TMSserver.RestControllers;

import TMSserver.SQL.Entities.TankDTO;
import TMSserver.Services.TanksService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class TanksController {

    private final TanksService tanksService;

    @GetMapping("/tanks")
    public Tanks getTanks() {
        Tanks tanks;
        try {
            tanks = new Tanks(tanksService.findAll(), null);
        } catch (Exception e) {
            tanks = new Tanks(null, e);
        }
        return tanks;
    }

    @PostMapping("/saveTank")
    public String save(@RequestBody TankDTO tank) {
        String msg = "saved";
        try {
            tanksService.save(tank);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/tankById/{id}")
    public Optional<TankDTO> getTankById(@PathVariable Long id) {
        return tanksService.findById(id);
    }

    @GetMapping("/tankByNameAndStation/{name}/{station}")
    public Optional<TankDTO> getTankByName(@PathVariable String name, @PathVariable Long station) {
        return tanksService.findByNameAndStation(name, station);
    }

    @PostMapping("/deleteTankById")
    public String deleteTankById(@RequestBody Long id) {
        String msg = "deleted";
        try {
            tanksService.deleteById(id);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tanks {
        private List<TankDTO> tank;
        private Exception exception;
    }
//
//    @GetMapping("/tank")
//    public Tanks getTanks(){
//        return new Tanks(Lists.newArrayList(tanksService.findAll()));
//    }
//
//    @PostMapping("/addTank")
//    public TankDTO addTank(@RequestBody TankDTO tank){
//        return tanksService.addNewTank(tank);
//    }
//
//
//    @PostMapping("/updateTankData")
//    public TankDTO updateTank(@RequestBody TankDTO tankDTO){return  tanksService.updateTankData(tankDTO);}
//
//    @Data
//    @AllArgsConstructor
//    @NoArgsConstructor
//    public static class Tanks{
//        private List<TankDTO> tanks;
//    }
}
