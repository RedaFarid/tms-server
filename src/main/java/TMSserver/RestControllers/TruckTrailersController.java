package TMSserver.RestControllers;

import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Entities.TruckTrailerDTO;
import TMSserver.SQL.Repositories.TankRepository;
import TMSserver.Services.DriversService;
import TMSserver.Services.TanksService;
import TMSserver.Services.TruckTrailersService;
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

public class TruckTrailersController {

    private final TruckTrailersService truckTrailersService;

    @GetMapping("/truckTrailer")
    public TruckTrailersController.TruckTrailers getTruckTrailers(){
        return new TruckTrailersController.TruckTrailers(Lists.newArrayList(truckTrailersService.findAll()));
    }

    @PostMapping("/addTrailer")
    public TruckTrailerDTO addTrailer(@RequestBody TruckTrailerDTO truckTrailerDTO){
        return truckTrailersService.addNewTruckTrailer(truckTrailerDTO);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TruckTrailers{
        private List<TruckTrailerDTO> truckTrailers;
    }
}
