package TMSserver.Services;

import TMSserver.DAO.MaterialDAO;
import TMSserver.SQL.Entities.MaterialDTO;
import TMSserver.SQL.Entities.TruckContainerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@RequiredArgsConstructor
@Service
public class MaterialService {
    private final MaterialDAO materialDAO;


    public List<MaterialDTO> findAll() {
        return new ArrayList<>(materialDAO.findAll());
    }

    public List<MaterialDTO> findById(Long id) {
        return materialDAO.findById(id).stream().collect(Collectors.toList());
    }



    @Transactional
    public MaterialDTO addNewMaterial(MaterialDTO materialDTO) {
        materialDAO.findById(materialDTO.getId()).ifPresentOrElse(clientDTO -> {

        }, () -> {
            materialDAO.save(materialDTO);
        });

        return null;
    }

    @Transactional
    public MaterialDTO  updateMaterialData(MaterialDTO materialDTO) {
        materialDAO.findById(materialDTO.getId()).map(clientDTO -> {
            // Update Instructions

            return materialDAO.save(materialDTO);
        });


        return null;
    }
}
