package TMSserver.RestControllers.Authorization;

import TMSserver.SQL.Entities.Authorization.AppUserDTO;
import TMSserver.SQL.Entities.Authorization.RoleDTO;
import TMSserver.Services.Authorization.RolesService;
import TMSserver.Services.Authorization.UsersService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class RolesController {

    private final RolesService rolesService;

    @GetMapping("/roles")
    public Roles getRoles(){
        Roles roles;
        try {
            roles = new Roles(rolesService.findAll(), null);
        } catch (Exception e) {
            roles = new Roles(null, e);
        }
        return roles;
    }

    @PostMapping("/saveRole")
    public String  save(@RequestBody RoleDTO role){
        String msg = "saved";
        try {
            rolesService.save(role);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/roleById/{id}")
    public Optional<RoleDTO> getRoleById(@PathVariable Long id){
        return rolesService.findById(id);
    }

    @GetMapping("/roleByName/{name}")
    public Optional<RoleDTO> getRoleByName(@PathVariable String name){
        return rolesService.findByName(name);
    }

    @PostMapping("/deleteRoleById")
    public String deleteRoleById(@RequestBody Long id){
        String msg = "deleted";
        try {
            rolesService.deleteById(id);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Roles{
        private List<RoleDTO> role;
        private Exception exception;
    }
}
