package TMSserver.SQL.Entities.Authorization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("Users")
public class AppUserDTO {

    @Id
    private long userId;
    private String name;
    private String password;

    @MappedCollection(idColumn = "userId")
    private Set<RoleRef> roles = new HashSet<>();

    public AppUserDTO(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
