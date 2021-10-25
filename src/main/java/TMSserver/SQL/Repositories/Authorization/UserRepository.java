package TMSserver.SQL.Repositories.Authorization;

import TMSserver.SQL.Entities.Authorization.AppUserDTO;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface UserRepository extends PagingAndSortingRepository<AppUserDTO, Long> {
    @Query("""
            declare @return varchar(50);
            set @return = 'Table [Users] Already Exists'
            if not exists (select * from sysobjects where name='Users' and xtype='U')
            begin
            CREATE TABLE Users(
                [userId] int identity(1,1) primary key,
               	[name] [varchar](250) NOT NULL  UNIQUE,
                [password] [nvarchar](max));
            end
            select @return;
            """)
    String createTable();

    @Query("select top 1 * from [Users] where [name] like :name ")
    Optional<AppUserDTO> findByName(String name);

    @Modifying
    @Query("update [Users] SET [name] = :name  where [userId] = :id")
    void  updateUsername(String name , Long id);
}
