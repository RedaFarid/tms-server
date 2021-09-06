package TMSserver.SQL.DatabaseManagement;

import TMSserver.DAO.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
@RequiredArgsConstructor
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

    private final ClientsDAO clientsDAO;

    private final TruckTrailersDAO truckTrailersDAO;

    private final TruckContainersDAO truckContainersDAO;

    @PostConstruct
    public void createTables() {

        // create tables
        tankDAO.createTable();
        materialDAO.createTable();
        driverDAO.createTable();
        clientsDAO.createTable();
        truckTrailersDAO.createTable();
        truckContainersDAO.createTable();


    }


}
