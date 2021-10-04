package TMSserver.RestControllers;

import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.StationDTO;
import TMSserver.Services.StationsService;
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

public class StationsController {

    private final StationsService stationsService;

    @GetMapping("/stations")
    public Stations getStations() {
        Stations stations;
        try {
            stations = new Stations(Lists.newArrayList(stationsService.findAll()), null);
        } catch (Exception e) {
            stations = new Stations(null, e);
        }
        return stations;

    }

    @PostMapping("/saveStations")
    public String save(@RequestBody StationDTO stationDTO) {
        String msg = "saved";
        try {
            stationsService.save(stationDTO);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/stationsById/{id}")
    public Optional<StationDTO> getStationsById(@PathVariable Long id) {
        return stationsService.findById(id);
    }

    @PostMapping("/deleteStationsById")
    public String deleteStationById(@RequestBody Long id) {
        String msg = "deleted";
        try {
            stationsService.deleteById(id);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/stationByName/{stationName}")
    public Optional<StationDTO> getStationByStationName(@PathVariable String stationName) {
        return stationsService.findByStationName(stationName);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Stations {
        private List<StationDTO> stations;
        private Exception exception;
    }
}
