
package TMSserver.SQL.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("Tanks")
public class TankDTO {

    @Id
    private Long id;
    private String Name ;
    private double Capacity = 0.0;
    private double Level = 0.0;
    private double Volume = 0.0;
//    private double correctedDensity;
//    private double correctionFactor;
//    private double correctionTemp;

//    private double currentTemperature;

//    @ReadOnlyProperty
//    private double calcuatedDensity;

    @ReadOnlyProperty
    private double totalMass;

    private double Mass ;

    @ReadOnlyProperty
    private double ReservedMassForLot;

    private double LowLevel = 0.0;
    private double HightLevel = 0.0;
    private double Height = 0.0;
    private double redius = 0.0;
    private Permissions Permission = Permissions.NOT_PERMITTED;
    private TankStatus Status = TankStatus.Good;
    private String ProductID;

    public TankDTO(String name, double capacity, double level, double volume, double correctedDensity, /*double correctionFactor, double correctionTemp, */double currentTemperature, double mass, double lowLevel, double hightLevel, double height, double redius, Permissions permission, String productID) {
        Name = name;
        Capacity = capacity;
        Level = level;
        Volume = volume;
//        this.correctedDensity = correctedDensity;
//        this.correctionFactor = correctionFactor;
//        this.correctionTemp = correctionTemp;
//        this.currentTemperature = currentTemperature;
        Mass = mass;
        LowLevel = lowLevel;
        HightLevel = hightLevel;
        Height = height;
        this.redius = redius;
        Permission = permission;
        ProductID = productID;
    }

    public TankDTO(double capacity, double level, double volume, double correctedDensity, /*double correctionFactor, double correctionTemp,*/ double currentTemperature, double mass, double lowLevel, double hightLevel, double height, double redius, Permissions permission, String productID) {
        Capacity = capacity;
        Level = level;
        Volume = volume;
//        this.correctedDensity = correctedDensity;
//        this.correctionFactor = correctionFactor;
        //this.correctionTemp = correctionTemp;
//        this.currentTemperature = currentTemperature;
        Mass = mass;
        LowLevel = lowLevel;
        HightLevel = hightLevel;
        Height = height;
        this.redius = redius;
        Permission = permission;
        ProductID = productID;
    }

    @Override
    public String toString() {
        return "TankDTO{id=%d, Name='%s', Capacity=%s, Level=%s, Volume=%s, totalMass=%s, Mass=%s, ReservedMassForLot=%s, LowLevel=%s, HightLevel=%s, Height=%s, redius=%s, Permission='%s', Status=%s, ProductID='%s'}".formatted(id, Name, Capacity, Level, Volume, totalMass, Mass, ReservedMassForLot, LowLevel, HightLevel, Height, redius, Permission, Status, ProductID);
    }
}
