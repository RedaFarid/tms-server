package TMSserver.RestControllers;

import TMSserver.SQL.Entities.TruckContainerDTO;
import TMSserver.SQL.Entities.TruckTrailerDTO;
import TMSserver.Services.TruckContainersService;
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
public class TruckContainersController {
    private final TruckContainersService truckContainersService;

    @GetMapping("/truckContainer")
    public TruckContainersController.TruckContainers getTruckTrailers(){
        return new TruckContainersController.TruckContainers(Lists.newArrayList(truckContainersService.findAll()));
    }

    @PostMapping("/addContainer")
    public TruckContainerDTO addContainer(@RequestBody TruckContainerDTO truckContainerDTO){
        return truckContainersService.addNewTruckContainer(truckContainerDTO);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TruckContainers{
        private List<TruckContainerDTO> truckContainer;
    }
}
