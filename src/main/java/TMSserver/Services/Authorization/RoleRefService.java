package TMSserver.Services.Authorization;

import TMSserver.DAO.Authorization.RoleRefDAO;
import TMSserver.SQL.Entities.Authorization.RoleDTO;
import TMSserver.SQL.Entities.Authorization.RoleRef;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleRefService {
    private final RoleRefDAO roleRefDAO;

    public List<RoleRef> findAll() {
        return new ArrayList<>(roleRefDAO.findAll());
    }

    public void deleteByRoleRef(RoleRef roleRef) {
        roleRefDAO.deleteByRoleRef(roleRef);
    }

    public void save(RoleRef roleRef) {
        roleRefDAO.save(roleRef);
    }


}
