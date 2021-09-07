package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.DriverDTO;
import TMSserver.SQL.Entities.TankDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface DriverRepository extends PagingAndSortingRepository<DriverDTO,Long> {
    @Query("""
            declare @return varchar(50);
            set @return = 'Table [Drivers] Already Exists'
            if not exists (select * from sysobjects where name='Drivers' and xtype='U')
            begin
            CREATE TABLE Drivers(
                [id] int identity(1,1) primary key,
                [licenseNumber] [varchar](250) NOT NULL UNIQUE,
            	[name] [varchar](50) NOT NULL,
            	[licenceExpirationDate] Date default getDate(),
            	[mobileNumber] [varchar](50),
            	[permissions] [varchar](50),
            	[comment] [varchar](50),
            	[creationDate] datetime default GETDATE(),  
                [modifyDate] datetime  default GETDATE(), 
                [createdBy] varchar(100) ,
                [onTerminal] varchar(100));
            end
            select @return;
            """)
    String createTable();


    @Query("select * from drivers where LicenceNumber like :license")
    Optional<DriverDTO> findByLicenseNumber(String license);

}
