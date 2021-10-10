package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.StationDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;
import java.util.Optional;

public interface StationRepository extends PagingAndSortingRepository<StationDTO,Long> {
    @Query("""
            declare @return varchar(50);
            set @return = 'Table [Stations] Already Exists'
            if not exists (select * from sysobjects where name='Stations' and xtype='U')
            begin
            CREATE TABLE Stations(
                [id] int identity(1,1) primary key,
                [stationName] [varchar](250) NOT NULL UNIQUE,
            	[location] [varchar](250) ,
            	[computerName] [varchar](250),
            	[comment] [varchar](50),
            	[creationDate] datetime default GETDATE(),
                [modifyDate] datetime default GETDATE(),
                [createdBy] varchar(100),
                [onTerminal] varchar(100));
            end
            select @return;
            """)
    String createTable();

    Optional<StationDTO> findByStationName(String stationName);

}
