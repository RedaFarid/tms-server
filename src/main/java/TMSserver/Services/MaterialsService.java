package TMSserver.Services;

import TMSserver.DAO.MaterialDAO;
import TMSserver.DAO.TankDAO;
import TMSserver.SQL.Entities.MaterialDTO;
import TMSserver.SQL.Entities.TankDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MaterialsService {

    private final MaterialDAO materialDAO;

    public List<MaterialDTO> findAll() {
        return materialDAO.findAll();
    }

    public Optional<MaterialDTO> findByID(Long id) {
        return materialDAO.findByID(id);
    }

    public Optional<MaterialDTO> findByName(String name) {
        return materialDAO.findByName(name);
    }

    public void deleteById(Long id) {
        materialDAO.deleteById(id);
    }

    public void save(MaterialDTO materialDTO) {
        materialDAO.save(materialDTO);
    }
}
