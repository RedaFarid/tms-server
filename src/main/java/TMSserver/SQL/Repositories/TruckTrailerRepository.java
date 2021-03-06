package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.TruckTrailerDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TruckTrailerRepository extends PagingAndSortingRepository<TruckTrailerDTO, Long> {
    @Query("""
            declare @return varchar(50);
            set @return = 'Table [TruckTrailers] Already Exists'
            if not exists (select * from sysobjects where name='TruckTrailers' and xtype='U')
            begin
            CREATE TABLE TruckTrailers(
                [id] int identity(1,1) primary key,
               	[trailerNumber] [nvarchar](50) NOT NULL UNIQUE,
            	[licenceNumber] [varchar](50),
            	[licenceExpirationDate] date,
            	[permissions] [varchar](50),
            	[comment] [varchar](500),
            	[creationDate] datetime default GETDATE(),  
                [modifyDate] datetime  default GETDATE(), 
                [createdBy] varchar(100) ,
                [lastModifiedBy] varchar(100) ,
                [onTerminal] varchar(100));
            end
            select @return;
            """)
    String createTable();

    @Query("select top 1 *  from TruckTrailers where licenceNumber like :license ")
    Optional<TruckTrailerDTO> findByLicense(String license);

    @Query("select top 1 *  from TruckTrailers where trailerNumber like :trailer ")
    Optional<TruckTrailerDTO> findByTrailer(String trailer);

}
