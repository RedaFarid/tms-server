package TMSserver.SQL.Repositories.Authorization;

import TMSserver.SQL.Entities.Authorization.RoleRef;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoleRefRepository extends PagingAndSortingRepository<RoleRef, Long> {
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
    String createTable();

    @Query("select roleId from RoleRef where userId = :user")
    List<Long> findByUserId(Long user);


}
