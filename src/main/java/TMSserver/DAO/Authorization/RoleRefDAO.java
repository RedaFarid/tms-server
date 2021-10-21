package TMSserver.DAO.Authorization;

import TMSserver.SQL.Entities.Authorization.RoleRef;
import TMSserver.SQL.Repositories.Authorization.RoleRefRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RoleRefDAO {
    private final RoleRefRepository roleRefRepository;

    @Async
    public String createTable() {
        return roleRefRepository.createTable();
    }

    public List<Long> findByUserId(Long id) {
        return roleRefRepository.findByUserId(id);
    }
    @Cacheable("roleRef")
    public List<RoleRef> findAll() {
        return Lists.newArrayList(roleRefRepository.findAll());
    }

    @CacheEvict(value = { "roleRef" } , allEntries = true)
    public void save(RoleRef roleRef) {
        roleRefRepository.save(roleRef);
    }

    @CacheEvict(value = { "roles", "roleRef" } , allEntries = true)
    public void deleteByRoleRef(RoleRef roleRef) {
        roleRefRepository.delete(roleRef);
    }

}
