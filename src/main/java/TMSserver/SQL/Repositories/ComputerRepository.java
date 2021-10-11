package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.ClientDTO;
import TMSserver.SQL.Entities.ComputerDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ComputerRepository extends PagingAndSortingRepository<ComputerDTO, Long> {
    @Query("""
            declare @return varchar(50);
            set @return = 'Table [Computers] Already Exists'
            if not exists (select * from sysobjects where name='Computers' and xtype='U')
            begin
            CREATE TABLE Computers(
                [id] int identity(1,1) primary key,
               	[name] [varchar](250) NOT NULL  UNIQUE);
            end
            select @return;
            """)
    String createTable();

}
