package com.systechafrica.posreview;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static com.systechafrica.posreview.PosReview.LOGGER;

public class PosDataAccessImplementation implements PosDataAccess {

    //   private static final Logger LOGGER = PosCustomLogger.getLogger();
    
    public PosDataAccessImplementation() {

        // loading JDLC
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            LOGGER.info("Error when loading jdlc drivers " + e.getMessage() + "\n");
        }
    }

    @Override
    public Connection connect() {
        try {
            // establish connection - driver manager
            String connectionUrl = "jdbc:mysql://localhost:3306/pos";
            String user = "root";
            String password = "";
            Connection connection = DriverManager.getConnection(connectionUrl, user, password);
            
            // return an object of connection
            return connection;
        } catch (Exception e) {
            LOGGER.info("Error when creating connection " + e.getMessage() + "\n");
            return null;
        }
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            // create statement
            Statement statement = connect().createStatement(0, 0, 0);
            ResultSet resultSet = statement.executeQuery(query);
            return resultSet;
        } catch (SQLException e) {
            LOGGER.info("Error when executing query " + e.getMessage() + "\n");
            return null;
        }
    }

    @Override
    public int executeUpdate(String query) {
        try {
            //create statement
            Statement statement = connect().createStatement(0, 0, 0);
            int numberOfRecordsUpdated = statement.executeUpdate(query);
            return numberOfRecordsUpdated;
        } catch (Exception e) {
            LOGGER.info("Error when executing update " + e.getMessage() + "\n");
            return 0;
        }
    }

    @Override
    public void close() {

    }
}
