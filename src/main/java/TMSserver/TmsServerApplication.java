package TMSserver;

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
//    CommandLineRunner run (RolesService rolesService,UsersService usersService){
//       return args -> {
////           rolesService.save(new RoleDTO("Admin"));
////           rolesService.save(new RoleDTO("User"));
//
//           usersService.save(new AppUserDTO("ChiefAdmin","1234"));
////           usersService.save(new AppUserDTO("User-2","5678"));
//
////
//       };
//    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
