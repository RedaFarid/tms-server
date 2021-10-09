package TMSserver.SQL.DatabaseManagement;

import TMSserver.DAO.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

@Log4j2
@Component
public class Database {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private DriverManagerDataSource driverManagerDataSource;
    @Autowired
    private TankDAO tankDAO;
    @Autowired
    private MaterialDAO materialDAO;
    @Autowired
    private DriverDAO driverDAO;
    @Autowired
    private ClientsDAO clientsDAO;
    @Autowired
    private TruckTrailersDAO truckTrailersDAO;
    @Autowired
    private TruckContainersDAO truckContainersDAO;
    @Autowired
    private StationDAO stationDAO;
    @Autowired
    private TransactionDAO transactionDAO;
    @Autowired
    private LogDAO logDAO;

    @PostConstruct
    public void createTables() {
        // create tables
        tankDAO.createTable();
        materialDAO.createTable();
        driverDAO.createTable();
        clientsDAO.createTable();
        truckTrailersDAO.createTable();
        truckContainersDAO.createTable();
        stationDAO.createTable();
        transactionDAO.createTable();
        logDAO.createTable();
    }


}
