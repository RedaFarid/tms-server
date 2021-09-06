
package TMSserver.SQL.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.sql.Date;

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

    public DriverDTO(String licenceNumber, String name, Date licenceExpirationDate, String mobileNumber, String permissions, String comment) {
        this.licenceNumber = licenceNumber;
        this.name = name;
        this.licenceExpirationDate = licenceExpirationDate;
        this.mobileNumber = mobileNumber;
        this.permissions = permissions;
        this.comment = comment;
    }
}
