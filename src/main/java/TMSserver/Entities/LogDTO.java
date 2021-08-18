package TMSserver.Entities;


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
    @CreatedBy
    private String groupName;
    @CreatedDate
    private LocalDateTime dateTime;

    private Boolean ack = false;


    public LogDTO(LogIdentifier logIdentifier, String source, String event, LocalTime time, LocalDate date) {
        this.logIdentifier = logIdentifier;
        this.source = source;
        this.event = event;
        this.dateTime = LocalDateTime.of(date, time);

    }

    public LogDTO(String source, String event, String userName, String group, LocalTime time, LocalDate date) {
        this.source = source;
        this.event = event;
        this.userName = userName;
        groupName = group;
        this.dateTime = LocalDateTime.of(date, time);
    }

    public LogDTO(LogIdentifier logIdentifier, String source, String event) {
        this.logIdentifier = logIdentifier;
        this.source = source;
        this.event = event;
    }

    public LogDTO(Long logId, LogIdentifier logIdentifier, String event) {
        this.logId = logId;
        this.logIdentifier = logIdentifier;
        this.event = event;
    }

    public LogDTO(LogIdentifier logIdentifier, String event) {
        this.logIdentifier = logIdentifier;
        this.event = event;
    }

    public LogDTO(Long logId, LogIdentifier logIdentifier, String source, String event, String userName, LocalDateTime dateTime, Boolean ack) {
        this.logId = logId;
        this.logIdentifier = logIdentifier;
        this.source = source;
        this.event = event;
        this.userName = userName;
        this.dateTime = dateTime;
        this.ack = ack;
    }

    @Override
    public String toString() {
        return "LogDTO{" +
                "logId=" + logId +
                ", logIdentifier=" + logIdentifier +
                ", source='" + source + '\'' +
                ", event='" + event + '\'' +
                ", userName='" + userName + '\'' +
                ", groupName='" + groupName + '\'' +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public int compareTo(LogDTO o) {
        return 0;
    }
}
