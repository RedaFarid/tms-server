package TMSserver.DAO.Authorization;


import TMSserver.SQL.Entities.Authorization.AppUserDTO;
import TMSserver.SQL.Repositories.Authorization.UserRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsersDAO {

    private final UserRepository userRepository;

    @Async
    public String createTable() {
        return userRepository.createTable();
    }

//    @Cacheable("users")
    public List<AppUserDTO> findAll() {
        return Lists.newArrayList(userRepository.findAll());
    }

    public Optional<AppUserDTO> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<AppUserDTO> findByName(String name) {
        return userRepository.findByName(name);
    }

//    @CacheEvict(cacheNames = "users", allEntries = true)
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

//    @CacheEvict(cacheNames = "users", allEntries = true)
    public void save(AppUserDTO AppUserDTO) {
        userRepository.save(AppUserDTO);
    }

}
