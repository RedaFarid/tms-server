package TMSserver.Services.Authorization;

import TMSserver.DAO.Authorization.RolesDAO;
import TMSserver.SQL.Entities.Authorization.RoleDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RolesService {
    private final RolesDAO rolesDAO;

    public List<RoleDTO> findAll() {
        return new ArrayList<>(rolesDAO.findAll());
    }

    public Optional<RoleDTO> findById(Long id) {
        return rolesDAO.findById(id);
    }

    public Optional<RoleDTO> findByName(String name) {
        return rolesDAO.findByName(name);
    }

    public void deleteById(Long id) {
        rolesDAO.deleteById(id);
    }

    public void save(RoleDTO RoleDTO) {
        rolesDAO.save(RoleDTO);
    }


}
