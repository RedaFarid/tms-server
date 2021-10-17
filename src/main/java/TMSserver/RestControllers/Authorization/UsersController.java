package TMSserver.RestControllers.Authorization;

import TMSserver.SQL.Entities.Authorization.AppUserDTO;
import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.Services.Authorization.UsersService;
import TMSserver.Services.ClientsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UsersController {

    private final UsersService usersService;

    @GetMapping("/users")
    public Users getUsers(){
        Users users;
        try {
            users = new Users(usersService.findAll(), null);
        } catch (Exception e) {
            users = new Users(null, e);
        }
        return users;
    }

    @PostMapping("/saveUser")
    public String  save(@RequestBody AppUserDTO user){
        String msg = "saved";
        try {
            usersService.save(user);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/userById/{id}")
    public Optional<AppUserDTO> getUserById(@PathVariable Long id){
        return usersService.findById(id);
    }

    @GetMapping("/userByName/{name}")
    public Optional<AppUserDTO> getUByName(@PathVariable String name){
        return usersService.findByName(name);
    }

    @PostMapping("/deleteUserById")
    public String deleteUserById(@RequestBody Long id){
        String msg = "deleted";
        try {
            usersService.deleteById(id);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Users{
        private List<AppUserDTO> user;
        private Exception exception;
    }
}
