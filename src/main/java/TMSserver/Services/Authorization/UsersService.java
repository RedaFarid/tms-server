package TMSserver.Services.Authorization;

import TMSserver.DAO.Authorization.RoleRefDAO;
import TMSserver.DAO.Authorization.RolesDAO;
import TMSserver.DAO.Authorization.UsersDAO;
import TMSserver.SQL.Entities.Authorization.AppUserDTO;
import lombok.RequiredArgsConstructor;
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
    private final RoleRefDAO roleRefDAO;

    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {

        AppUserDTO appUser = new AppUserDTO();

        usersDAO.findByName(userName).ifPresentOrElse(user -> {
            appUser.setUserId(user.getUserId());
            appUser.setPassword(user.getPassword());
            appUser.setName(user.getName());

        }, () -> {
            throw new UsernameNotFoundException("USer not found in database");
        });
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        roleRefDAO.findByUserId(appUser.getUserId())
                .forEach(roleId -> {
                    AtomicReference<String> role = new AtomicReference<>("");
                    rolesDAO.findById(roleId).ifPresentOrElse(item -> {
                        role.set(item.getName());
                    }, () -> {
                        role.set("Unassigned authority");
                    });
                    authorities.add(new SimpleGrantedAuthority(role.get()));
                });
        return new User(appUser.getName(), appUser.getPassword(), authorities);
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
