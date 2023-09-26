package com.systechafrica.part3.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import com.systechafrica.part3.logging.CustomFormatter;

public class DatabaseAccessDemo {

    private static final Logger LOGGER = Logger.getLogger(DatabaseAccessDemo.class.getName());

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            FileHandler fileHandler = new FileHandler("working-with-db.txt");
            CustomFormatter formatter = new CustomFormatter();
            LOGGER.addHandler(fileHandler);
            fileHandler.setFormatter(formatter);

            // load db driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // create connection to jdbc - we use drivemanager.getConnection - to make
            // connection
            String connectionUrl = "jdbc:mysql://localhost:3306/mydatabase";
            String user = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(connectionUrl, user, password);

            // create statement
            Statement statement = connection.createStatement(0, 0, 0);

            String createDatabaseTable = "CREATE TABLE IF NOT EXISTS tasks ( task_id INT AUTO_INCREMENT, title VARCHAR(255) NOT NULL,  start_date DATE, due_date DATE,  priority TINYINT NOT NULL DEFAULT 3, description TEXT, created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP, PRIMARY KEY (task_id))";

            // execute queries

            int updateStatus = statement.executeUpdate(createDatabaseTable);

            LOGGER.info("Update status = " + updateStatus);

            // execute insert records

            // // read input task data details
            // String insertQuery = "INSERT INTO tasks(title,start_date, due_date, priority, description)VALUES(?,?,?,?,?);";
            // PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            // Task task = getTaskFromUser(scanner);
            // preparedStatement.setString(1, task.getTitle());
            // preparedStatement.setString(2, task.getStartDate().toString());
            // preparedStatement.setString(3, task.getDueDate().toString());
            // preparedStatement.setInt(4, task.getPriority());
            // preparedStatement.setString(5, task.getDescription());
            // int noRowsAffected = preparedStatement.executeUpdate();
            // LOGGER.info("Rows affected i.e inserted " + noRowsAffected);

            //execute selection
            String selectQuery = "SELECT * from tasks;";
            ResultSet resultSet =  statement.executeQuery(selectQuery);
            while(resultSet.next()){
                //title, start_date, due_date, priority, description

                int id = resultSet.getInt("task_id");
                String title = resultSet.getString("title");
                LocalDate startDate  = handleDbDate( resultSet.getString("start_date"));
                LocalDate dueDate = handleDbDate(resultSet.getString("due_date"));
                int priority = resultSet.getInt("priority");
                String description = resultSet.getString("description");

                //map to object
                Task dbTask = new Task(id, title, startDate, dueDate, priority, description);

                System.out.println(dbTask);
            }

            //release resources
            resultSet.close();
           // preparedStatement.close();
            statement.close();
            connection.close();

        } catch (SecurityException e) {
            LOGGER.severe("Unable to obtain security permission " + e.getMessage());

        } catch (IOException e) {

            LOGGER.severe("Unable to obtain read/write permission " + e.getMessage());
        } catch (ClassNotFoundException e) {

            LOGGER.severe("Unable to obtain class for JDBC driver " + e.getMessage());
        } catch (SQLException e) {
            LOGGER.severe("Database operation failure " + e.getMessage());
        } catch (DateTimeParseException e) {
            LOGGER.severe("Unable to parse date " + e.getMessage());
        }
                catch (Exception e) {
            LOGGER.severe("Oops! error occurred " + e.getMessage());
            e.printStackTrace();
        }

    }

    public static LocalDate handleDbDate(String text){
        if(text == null){
            return null;
        }
        return LocalDate.parse(text);
    }

    // private static Task getTaskFromUser(Scanner scanner) {
    //     // read input fro console
    //     // title,start_date, due_date, priority, description
    //     System.out.print("Enter task title: ");
    //     String title = scanner.nextLine();

    //     System.out.print("Enter task startDate(YYYY-MM-dd): ");
    //     LocalDate startDate = LocalDate.parse(scanner.nextLine());

    //     System.out.print("Enter task dueDate(YYYY-MM-dd): ");
    //     LocalDate dueDate = LocalDate.parse(scanner.nextLine());

    //     System.out.print("Enter task priority: ");
    //     int priority = scanner.nextInt();
    //     scanner.nextLine();

    //     System.out.print("Enter task description: ");
    //     String description = scanner.nextLine();

    //     Task task = new Task(title, startDate, dueDate, priority, description);

    //     return task;
    // }

}
