
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
@Table("TruckContainers")
public class TruckContainerDTO {

    @Id
    private Long id;
    private String containerNumber;
    private String licenseNumber;
    private Date licenseExpirationDate;
    private double maximumWeightConstrain;
    private int compartmentsNumber;
    private Date calibrationExpirationDate;
    private String permissions;
    private String comment;

    public TruckContainerDTO(String containerNumber, String licenseNumber, Date licenseExpirationDate, double maximumWeightConstrain, int compartmentsNumber, Date calibrationExpirationDate, String permissions, String comment) {
        this.containerNumber = containerNumber;
        this.licenseNumber = licenseNumber;
        this.licenseExpirationDate = licenseExpirationDate;
        this.maximumWeightConstrain = maximumWeightConstrain;
        this.compartmentsNumber = compartmentsNumber;
        this.calibrationExpirationDate = calibrationExpirationDate;
        this.permissions = permissions;
        this.comment = comment;
    }

    public TruckContainerDTO(String licenseNumber, Date licenseExpirationDate, double maximumWeightConstrain, int compartmentsNumber, Date calibrationExpirationDate, String permissions, String comment) {
        this.licenseNumber = licenseNumber;
        this.licenseExpirationDate = licenseExpirationDate;
        this.maximumWeightConstrain = maximumWeightConstrain;
        this.compartmentsNumber = compartmentsNumber;
        this.calibrationExpirationDate = calibrationExpirationDate;
        this.permissions = permissions;
        this.comment = comment;
    }
    
}
