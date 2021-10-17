package TMSserver.RestControllers;

import TMSserver.SQL.Entities.ComputerDTO;
import TMSserver.Services.ComputersService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ComputersController {

    private final ComputersService computersService;

    @GetMapping("/computers")
    public Computers getComputer(){
        Computers computers;
        try {
            computers = new Computers(computersService.findAll(), null);
        } catch (Exception e) {
            computers = new Computers(null, e);
        }
        return computers;
    }

    @PostMapping("/saveComputer")
    public String  save(@RequestBody ComputerDTO computer){
        String msg = "saved";
        try {
            computersService.save(computer);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @PostMapping("/deleteAllComputers")
    public String deleteAll(){
        String msg = "deleted";
        try {
            computersService.deleteAll();
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Computers{
        private List<ComputerDTO> computers;
        private Exception exception;
    }
}
