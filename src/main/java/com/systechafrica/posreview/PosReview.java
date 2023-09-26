package com.systechafrica.posreview;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class PosReview {

   static final Logger LOGGER = PosCustomLogger.getLogger();

   public static void main(String[] args) throws SecurityException, IOException {
      

      PosDataAccessImplementation mysql = new PosDataAccessImplementation();
      String createDatabaseTable = "CREATE TABLE IF NOT EXISTS items ( item_id INT AUTO_INCREMENT, item_code VARCHAR(255) NOT NULL, item_quantity INT NOT NULL DEFAULT 1, item_price DOUBLE NOT NULL, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (item_id));";
      int updateStatus = mysql.executeUpdate(createDatabaseTable);
      LOGGER.info("Update status = " + updateStatus + "\n");

      //select query
      String selectQuery = "SELECT * FROM items;";
      ResultSet items = mysql.executeQuery(selectQuery);
       mysql.close();
        try {
            while(items.next()){
                int itemId = items.getInt("item_id");
                String itemCode = items.getString("item_code");
                LOGGER.info("ID: " + itemId + " Item code -> " + itemCode + "\n");
            }
        } catch (SQLException e) {            
            e.printStackTrace();
        }

      
   }


}
