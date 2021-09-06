
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
@Table("TruckTrailers")
public class TruckTrailerDTO {

    @Id
    private Long id;
    private String trailerNumber;
    private String licenseNumber;
    private Date licenseExpirationDate;
    private String permissions;
    private String comment;

    public TruckTrailerDTO(String trailerNumber, String licenseNumber, Date licenseExpirationDate, String permissions, String comment) {
        this.trailerNumber = trailerNumber;
        this.licenseNumber = licenseNumber;
        this.licenseExpirationDate = licenseExpirationDate;
        this.permissions = permissions;
        this.comment = comment;
    }

    public TruckTrailerDTO(String LicenseNumber, Date LicenseExpirationDate, String Permissions, String Comment) {
        this.licenseNumber = LicenseNumber;
        this.licenseExpirationDate = LicenseExpirationDate;
        this.permissions = Permissions;
        this.comment = Comment;
    }
    
}
