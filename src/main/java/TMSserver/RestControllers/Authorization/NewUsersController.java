package TMSserver.RestControllers.Authorization;

import TMSserver.SQL.Entities.Authorization.UserDTO;
import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.Services.Authorization.NewUsersService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class NewUsersController {

    private final NewUsersService newUsersService;

    @GetMapping("/UserDTOs")
    public Users getUser(){
        Users users;
        try {
            users = new Users(newUsersService.findAll(), null);
        } catch (Exception e) {
            users = new Users(null, e);
        }
        return users;
    }

    @PostMapping("/saveUserDTO")
    public String save(@RequestBody UserDTO userDTO){
        String msg = "saved";
        try {
            newUsersService.save(userDTO);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @GetMapping("/UseDTOrById/{id}")
    public Optional<UserDTO> getById(@PathVariable Long id){
        return newUsersService.findById(id);
    }

    @GetMapping("/newUserByName/{name}")
    public Optional<UserDTO> getByName(@PathVariable String name){
        return newUsersService.findByName(name);
    }

    @PostMapping("/deleteUserDTOById")
    public String deleteUserDTOById(@RequestBody Long id){
        String msg = "deleted";
        try {
            newUsersService.deleteById(id);
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
        private List<UserDTO> userDTOS;
        private Exception exception;
    }
}
