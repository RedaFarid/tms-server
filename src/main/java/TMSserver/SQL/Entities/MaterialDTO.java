
package TMSserver.SQL.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("Materials")
public class MaterialDTO {

    @Id
    private Long id;
    private String name;
    private String description;

    @CreatedDate
    private LocalDateTime creationDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;
    @CreatedBy
    private String createdBy;
    private String onTerminal;

    @Override
    public String toString() {
        return "MaterialDTO{" +
                "id=" + id +
                ", Name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", modifyDate=" + modifyDate +
                ", createdBy='" + createdBy + '\'' +
                ", onTerminal='" + onTerminal + '\'' +
                '}';
    }
}
