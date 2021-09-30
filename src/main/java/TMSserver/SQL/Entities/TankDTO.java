
package TMSserver.SQL.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("Tanks")
public class TankDTO {
    @Id
    private Long id;
    private String name;
    //TODO-- needs relation
    private String station;
    private double capacity = 0.0;
    private double qty = 0.0;
    private LocalDateTime dateOfQtySet;
    private String userOfQtySet;
    private Long materialID;
    @CreatedDate
    private LocalDateTime creationDate;
    @LastModifiedDate
    private LocalDateTime modificationDate;
    @CreatedBy
    private String createdBy;
    private String onTerminal;

    @Transient
    private double calculatedQty;
}
