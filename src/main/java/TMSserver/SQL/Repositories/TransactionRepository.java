package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.TransactionDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends PagingAndSortingRepository<TransactionDTO, Long> {
    @Query("""
            declare @return varchar(50);
            set @return = 'Table [Transactions] Already Exists'
            if not exists (select * from sysobjects where name='Transactions' and xtype='U')
            begin
            CREATE TABLE Transactions(
            [id] int identity(1,1) primary key,
            [material] int NOT NULL,
            [station] int NOT NULL,
            [tank] int NOT NULL,
            [driver] int NOT NULL,
            [truckTrailer] int NOT NULL ,
            [truckContainer] int NOT NULL,
            [client] int NOT NULL ,
            [operationType] [nvarchar](5) NOT NULL,
            [qty] [float] Not NULL,
            [dateTime] datetime default GETDATE(),  
            [creationDate] datetime default GETDATE(),  
            [modifyDate] datetime  default GETDATE(), 
            [createdBy] varchar(100) ,
            [lastModifiedBy] varchar(100) ,
            [onTerminal] varchar(100),
            FOREIGN KEY (material) REFERENCES Materials(id),
            FOREIGN KEY (station) REFERENCES Stations(id),
            FOREIGN KEY (tank) REFERENCES Tanks(id),
            FOREIGN KEY (driver) REFERENCES Drivers(id),
            FOREIGN KEY (truckTrailer) REFERENCES TruckTrailers(id) ,
            FOREIGN KEY (truckContainer) REFERENCES TruckContainers(id),
            FOREIGN KEY (client) REFERENCES Clients(id));
            end
            select @return;
            """)
    String createTable();

    @Query("select * from Transactions where tank = :tankId and dateTime >= :dateOfQtySet")
    Optional<List<TransactionDTO>> findByTankAndDate(long tankId, LocalDateTime dateOfQtySet);
}
