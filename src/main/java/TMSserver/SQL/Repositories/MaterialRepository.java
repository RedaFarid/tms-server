package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.MaterialDTO;
import TMSserver.SQL.Entities.TankDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MaterialRepository extends PagingAndSortingRepository<MaterialDTO, Long> {

    @Query("""
            declare @return varchar(50);
            set @return = 'Table [Materials] Already Exists'
            if not exists (select * from sysobjects where name='Materials' and xtype='U')
            begin
            CREATE TABLE Materials(
                [id] int identity(1,1) primary key, 
            	[name] [nvarchar](150) NOT NULL UNIQUE,
            	[description] [nvarchar](max))
            end
            select @return;
            """)
    String createTable();
}
