package TMSserver.Services.Authorization;

import TMSserver.DAO.Authorization.NewUsersDAO;
import TMSserver.SQL.Entities.Authorization.UserDTO;
import TMSserver.SQL.Entities.ClientDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewUsersService {
    private final NewUsersDAO usersDAO;

    public List<UserDTO> findAll() {
        return new ArrayList<>(usersDAO.findAll());
    }

    public Optional<UserDTO> findByName(String name) {
        return usersDAO.findByName(name);
    }

    public void save(UserDTO userDTO) {
        usersDAO.save(userDTO);
    }

    public Optional<UserDTO> findById(Long id) {
        return usersDAO.findById(id);
    }

    public void deleteById(Long id) {
        usersDAO.deleteById(id);
    }

}
