
package TMSserver.SQL.Entities;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table("Clients")
public class ClientDTO {

    @Id
    private long id;
    private String name;
    private String mainOfficeAddress;
    private String contactName;
    private String contactTelNumber;
    private String contactEmail;
    @CreatedDate
    private LocalDateTime creationDate;
    @LastModifiedDate
    private LocalDateTime modifyDate;
    @CreatedBy
    private String createdBy;
    private String onTerminal;

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mainOfficeAddress='" + mainOfficeAddress + '\'' +
                ", contactName='" + contactName + '\'' +
                ", contactTelNumber='" + contactTelNumber + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", creationDate=" + creationDate +
                ", modifyDate=" + modifyDate +
                ", createdBy='" + createdBy + '\'' +
                ", onTerminal='" + onTerminal + '\'' +
                '}';
    }
}
