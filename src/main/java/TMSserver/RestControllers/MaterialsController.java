package TMSserver.RestControllers;


import TMSserver.DAO.MaterialDAO;
import TMSserver.SQL.Entities.MaterialDTO;
import TMSserver.SQL.Entities.TankDTO;
import TMSserver.Services.MaterialsService;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class MaterialsController {

    private final MaterialsService materialsService;

    @GetMapping("/material")
    public Materials getMaterials(){
        return new Materials(Lists.newArrayList(materialsService.findAll()));
    }

    @GetMapping("/materialByID/{id}")
    public Optional<MaterialDTO> getMaterialById(@PathVariable Long id){
        return materialsService.findByID(id);
    }

    @PostMapping("/deleteMaterialByID")
    public String  deleteMaterialById(@RequestBody Long id){
         materialsService.deleteById(id);
         return "deleted";
    }

    @PostMapping("/saveMaterial")
    public String save(@RequestBody MaterialDTO materialDTO){
        materialsService.save(materialDTO);
        return "saved";
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Materials{
        private List<MaterialDTO> materials;
    }
}
