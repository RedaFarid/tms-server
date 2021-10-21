package TMSserver.SQL.Entities.Authorization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.relational.core.mapping.Table;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("RoleRef")
public class RoleRef {
    private long roleId;
    private long userId;
}
