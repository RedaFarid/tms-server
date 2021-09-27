
package TMSserver.SQL.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("TruckTrailers")
public class TruckTrailerDTO {

    @Id
    private Long id;
    private String trailerNumber;
    private String licenseNumber;
    private Date licenseExpirationDate;
    private String permissions;
    private String comment;
    @CreatedDate
    private LocalDateTime creationDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;
    @CreatedBy
    private String createdBy;
    private String onTerminal;
    
}
