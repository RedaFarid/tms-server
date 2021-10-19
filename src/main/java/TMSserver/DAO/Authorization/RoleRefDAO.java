package TMSserver.DAO.Authorization;


import TMSserver.SQL.Repositories.Authorization.RoleRefRepository;
import lombok.RequiredArgsConstructor;
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

}
