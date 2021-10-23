
package TMSserver.SQL.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("TruckContainers")
public class TruckContainerDTO {

    @Id
    private Long id;
    private String containerNumber;
    private String licenceNumber;
    private LocalDate licenceExpirationDate;
    private double maximumWeightConstrain;
    private Permissions permissions;
    private String comment;
    @CreatedDate
    private LocalDateTime creationDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String lastModifiedBy;
    private String onTerminal;

    
}
