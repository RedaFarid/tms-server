package TMSserver.RestControllers;

import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.LogDTO;
import TMSserver.Services.LogsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LogController {

    private final LogsService logsService;

    @GetMapping("/logs")
    public Logs getLogs() {
        Logs logs;
        try {
            logs = new Logs(logsService.findAll(), null);
        } catch (Exception e) {
            logs = new Logs(null, e);
        }
        return logs;
    }

    @PostMapping("/saveLog")
    public String save(@RequestBody LogDTO logDTO) {
        String msg = "saved";
        try {
            logsService.save(logDTO);
        } catch (Exception e) {
            msg = e.getMessage();
        }
        return msg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Logs {
        private List<LogDTO> logs;
        private Exception exception;
    }
}
