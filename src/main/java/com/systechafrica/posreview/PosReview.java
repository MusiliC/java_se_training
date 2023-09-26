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

    public static void main(String[] args) throws SecurityException, IOException {

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

        // app.addItem();
        boolean userSignedIn = app.userLogin();
        if (userSignedIn) {
            System.out.println();
            LOGGER.info("Successfully signed in \n");
            app.displayMenu();

        }

    }

    public boolean userLogin() {

        int passwordAttempts = 1;
        boolean isUserLoggedIn = false;

        System.out.println();
        System.out.println("Welcome to Systech POS System");
        System.out.println();

        while (passwordAttempts <= 3) {
            System.out.print("Enter your password: ");
            String password = scanner.nextLine();

            if (password.equals(PASSWORD)) {
                isUserLoggedIn = true;
                break;
            }

            if (passwordAttempts == 3) {
                LOGGER.info("Wrong password, Maximum attempts Try again later!");
            } else {
                LOGGER.info("Wrong password, Try again");
            }

            passwordAttempts = passwordAttempts + 1;
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
                    LOGGER.info(e.getMessage());
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

        PosDataAccessImplementation mySql = new PosDataAccessImplementation();

        Connection connection = mySql.connect();
        String insertQuery = "INSERT INTO items(item_code,item_quantity, item_price)VALUES(?,?,?);";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
            char choice;

            do {
                Item item = getItemFromUser(scanner);

                preparedStatement.setString(1, item.getItemCode());
                preparedStatement.setInt(2, item.getItemQuantity());
                preparedStatement.setDouble(3, item.getPrice());

                int noOfRowsAffected = preparedStatement.executeUpdate();
                LOGGER.info("Rows affected i.e inserted " + noOfRowsAffected + "\n");

                System.out.print("Do you want to add another item? (Y/N): ");
                choice = scanner.nextLine().toUpperCase().charAt(0);
                System.out.println();

            } while (choice == 'Y');
            displayMenu();

        } catch (SQLException e) {
            LOGGER.info("Error when inserting data " + e.getMessage());
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

    public void makePayment() {

        if (numberOfItems == 0) {
            System.out.println("No items in the shopping cart");
        } else {
            displayAllItems();
        }
    }

    public void displayAllItems() {
        System.out.println("Items in shopping cart");
        System.out.println();
        System.out.println("Item Code\t" + "Quantity\t" + "Unit Price\t" + "Total Value ");

        for (int i = 0; i < numberOfItems; i++) {

            System.out.println(itemsArray[i].getItemCode() + " \t\t"
                    + itemsArray[i].getItemQuantity() + " \t\t" + itemsArray[i].getPrice() + " \t\t"
                    + (itemsArray[i].getItemQuantity() * itemsArray[i].getPrice()));

            totalPriceOfAllItems = totalPriceOfAllItems + (itemsArray[i].getItemQuantity() * itemsArray[i].getPrice());
        }
        System.out.println();
        System.out.println("********************************************************************");
        System.out.println();

        System.out.println("Total: " + "\t" + " - " + "\t" + "sh: " + totalPriceOfAllItems);

        System.out.println();
        System.out.println("********************************************************************");
        System.out.println();

        enterUserAmount(); // I am using method to enter user amount so that when the cashier enters
                           // insufficient amount it can call the method again

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

    }

    public void enterUserAmount() {
        System.out.print("Enter the amount given by customer: ");
        userAmount = scanner.nextInt();
    }

    public void displayReceipt() {
        System.out.println("Not supported at the moment");
    }

}
