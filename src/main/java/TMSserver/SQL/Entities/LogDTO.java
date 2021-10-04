package TMSserver.SQL.Entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("Logs")
public class LogDTO implements Comparable<LogDTO>, Cloneable, Serializable {

    @Id
    private Long logId;
    private LogIdentifier logIdentifier ;
    private String source;
    private String event;
    @CreatedBy
    private String userName;
    @CreatedDate
    private LocalDateTime dateTime;

    private Boolean ack = false;
    private String onTerminal;

    @Override
    public int compareTo(LogDTO o) {
        return 0;
    }
}
