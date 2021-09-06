package TMSserver.RestControllers;


import TMSserver.SQL.Entities.MaterialDTO;
import TMSserver.SQL.Entities.TruckContainerDTO;
import TMSserver.Services.MaterialService;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MaterialsController {

    private final MaterialService materialService;

    @GetMapping("/material")
    public Materials getMaterials(){
        return new Materials(Lists.newArrayList(materialService.findAll()));
    }

    @PostMapping("/addMaterial")
    public MaterialDTO addMaterial(@RequestBody MaterialDTO materialDTO){
        return materialService.addNewMaterial(materialDTO);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Materials{
        private List<MaterialDTO> materials;
    }
}
