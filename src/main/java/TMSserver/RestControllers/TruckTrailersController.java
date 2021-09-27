package TMSserver.RestControllers;

import TMSserver.SQL.Entities.TruckTrailerDTO;
import TMSserver.Services.TruckTrailersService;
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

public class TruckTrailersController {

    private final TruckTrailersService truckTrailersService;

    @GetMapping("/truckTrailers")
    public TruckTrailers getTruckTrailers() {
        TruckTrailers truckTrailers;
        try {
            truckTrailers = new TruckTrailers(Lists.newArrayList(truckTrailersService.findAll()), null);
        } catch (Exception e) {
            truckTrailers = new TruckTrailers(null, e);
        }
        return truckTrailers;
    }

    @PostMapping("/saveTruckTrailers")
    public String save(@RequestBody TruckTrailerDTO truckTrailerDTO) {
        String msg = "saved";
        try {
            truckTrailersService.save(truckTrailerDTO);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/truckTrailerById/{id}")
    public Optional<TruckTrailerDTO> getTruckTrailersById(@PathVariable Long id) {
        return truckTrailersService.findById(id);
    }

    @PostMapping("/deleteTruckTrailerById")
    public String deleteTruckTrailersById(@RequestBody Long id) {
        String msg = "deleted";
        try {
            truckTrailersService.deleteById(id);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/truckTrailersByLicenceNo/{licenceId}")
    public Optional<TruckTrailerDTO> getTrailerByLicenceId(@PathVariable String licenceId) {
        return truckTrailersService.findByLicence(licenceId);
    }

    @GetMapping("/truckContainersByTrailerNo/{trailerNo}")
    public Optional<TruckTrailerDTO> getTruckTrailersByContainerNo(@PathVariable String trailerNo) {
        return truckTrailersService.findByContainer(trailerNo);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class TruckTrailers {
        private List<TruckTrailerDTO> truckTrailers;
        private Exception exception;
    }
}
