package TMSserver.SQL.Repositories;

import TMSserver.SQL.Entities.TankDTO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TankRepository extends PagingAndSortingRepository<TankDTO, Long> {

    @Query("""
            declare @return varchar(50);
            set @return = 'Table [Tanks] Already Exists'
            if not exists (select * from sysobjects where name='Tanks' and xtype='U')
            begin
            CREATE TABLE [dbo].[Tanks](
            	[Name] [varchar](50) NOT NULL primary key,
            	[Capacity] [float] NULL,
            	[Level] [float] NULL,
            	[Volume] [float] NULL,
            	[Denisty] [float] NULL,
            	[CalculatedDenisty] [float] NULL,
            	[Mass] [float] NULL,
            	[LowLevel] [float] NULL,
            	[HightLevel] [float] NULL,
            	[Height] [float] NULL,
            	[redius] [float] NULL,
            	[AutoDenistyCalculations] [bit] NULL,
            	[Permission] [varchar](20) NULL,
            	[Status] [varchar](20) NULL,
            	[ProductID] [varchar](50) NULL,
            	[id] [int] IDENTITY(1,1) NOT NULL,
            	[ReservedMassForLot] float,
            	[totalMass]   float)
            end
            select @return;
            """)
    String createTable();
}
