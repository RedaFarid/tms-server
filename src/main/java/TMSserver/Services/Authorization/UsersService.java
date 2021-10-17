package TMSserver.Services.Authorization;

import TMSserver.DAO.Authorization.RolesDAO;
import TMSserver.DAO.Authorization.UsersDAO;
import TMSserver.SQL.Entities.Authorization.AppUserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@RequiredArgsConstructor
public class UsersService implements UserDetailsService {

    private final UsersDAO usersDAO;
    private final RolesDAO rolesDAO;

    private final PasswordEncoder passwordEncoder;

    //TODO--modify
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        System.err.println("HEEEEEEEEEEEY");
        AtomicReference<AppUserDTO> appUser = null;

        usersDAO.findByName(userName).ifPresentOrElse(user -> {
           appUser.set(user);

        } ,()->{
            throw new UsernameNotFoundException("USer not found in database");
        });
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.get().getRoles().forEach(roleRef -> {
            //TODO--add if present or else
            String role = rolesDAO.findById(roleRef.getRoleId()).get().getName();
            authorities.add(new SimpleGrantedAuthority(role));
        });
        return new User(appUser.get().getName(),appUser.get().getPassword(),authorities);
    }


    public List<AppUserDTO> findAll() {
        return new ArrayList<>(usersDAO.findAll());
    }

    public Optional<AppUserDTO> findById(Long id) {
        return usersDAO.findById(id);
    }

    public Optional<AppUserDTO> findByName(String name) {
        return usersDAO.findByName(name);
    }

    public void deleteById(Long id) {
        usersDAO.deleteById(id);
    }

    public void save(AppUserDTO appUserDTO) {
        appUserDTO.setPassword(passwordEncoder.encode(appUserDTO.getPassword()));
        usersDAO.save(appUserDTO);
    }

}
