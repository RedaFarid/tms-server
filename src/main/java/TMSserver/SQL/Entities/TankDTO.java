
package TMSserver.SQL.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.*;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("Tanks")
public class TankDTO {

    @Id
    private Long id;
    private String name;
    private String station;
    private double capacity = 0.0;
    private double qty = 0.0;
    private LocalDateTime dateOfQtySet;
    private String userOfQtySet;
    private String materialID;
    private String onTerminal;
    @CreatedDate
    private LocalDateTime creationDate;
    @LastModifiedDate
    private LocalDateTime modificationDate;
//    private double correctedDensity;
//    private double correctionFactor;
//    private double correctionTemp;

//    private double currentTemperature;

//    @ReadOnlyProperty
//    private double calcuatedDensity;

    @Transient
    private double calculatedQty;

    public TankDTO(Long id, String name,String station, double capacity, double qty, String materialID, String onTerminal) {
        this.id =id;
        this.name = name;
        this.station =station;
        this.capacity = capacity;
        this.qty =qty;
        this.materialID =materialID;
        this.onTerminal =onTerminal;

    }

    public TankDTO(String name,String station, double capacity, double qty, String materialID, String onTerminal) {

        this.name = name;
        this.station =station;
        this.capacity = capacity;
        this.qty =qty;
        this.materialID =materialID;
        this.onTerminal =onTerminal;
    }

    @Override
    public String toString() {
        return "TankDTO{id=%d, Name='%s', Station='%s' Capacity=%s, Quantity=%s, Date of Qty Set=%s, User Of Qty Set=%s, Material ID=%s, On Terminal=%s, Creation Date=%s, Modification Date=%s'}".formatted(id, name, station, capacity, qty, dateOfQtySet, userOfQtySet, materialID, onTerminal, creationDate, modificationDate);
    }
}
