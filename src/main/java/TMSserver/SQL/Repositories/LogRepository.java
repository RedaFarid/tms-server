package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.LogDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LogRepository extends PagingAndSortingRepository<LogDTO, Long> {
    @Query(
            """
                    declare @return varchar(50);
                    set @return = 'Table [Logs] Already Exists'
                    if not exists (select * from sysobjects where name='Logs' and xtype='U')
                    begin
                    create table [Logs](
                    [logId] int identity(1,1) primary key,
                    [logIdentifier] varchar(50) ,
                    [source] varchar(20) not null  default 'none',
                    [event] varchar(max) not null default 'none',
                    [userName] varchar(20) not null default 'none',
                    [dateTime] datetime not null default GETDATE(),
                    [ack] Bit  default 0  ,
                    [onTerminal] varchar(100)
                    )
                    set @return = 'Table [Logs] Created'
                    end
                    select @return;
            """
    )
    String createTable();
}
