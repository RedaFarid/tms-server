package TMSserver.SQL.Repositories.Authorization;

import TMSserver.SQL.Entities.Authorization.UserDTO;
import TMSserver.SQL.Entities.ClientDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UsersRepository extends PagingAndSortingRepository<UserDTO, Long> {
    @Query("""
            declare @return varchar(50);
            set @return = 'Table [UsersData] Already Exists'
            if not exists (select * from sysobjects where name='UsersData' and xtype='U')
            begin
            CREATE TABLE UsersData(
                [userId] int identity(1,1) primary key,
               	[name] [varchar](250) NOT NULL  UNIQUE,
               	[password] [nvarchar](max) NOT NULL);
            end
            select @return;
            """)
    String createTable();

    Optional<UserDTO> findByName(String name);
}
