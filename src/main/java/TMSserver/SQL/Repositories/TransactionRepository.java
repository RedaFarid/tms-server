package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.TransactionDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TransactionRepository extends PagingAndSortingRepository<TransactionDTO, Long> {
    @Query("""
            declare @return varchar(50);
            set @return = 'Table [Transactions] Already Exists'
            if not exists (select * from sysobjects where name='Transactions' and xtype='U')
            begin
            CREATE TABLE Transactions(
                [id] int identity(1,1) primary key,
               	[tank] int NOT NULL,
               	[driver] int NOT NULL,
               	[truckTrailer] int ,
               	[truckContainer] int NOT NULL,
               	[operationType] [nvarchar](5) NOT NULL,
            	[qty] [float] Not NULL,
            	[dateTime] datetime default GETDATE(),  
            	[creationDate] datetime default GETDATE(),  
                [modifyDate] datetime  default GETDATE(), 
                [createdBy] varchar(100) ,
                [onTerminal] varchar(100),
                FOREIGN KEY (tank) REFERENCES Tanks(id),
            	FOREIGN KEY (driver) REFERENCES Drivers(id),
            	FOREIGN KEY (truckTrailer) REFERENCES TruckTrailers(id) ON DELETE SET null,
            	FOREIGN KEY (truckContainer) REFERENCES TruckContainers(id),);
            end
            select @return;
            """)
    String createTable();
}
