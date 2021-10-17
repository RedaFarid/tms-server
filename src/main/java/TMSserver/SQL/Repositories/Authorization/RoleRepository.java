package TMSserver.SQL.Repositories.Authorization;

import TMSserver.SQL.Entities.Authorization.AppUserDTO;
import TMSserver.SQL.Entities.Authorization.RoleDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface RoleRepository extends PagingAndSortingRepository<RoleDTO, Long> {
    @Query("""
            declare @return varchar(50);
            set @return = 'Table [Roles] Already Exists'
            if not exists (select * from sysobjects where name='Roles' and xtype='U')
            begin
            CREATE TABLE Roles(
                [id] int identity(1,1) primary key,
               	[name] [varchar](250) NOT NULL  UNIQUE);
            end
            select @return;
            """)
    String createTable();

    @Query("""
            declare @return varchar(50);
            set @return = 'Table [RoleRef] Already Exists'
            if not exists (select * from sysobjects where name='RoleRef' and xtype='U')
            begin
            CREATE TABLE RoleRef(
                [userId] int ,
               	[roleId] int,
               	primary key (userId, roleId));
            end
            select @return;
            """)
    String createRoleRefTable();

    Optional<RoleDTO> findByName(String name);


}
