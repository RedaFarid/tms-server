package TMSserver.DAO;

import TMSserver.SQL.Entities.MaterialDTO;
import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Repositories.MaterialRepository;
import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MaterialDAO {

 private final MaterialRepository materialRepository;

    @Async
    public String createTable() {
        return materialRepository.createTable();
    }

    @Cacheable("materials")
    public List<MaterialDTO> findAll() {
        return Lists.newArrayList(materialRepository.findAll());
    }

    public Optional<MaterialDTO> findById(Long id) {
        return materialRepository.findById(id);
    }

    public Optional<MaterialDTO> save(MaterialDTO materialDTO) {
        return Optional.of(materialRepository.save(materialDTO));
    }
}
