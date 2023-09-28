package com.systechafrica.posreview;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Logger;

import com.systechafrica.exceptionhandling.ZeroNegativeErrorHandling;

public class PosReview {

    static final Logger LOGGER = PosCustomLogger.getLogger();

    Scanner scanner = new Scanner(System.in);
    final String PASSWORD = "Admin123";
    Item[] itemsArray = new Item[100];
    int numberOfItems = 0;
    double totalPriceOfAllItems = 0;
    int userAmount = 0;
    int loggedInUserId;


    // initiating database implementation
    PosDataAccessImplementation mySql = new PosDataAccessImplementation();
    // creating connection
    Connection connection = mySql.connect();

    public static void main(String[] args) throws SecurityException, IOException, SQLException {

        // PosDataAccessImplementation mysql = new PosDataAccessImplementation();
        // String createDatabaseTable = "CREATE TABLE IF NOT EXISTS items ( item_id INT
        // AUTO_INCREMENT, item_code VARCHAR(255) NOT NULL, item_quantity INT NOT NULL
        // DEFAULT 1, item_price DOUBLE NOT NULL, created_at TIMESTAMP DEFAULT
        // CURRENT_TIMESTAMP, PRIMARY KEY (item_id));";
        // int updateStatus = mysql.executeUpdate(createDatabaseTable);
        // LOGGER.info("Update status = " + updateStatus + "\n");

        // // select query
        // String selectQuery = "SELECT * FROM items;";
        // ResultSet items = mysql.executeQuery(selectQuery);
        // mysql.close();
        // try {
        // while (items.next()) {
        // int itemId = items.getInt("item_id");
        // String itemCode = items.getString("item_code");
        // LOGGER.info("ID: " + itemId + " Item code -> " + itemCode + "\n");
        // }
        // } catch (SQLException e) {
        // e.printStackTrace();
        // }

        PosReview app = new PosReview();

        // app.userLogin();
       app.userLogin();
        // if (userSignedIn) {
        //     System.out.println();
        //     LOGGER.info("Successfully signed in \n");
        //     app.displayMenu();

        // }

    }

    // getting user credentials and storing them on class user
    private static User getUserCredentials(Scanner scanner) {
        System.out.println("Create New Account");
        System.out.println("***************************");
        System.out.println();
        // reading user input
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        User user = new User(username, password);

        System.out.println(user);

        return user;
    }

    // signing up functionality
    public void signUp() {
        // creating user to database

        String insertUserQuery = "INSERT INTO users(username, password)VALUES(?,?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery);

            User user = getUserCredentials(scanner);

            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());

