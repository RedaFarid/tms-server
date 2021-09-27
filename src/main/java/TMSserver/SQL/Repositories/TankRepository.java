package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.TankDTO;
import TMSserver.SQL.Entities.TruckTrailerDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface TankRepository extends PagingAndSortingRepository<TankDTO, Long> {

    @Query("""
            declare @return varchar(50);
            set @return = 'Table [Tanks] Already Exists'
            if not exists (select * from sysobjects where name='Tanks' and xtype='U')
            begin
            CREATE TABLE Tanks(
                [id] int identity(1,1) primary key,
            	[name] [varchar](50) NOT NULL,
            	[station] [varchar](250) NOT NULL,
            	[capacity] [float] NULL,
            	[qty] [float] NULL,
            	[dateOfQtySet] datetime  default getDate(),
            	[userOfQtySet] [varchar](50),
            	[materialID] [varchar](50),
            	[onTerminal] [varchar](50),
                [creationDate] datetime default getDate(),
                [createdBy] varchar(100) ,
                [modificationDate] datetime default getDate(),
                unique ([name],[station]),
                FOREIGN KEY (materialID) REFERENCES Materials(id) );
            end
            select @return;
            """)
    String createTable();

    @Query("select top 1 *  from Tanks where name like :name and station like :station ")
    Optional<TankDTO> findByNameAndStation(String name , String station );
}
