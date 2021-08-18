package TMSserver.RestControllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TanksController {


    @GetMapping("/tank")
    public String getTanks(){
        return "Tank - 1";
    }
}
