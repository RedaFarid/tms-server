
package TMSserver.SQL.Entities.Authorization;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("UsersData")
public class UserDTO {
    @Id
    private long userId;
    private String name;
    private String password;

//    @MappedCollection(idColumn = "userId")
//    private Set<RoleRef> roles = new HashSet<>();


}