            int noOfRowsAffected = preparedStatement.executeUpdate();
            LOGGER.info("Rows affected in user table i.e inserted " + noOfRowsAffected +
                    "\n");
            System.out.println();
            LOGGER.info("User created successfully, proceed to login\n");
            System.out.println();
            login();

        } catch (SQLException e) {
            LOGGER.info("Error when creating user " + e.getMessage() + "\n");
            e.printStackTrace();
        }

    }

    // login functionality
    public boolean login() {

        boolean userSignedIn = false;

        System.out.println("Log in into POS");
        System.out.println("***************************");
        System.out.println();
        // reading user input
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        // taking data from database

        String selectUserQuery = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectUserQuery);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            // resultSet will return true if resultset.next() - there is a value fetched
            // from the db
            if (resultSet.next()) {
                loggedInUserId = resultSet.getInt("user_id");
                LOGGER.info("User id " + loggedInUserId + "\n");
                LOGGER.info("Login successful! Welcome, " + username + "!" + "\n");
                userSignedIn = true;
                System.out.println(userSignedIn);
                return userSignedIn;

            } else {
                LOGGER.info("Login failed. Please check your username and password.\n");
                userSignedIn = false;
                 System.out.println(userSignedIn);
                return userSignedIn;
            }
        } catch (SQLException e) {
            LOGGER.info("Error when logging to your account " + e.getMessage() + "\n");
            e.printStackTrace();
        }
        return false;

    }

    // the new log in functionality if user has account - login : no account -
    // signup
    public boolean userLogin() {

        boolean isUserLoggedIn = false;

        System.out.println();
        System.out.println("Welcome to Systech POS System");
        System.out.println();

        System.out.print("Hello, do you have an account? (Y/N): ");
        char userHasAccount = scanner.nextLine().toUpperCase().charAt(0);
        System.out.println();

        if (userHasAccount == 'Y') {
            login();
            
        } else if (userHasAccount == 'N') {
            signUp();
            
        } else {
            System.out.println("Invalid input, Choose either Y or N");
            System.out.println();
            userLogin();
        }

        return isUserLoggedIn;

    }

    public void displayMenu() {
        System.out.println();
        System.out.println("*****************************************");
        System.out.println();
        System.out.println("SYSTECH POS SYSTEM");
        System.out.println();
        System.out.println("*****************************************");
        System.out.println();
        System.out.println("1. ADD ITEM");
        System.out.println("2. MAKE PAYMENT");
        System.out.println("3. DISPLAY RECEIPT");
        System.out.println("4: EXIT");
        System.out.println("*********************");
        System.out.println();
        System.out.print("Choose an option: ");

        int option = scanner.nextInt();

        scanner.nextLine();

        System.out.println();

        switch (option) {
            case 1:
                try {
                    addItem();
                } catch (ZeroNegativeErrorHandling e) {
                    LOGGER.info(e.getMessage() + "\n");
                    displayMenu();
                }
                break;
            case 2:
                makePayment();
                break;
            case 3:
                displayReceipt();
                break;
            case 4:
                // Exit the program
                System.out.println("Exiting the program.");
                System.exit(0);
                break;

            default:
                System.out.println("Invalid Option, Choose between 1-4");
                System.out.println();
                displayMenu();
                break;
        }

    }

    public void addItem() throws ZeroNegativeErrorHandling {

        String insertItemQuery = "INSERT INTO items(item_code,item_quantity, item_price, user_id)VALUES(?,?,?, ?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertItemQuery);
            char choice;

            do {
                Item item = getItemFromUser(scanner);

                preparedStatement.setString(1, item.getItemCode());
                preparedStatement.setInt(2, item.getItemQuantity());
                preparedStatement.setDouble(3, item.getPrice());
                preparedStatement.setInt(4, loggedInUserId);

                int noOfRowsAffected = preparedStatement.executeUpdate();
                LOGGER.info("Rows affected in item table i.e inserted " + noOfRowsAffected + "\n");

                System.out.print("Do you want to add another item? (Y/N): ");
                choice = scanner.nextLine().toUpperCase().charAt(0);
                System.out.println();

            } while (choice == 'Y');
            displayMenu();

        } catch (SQLException e) {
            LOGGER.info("Error when inserting data " + e.getMessage() + "\n");
            e.printStackTrace();
        }

    }

    private static Item getItemFromUser(Scanner scanner) throws ZeroNegativeErrorHandling {
        // reading input fro console
        System.out.print("Enter item code: ");
        String itemCode = scanner.nextLine();

        System.out.print("Enter item quantity: ");
        int itemQuantity = scanner.nextInt();

        if (itemQuantity <= 0)
            throw new ZeroNegativeErrorHandling();

        System.out.print("Enter item Price: ");
        double itemPrice = scanner.nextDouble();

        if (itemPrice <= 0)
            throw new ZeroNegativeErrorHandling();

        Item item = new Item(itemCode, itemQuantity, itemPrice);

        scanner.nextLine();

        return item;
    }

    // private static

    public void makePayment() {

        displayAllItems();

        // if (numberOfItems == 0) {
        //     System.out.println("No items in the shopping cart");
        // } else {
        //     displayAllItems();
        // }
    }

    public void displayAllItems() {

        String selectUserItemsQuery = "SELECT * FROM items WHERE user_id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(selectUserItemsQuery);
            preparedStatement.setInt(1, loggedInUserId);

            ResultSet items = preparedStatement.executeQuery();
            System.out.println("Item Code\t" + "Quantity\t" + "Unit Price\t" + "Total Value ");
            System.out.println();

            // result set returns retrieved items from db
            while (items.next()) {
                String itemCode = items.getString("item_code");
                int itemQuantity = items.getInt("item_quantity");
                double itemPrice = items.getDouble("item_price");

                //after fetching items rom db - you store them in array
                //then map through items to calculate the total              
                
                System.out.println( itemCode + " " + itemQuantity + " " + itemPrice);

            }
        } catch (SQLException e) {
            LOGGER.info("Error when fetching items " + e.getMessage());
            e.printStackTrace();
        }

        // for (int i = 0; i < numberOfItems; i++) {

        //     System.out.println(itemsArray[i].getItemCode() + " \t\t"
        //             + itemsArray[i].getItemQuantity() + " \t\t" + itemsArray[i].getPrice() + " \t\t"
        //             + (itemsArray[i].getItemQuantity() * itemsArray[i].getPrice()));

        //     totalPriceOfAllItems = totalPriceOfAllItems + (itemsArray[i].getItemQuantity() * itemsArray[i].getPrice());
        // }
        // System.out.println();
        // System.out.println("********************************************************************");
        // System.out.println();

        // System.out.println("Total: " + "\t" + " - " + "\t" + "sh: " + totalPriceOfAllItems);

        // System.out.println();
        // System.out.println("********************************************************************");
        // System.out.println();

        // enterUserAmount(); // I am using method to enter user amount so that when the cashier enters
        //                    // insufficient amount it can call the method again

        // while (userAmount < totalPriceOfAllItems) {
        //     System.out.println();
        //     System.out.println("Insufficient amount, Kindly confirm user amount and try again");
        //     System.out.println();
        //     enterUserAmount();
        // }

        // System.out.println();

        // double userChange = userAmount - totalPriceOfAllItems;

        // System.out.println("Change: \t" + "sh " + userChange);

        // System.out.println();

        // System.out.println("********************************************************************");
        // System.out.println();
        // System.out.println("Thank you for shopping with us!");
        // System.out.println();
        // System.out.println("********************************************************************");

    }

    public void enterUserAmount() {
        System.out.print("Enter the amount given by customer: ");
        userAmount = scanner.nextInt();
    }

    public void displayReceipt() {
        System.out.println("Not supported at the moment");
    }

}
