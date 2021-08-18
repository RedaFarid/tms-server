package TMSserver.RestControllers;


import TMSserver.Entities.LogDTO;
import TMSserver.Repositories.LogRepository;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TanksController {

    private final LogRepository logRepository;


    @GetMapping("/tank")
    public Tanks getTanks(){
        return new Tanks(Lists.newArrayList(logRepository.findAll()));
    }

    @PostMapping("/addTank")
    public LogDTO addTank(@RequestBody LogDTO tank){
        System.err.println(tank);
        return tank;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Tanks{
        private List<LogDTO> logs;
    }
}
