
package TMSserver.SQL.Entities;

import com.google.common.base.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

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

    public ClientDTO(String name, String mainOfficeAddress, String contactName, String contactTelNumber, String contactEmail) {
        this.name = name;
        this.mainOfficeAddress = mainOfficeAddress;
        this.contactName = contactName;
        this.contactTelNumber = contactTelNumber;
        this.contactEmail = contactEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientDTO clientDTO = (ClientDTO) o;
        return id == clientDTO.id && Objects.equal(name, clientDTO.name) && Objects.equal(mainOfficeAddress, clientDTO.mainOfficeAddress) && Objects.equal(contactName, clientDTO.contactName) && Objects.equal(contactTelNumber, clientDTO.contactTelNumber) && Objects.equal(contactEmail, clientDTO.contactEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, name, mainOfficeAddress, contactName, contactTelNumber, contactEmail);
    }
}
