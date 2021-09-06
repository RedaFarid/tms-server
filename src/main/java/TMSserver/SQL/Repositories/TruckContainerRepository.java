package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.TruckContainerDTO;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TruckContainerRepository extends PagingAndSortingRepository<TruckContainerDTO, Long> {


    @Query("""
            declare @return varchar(50);
            set @return = 'Table [TruckContainers] Already Exists'
            if not exists (select * from sysobjects where name='TruckContainers' and xtype='U')
            begin
            CREATE TABLE TruckContainers(
                [id] int identity(1,1) primary key,
               	[containerNumber] [nvarchar](50) UNIQUE,
            	[licenceNumber] [varchar](50),
            	[licenceExpirationDate] date,
            	[maximumWeightConstrain] float,
            	[compartmentsNumber] int,
            	[calibrationExpirationDate] date,
            	[permissions] [varchar](50),
            	[comment] [varchar](500));
            end
            select @return;
            """)
    String createTable();

    @Query("select * from TruckContainers where licenseNumber like :license ")
    Optional<TruckContainerDTO> findByLicense(String license);

    @Query("select * from TruckContainers where ContainerNumber like :number ")
    Optional<TruckContainerDTO> findByContainer(String number);
}
