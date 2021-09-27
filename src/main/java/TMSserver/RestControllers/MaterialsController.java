package TMSserver.RestControllers;


import TMSserver.SQL.Entities.MaterialDTO;
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
        Materials materials;
        try {
            materials = new Materials(Lists.newArrayList(materialsService.findAll()),null);
        } catch (Exception e) {
            materials = new Materials(null, e);
        }
        return materials;
    }

    @GetMapping("/materialByID/{id}")
    public Optional<MaterialDTO> getMaterialById(@PathVariable Long id){
        return materialsService.findByID(id);
    }

    @GetMapping("/materialByName/{name}")
    public Optional<MaterialDTO> getMaterialByName(@PathVariable String name){
        return materialsService.findByName(name);
    }

    @PostMapping("/deleteMaterialByID")
    public String  deleteMaterialById(@RequestBody Long id){
        String msg = "deleted";
        try {
            materialsService.deleteById(id);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }

    @PostMapping("/saveMaterial")
    public String save(@RequestBody MaterialDTO materialDTO){

        String msg = "saved";
        try {
            materialsService.save(materialDTO);
        }
        catch (Exception e){
            msg = e.getMessage();
        }
        return msg;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Materials{
        private List<MaterialDTO> materials;
        private Exception exception;
    }
}
