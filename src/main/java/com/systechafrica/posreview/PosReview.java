package com.systechafrica.posreview;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

import com.systechafrica.exceptionhandling.ZeroNegativeErrorHandling;

public class PosReview {

    static final Logger LOGGER = PosCustomLogger.getLogger();

    Scanner scanner = new Scanner(System.in);
    double totalPriceOfAllItems = 0;
    int userAmount = 0;
    int loggedInUserId;
    boolean userSignedIn = false;

    // initiating database implementation
    PosDataAccessImplementation mySql = new PosDataAccessImplementation();
    
    // creating connection
    Connection connection = mySql.connect();

    public static void main(String[] args) throws SecurityException, IOException, SQLException {

        PosReview app = new PosReview();

        app.userLogin();
        if (app.userSignedIn) {
            System.out.println();
            LOGGER.info("Successfully signed in \n");
            app.displayMenu();
        }

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
                // checking whether if user with the specific account had previous transactions
                // if true - will alter the user_id so as to make new transaction with different
                // id
                // if false - user will go on and make transactions for the first time
                // hence you can handle different transactions at different times with same user
                userPreviousTransactions();
                LOGGER.info("User id " + loggedInUserId + "\n");
                LOGGER.info("Login successful! Welcome, " + username + "!" + "\n");
                userSignedIn = true;
                return userSignedIn;

            } else {
                LOGGER.info("Login failed. Please check your username and password.\n");
                userSignedIn = false;
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

    public int userPreviousTransactions() {

        int randomId = new Random().nextInt(100000);
        try {

            ResultSet items = checkItemsInDB();
            if (items.next()) {
                loggedInUserId = loggedInUserId + randomId;
                return loggedInUserId;
            } else {
                return loggedInUserId;
            }

        } catch (SQLException e) {
            LOGGER.info("Error when checking user previous transactions " + e.getMessage());
            e.printStackTrace();
            return loggedInUserId;
        }
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

    // function to check if there is items in the database
    public ResultSet checkItemsInDB() {
        String selectUserItemsQuery = "SELECT * FROM items WHERE user_id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(selectUserItemsQuery);
            preparedStatement.setInt(1, loggedInUserId);
            ResultSet items = preparedStatement.executeQuery();
            return items;
        } catch (SQLException e) {
            LOGGER.info("Error When fetching items from databsae");
            e.printStackTrace();
        }
        return null;
    }

    public void makePayment() {

        try {
            ResultSet items = checkItemsInDB();
            if (items.next()) {
                displayAllItems();
            } else {
                LOGGER.info("No items in the shopping cart for this user \n");
            }
        } catch (SQLException e) {
            LOGGER.info("Error when fetching items " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void displayAllItems() {

        try {

            ResultSet items = checkItemsInDB();
            System.out.println("Item Code\t" + "Quantity\t" + "Unit Price\t" + "Total Value ");
            System.out.println();

            // result set returns retrieved items from db
            while (items.next()) {
                String itemCode = items.getString("item_code");
                int itemQuantity = items.getInt("item_quantity");
                double itemPrice = items.getDouble("item_price");

                // Item item = new Item(itemCode, itemQuantity, itemPrice);
                // itemsArray.add(item);

                System.out.println(itemCode + " \t\t" + itemQuantity + " \t\t" + itemPrice +
                        " \t\t"
                        + (itemQuantity * itemPrice));

                totalPriceOfAllItems = totalPriceOfAllItems + (itemQuantity * itemPrice);
            }
            System.out.println();
            System.out.println("********************************************************************");
            System.out.println();
            System.out.println("Total items price: " + "\t" + " - " + "\t" + "sh: " +
                    totalPriceOfAllItems + "\n");

            enterUserAmount(); // I am using method to enter user amount so that when the
            // cashier enters
            // insufficient amount it can call the method again

            // the total amount of items can't be zero or negative number because I caught
            // the exception when prompting user to enter item

            while (userAmount < totalPriceOfAllItems) {
                System.out.println();
                System.out.println("Insufficient amount, Kindly confirm user amount and try again");
                System.out.println();
                enterUserAmount();
            }

            System.out.println();

            double userChange = userAmount - totalPriceOfAllItems;

            System.out.println("Change: \t" + "sh " + userChange);

            System.out.println();

            System.out.println("********************************************************************");
            System.out.println();
            System.out.println("Thank you for shopping with us!");
            System.out.println();
            System.out.println("********************************************************************");
        } catch (SQLException e) {
            LOGGER.info("Error when fetching items " + e.getMessage());
            e.printStackTrace();
        }

    }

    public void enterUserAmount() {
        System.out.print("Enter the amount given by customer: ");
        userAmount = scanner.nextInt();
    }

    public void displayReceipt() {
        try {
            ResultSet items = checkItemsInDB();
            if (items.next()) {
                System.out.println("This is your receipt");
                System.out.println();
                System.out.println("Item Code\t" + "Quantity\t" + "Unit Price\t" + "Total Value ");
                System.out.println();
                String itemCode = items.getString("item_code");
                int itemQuantity = items.getInt("item_quantity");
                double itemPrice = items.getDouble("item_price");

                System.out.println(itemCode + " \t\t" + itemQuantity + " \t\t" + itemPrice +
                        " \t\t"
                        + (itemQuantity * itemPrice));

                totalPriceOfAllItems = totalPriceOfAllItems + (itemQuantity * itemPrice);

                System.out.println();
                System.out.println("********************************************************************");
                System.out.println();
                System.out.println("Total items price: " + "\t" + " - " + "\t" + "sh: " +
                        totalPriceOfAllItems + "\n");

                System.out.print("Do you want to proceed to payment? (Y/N): ");
                char choice = scanner.nextLine().toUpperCase().charAt(0);
                System.out.println();

                if (choice == 'Y') {
                    displayAllItems();
                } else if (choice == 'N') {
                    displayMenu();
                }else{
                    System.out.println("User input should be either Y/N");
                }

            } else {
                LOGGER.info("No items to display receipt \n");
            }
        } catch (SQLException e) {
            LOGGER.info("Error when fetching items to display receipt " + e.getMessage());
            e.printStackTrace();
        }
    }

}
