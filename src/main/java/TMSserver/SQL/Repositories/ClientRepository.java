package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.ClientDTO;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<ClientDTO, Long> {
    @Query("""
            declare @return varchar(50);
            set @return = 'Table [Clients] Already Exists'
            if not exists (select * from sysobjects where name='Clients' and xtype='U')
            begin
            CREATE TABLE Clients(
                [id] int identity(1,1) primary key,
               	[name] [varchar](50),
            	[mainOfficeAddress] [varchar](50),
            	[contactName] [varchar](50),
            	[contactTelNumber] [varchar](50),
            	[contactEmail] [varchar](50));
            end
            select @return;
            """)
    String createTable();
}
