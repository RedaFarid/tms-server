package TMSserver.DAO.Authorization;


import TMSserver.SQL.Entities.Authorization.RoleDTO;
import TMSserver.SQL.Repositories.Authorization.RoleRepository;
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
public class RolesDAO {
    private final RoleRepository roleRepository;

    @Async
    public String createTable() {
        return roleRepository.createTable();
    }

    @Async
    public String createRoleRefTable() {
        return roleRepository.createRoleRefTable();
    }

    @Cacheable("roles")
    public List<RoleDTO> findAll() {
        return Lists.newArrayList(roleRepository.findAll());
    }

    public Optional<RoleDTO> findById(Long id) {
        return roleRepository.findById(id);
    }

    public Optional<RoleDTO> findByName(String name) {
        return roleRepository.findByName(name);
    }

    @CacheEvict(value = { "roles", "roleRef" } , allEntries = true)
    public void deleteById(Long id) {
        roleRepository.deleteById(id);
    }

    @CacheEvict(value = { "roles", "roleRef" } , allEntries = true)
    public void save(RoleDTO roleDTO) {
        roleRepository.save(roleDTO);
    }

}
