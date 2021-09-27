package TMSserver.RestControllers;

import TMSserver.SQL.Entities.TruckContainerDTO;
import TMSserver.Services.TruckContainersService;
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
public class TruckContainersController {
    private final TruckContainersService truckContainersService;

    @GetMapping("/truckContainers")
    public TruckContainers getTruckContainers(){
        TruckContainers truckContainers;
        try {
            truckContainers = new TruckContainers(Lists.newArrayList(truckContainersService.findAll()), null);
        } catch (Exception e) {
            truckContainers = new TruckContainers(null, e);
        }
        return truckContainers;

    }

    @PostMapping("/saveTruckContainers")
    public String  save(@RequestBody TruckContainerDTO truckContainerDTO){
        String msg = "saved";
        try {
            truckContainersService.save(truckContainerDTO);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/truckContainersById/{id}")
    public Optional<TruckContainerDTO> getTruckContainerById(@PathVariable Long id){
        return truckContainersService.findById(id);
    }

    @PostMapping("/deleteTruckContainerById")
    public String deleteTruckContainersById(@RequestBody Long id){
        String msg = "deleted";
        try {
        truckContainersService.deleteById(id);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }
    @GetMapping("/truckContainersByLicenceNo/{licenceId}")
    public Optional<TruckContainerDTO> getTruckContainerByLicenceId(@PathVariable String licenceId){
        return truckContainersService.findByLicence(licenceId);
    }

    @GetMapping("/truckContainersByContainerNo/{containerNo}")
    public Optional<TruckContainerDTO> getTruckContainersByContainerNo(@PathVariable String containerNo){
        return truckContainersService.findByContainer(containerNo);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TruckContainers{
        private List<TruckContainerDTO> truckContainer;
        private Exception exception;
    }
}
