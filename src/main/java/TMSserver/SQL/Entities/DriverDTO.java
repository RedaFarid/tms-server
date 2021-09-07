
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
@Table("Drivers")
public class DriverDTO {

    @Id
    private Long id;
    private String licenceNumber;
    private String name;
    private Date licenceExpirationDate;
    private String mobileNumber;
    private String permissions;
    private String comment;
    @CreatedDate
    private LocalDateTime creationDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;
    @CreatedBy
    private String createdBy;
    private String onTerminal;

    @Override
    public String toString() {
        return "DriverDTO{" +
                "id=" + id +
                ", licenceNumber='" + licenceNumber + '\'' +
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
