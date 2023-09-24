package com.systechafrica.pos;

import java.util.Scanner;

import com.systechafrica.exceptionhandling.ZeroNegativeErrorHandling;

public class Main {

    Scanner scanner = new Scanner(System.in);

    final String PASSWORD = "Admin123";
    Item[] itemsArray = new Item[10000]; // ?initializing the array to hold 10,000 items assuming its not expected user
                                         // to
                                         // ? enter 10,000 items
    int numberOfItems = 0;
    double totalPriceOfAllItems = 0;
    int userAmount = 0;

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
                System.out.println("Wrong password, Maximum attempts Try again later!");
            } else {
                System.out.println("Wrong password, Try again");
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
                    System.out.println(e.getMessage());
                    displayMenu();
                }
                break;
            case 2:
                makePayment();
                break;
            case 3:
                displayReceipt();
                break;

            default:
                System.out.println("Invalid Option, Choose between 1-3");
                System.out.println();
                displayMenu();
                break;
        }

    }

    public void addItem() throws ZeroNegativeErrorHandling {
        char choice;
        do {

            Item item = new Item();

            System.out.print("Enter item code: ");

            String itemCode = scanner.nextLine();

            item.setItemCode(itemCode);

            System.out.print("Enter item quantity: ");

            int itemQuantity = scanner.nextInt();

            if (itemQuantity <= 0)
                throw new ZeroNegativeErrorHandling();

            item.setItemQuantity(itemQuantity);

            System.out.print("Enter item Price: ");

            double itemPrice = scanner.nextDouble();

            if (itemPrice <= 0) {
                throw new ZeroNegativeErrorHandling();
            }

            itemsArray[numberOfItems] = item; // adding item to items array container
            numberOfItems = numberOfItems + 1;

            scanner.nextLine();

            item.setPrice(itemPrice);

            System.out.print("Do you want to add another item? (Y/N): ");
            choice = scanner.nextLine().toUpperCase().charAt(0);
            System.out.println();

        } while (choice == 'Y');
        displayMenu();

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

    public static void main(String[] args) {
        Main app = new Main();

        // app.addItem();
        boolean userSignedIn = app.userLogin();
        if (userSignedIn) {
            System.out.println();
            System.out.println("Successfully signed in");
            app.displayMenu();

        }
    }
}
