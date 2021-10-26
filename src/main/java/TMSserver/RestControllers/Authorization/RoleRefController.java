package TMSserver.RestControllers.Authorization;

import TMSserver.SQL.Entities.Authorization.RoleRef;
import TMSserver.Services.Authorization.RoleRefService;
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
public class RoleRefController {

    private final RoleRefService roleRefService;

    @GetMapping("/roleRefs")
    public RoleRefs getRoleRefs(){
        RoleRefs roleRefs;
        try {
            roleRefs = new RoleRefs(roleRefService.findAll(), null);
        } catch (Exception e) {
            roleRefs = new RoleRefs(null, e);
        }
        return roleRefs;
    }

    @PostMapping("/saveRoleRef")
    public String  save(@RequestBody RoleRef roleRef){
        String msg = "saved";
        try {
            roleRefService.save(roleRef);;
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @PostMapping("/deleteByRoleRef")
    public String deleteByRoleRef(@RequestBody RoleRef roleRef){
        String msg = "deleted";
        try {
            roleRefService.deleteByRoleRef(roleRef);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RoleRefs{
        private List<RoleRef> roleRefs;
        private Exception exception;
    }
}
