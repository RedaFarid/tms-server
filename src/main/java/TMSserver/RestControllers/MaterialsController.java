package TMSserver.RestControllers;


import TMSserver.DAO.MaterialDAO;
import TMSserver.SQL.Entities.MaterialDTO;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MaterialsController {

    private final MaterialDAO materialDAO;

    @GetMapping("/material")
    public Materials getMaterials(){
        return new Materials(Lists.newArrayList(materialDAO.findAll()));
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Materials{
        private List<MaterialDTO> materials;
    }
}
