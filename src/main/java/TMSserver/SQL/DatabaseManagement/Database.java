package TMSserver.SQL.DatabaseManagement;

import TMSserver.DAO.MaterialDAO;
import TMSserver.DAO.TankDAO;
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

    @PostConstruct
    public void createTables() {

        // create tables
        tankDAO.createTable();
        materialDAO.createTable();


    }


}