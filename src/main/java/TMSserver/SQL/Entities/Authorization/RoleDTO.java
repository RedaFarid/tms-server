package TMSserver.SQL.Entities.Authorization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("Roles")
public class RoleDTO {
    @Id
    private long id;
    private String name;

    public RoleDTO(String name) {
        this.name = name;
    }
}
