package com.systechafrica.part2.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcDemo {
    public static void main(String[] args) {
        DataAccess mysql = new MSqlDataAccess();
        mysql.connect();
        ResultSet users = mysql.executeQuery("select * from users");
        mysql.close();
        try {
            while(users.next()){
                int userId = users.getInt("id");
                String username = users.getString("name");
                System.out.println("ID: " + userId + " Name -> " + username);
            }
        } catch (SQLException e) {
            
            e.printStackTrace();
        }

    }
}
