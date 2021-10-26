package TMSserver;

import TMSserver.SQL.Entities.Authorization.AppUserDTO;
import TMSserver.SQL.Entities.Authorization.RoleRef;
import TMSserver.Services.Authorization.RoleRefService;
import TMSserver.Services.Authorization.RolesService;
import TMSserver.Services.Authorization.UsersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TmsServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(TmsServerApplication.class, args);

    }

//    @Bean
//    CommandLineRunner run (RolesService rolesService, UsersService usersService, RoleRefService roleRefService){
//       return args -> {
////           rolesService.save(new RoleDTO("Admin"));
////           rolesService.save(new RoleDTO("User"));
//
////           usersService.save(new AppUserDTO(3,"ChiefAdmin","99"));
////           usersService.save(new AppUserDTO("User-2","5678"));
//           roleRefService.deleteByRoleRef(new RoleRef(9,7));
////
//       };
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
