
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
@Table("Transactions")
public class TransactionDTO {
    @Id
    private long id;
    private long tank;
    private long driver;
    private long material;
    private long station;
    private long truckTrailer;
    private long truckContainer;
    private long client;
    private OperationType operationType;
    private Double qty;
    private LocalDateTime dateTime;
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
