package com.systechafrica.posreview;

import java.sql.Connection;
import java.sql.ResultSet;

public interface PosDataAccess {
    Connection connect();

    ResultSet executeQuery(String query);

    int executeUpdate(String query);

    void close();
}
