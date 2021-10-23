
package TMSserver.SQL.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("Drivers")
public class DriverDTO {

    @Id
    private Long id;
    private String licenseNumber;
    private String name;
    private LocalDate licenceExpirationDate;
    private String mobileNumber;
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

    @Override
    public String toString() {
        return "DriverDTO{" +
                "id=" + id +
                ", licenceNumber='" + licenseNumber + '\'' +
                ", name='" + name + '\'' +
                ", licenceExpirationDate=" + licenceExpirationDate +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", permissions='" + permissions + '\'' +
                ", comment='" + comment + '\'' +
                ", creationDate=" + creationDate +
                ", modifyDate=" + modifyDate +
                ", createdBy='" + createdBy + '\'' +
                ", onTerminal='" + onTerminal + '\'' +
                '}';
    }
}
