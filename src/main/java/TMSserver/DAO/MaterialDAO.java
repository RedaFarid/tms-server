package TMSserver.DAO;

import TMSserver.SQL.Entities.MaterialDTO;
import TMSserver.SQL.Repositories.MaterialRepository;
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
public class MaterialDAO {

    private final MaterialRepository materialRepository;

    @Async
    public String createTable() {
        return materialRepository.createTable();
    }

    //    @Cacheable(cacheNames = "materials", cacheManager = "cacheManagerMaterial")
    @Cacheable("materials")
    public List<MaterialDTO> findAll() {
        return Lists.newArrayList(materialRepository.findAll());
    }

    public Optional<MaterialDTO> findByID(Long id) {
        return materialRepository.findById(id);
    }

    public Optional<MaterialDTO> findByName(String name) {
        return materialRepository.findByName(name);
    }

    @CacheEvict(value = { "materials", "tanks" } , allEntries = true)
    public void deleteById(Long id) {
        materialRepository.deleteById(id);
    }

    @CacheEvict(value = { "materials", "tanks" } , allEntries = true)
    public void save(MaterialDTO materialDTO) {
        materialRepository.save(materialDTO);
    }
}
