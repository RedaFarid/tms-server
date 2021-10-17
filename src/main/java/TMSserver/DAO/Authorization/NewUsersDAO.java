package TMSserver.DAO.Authorization;

import TMSserver.SQL.Entities.Authorization.UserDTO;
import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.ComputerDTO;
import TMSserver.SQL.Repositories.Authorization.UsersRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NewUsersDAO {
    private final UsersRepository usersRepository;

    @Async
    public String createTable() {
        return usersRepository.createTable();
    }

    public List<UserDTO> findAll() {
        return Lists.newArrayList(usersRepository.findAll());
    }

    public void deleteAll() {
        usersRepository.deleteAll();
    }

    public void save(UserDTO userDTO) {
        usersRepository.save(userDTO);
    }

    public Optional<UserDTO> findByName(String name) {
        return usersRepository.findByName(name);
    }

    public Optional<UserDTO> findById(Long id) {
        return usersRepository.findById(id);
    }

    public void deleteById(Long id) {
        usersRepository.deleteById(id);
    }

}
