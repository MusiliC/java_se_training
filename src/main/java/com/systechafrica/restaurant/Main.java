package com.systechafrica.restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    private List<MenuItem> menuListItems = new ArrayList<MenuItem>();
    private List<MenuItem> orderedMenuItemsArray = new ArrayList<MenuItem>();

    final String PASSWORD = "Admin123";
    private double totalAmount = 0;
    private double userAmount = 0;

    public boolean userLogin() {

        int passwordAttempts = 1;
        boolean isUserLoggedIn = false;

        System.out.println();
        System.out.println("Welcome to Systech Restaurant System");
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

    public void foodMenu() {
        menuListItems.add(new MenuItem(1, "CHAI", 15));
        menuListItems.add(new MenuItem(2, "ANDAZI", 10));
        menuListItems.add(new MenuItem(3, "TOSTI", 12));
        menuListItems.add(new MenuItem(4, "NDENGU AND ACCOMPLISHMENTS", 70));
        menuListItems.add(new MenuItem(5, "BEANS AND ACCOMPLISHMENTS", 70));
        menuListItems.add(new MenuItem(6, "PILAU VEG", 90));

    }

    public void displayHotelMenu() {

        foodMenu();

        System.out.println();
        System.out.println("*****************************************");
        System.out.println();
        System.out.println("SYSTECH RESTAURANT");
        System.out.println();
        System.out.println("DRINKS");
        System.out.println("***************************");
        System.out.println();
        System.out.println("1. CHAI---------------------------- 15");
        System.out.println("2. ANDAZI--------------------------- 10");
        System.out.println("3. TOSTI----------------------------- 12");
        System.out.println();

        System.out.println("MEALS");
        System.out.println("***************************");
        System.out.println();
        System.out.println("4. NDENGU AND ACCOMPLISHMENTS---------------------------- 70");
        System.out.println("5. BEANS AND ACCOMPLISHMENTS--------------------------- 70");
        System.out.println("6. PILAU VEG----------------------------- 90");
        System.out.println("7. QUIT");
        System.out.println();

       addMenuItemToFoodArray();

        // choose and add to food items array

        promptUserChooseMealOrMakePayment();
    }

    private int customerOrderItem() {
        System.out.print("Choose your drink/Meal-one item at a time: ");
        int customerOrder = scanner.nextInt();
        scanner.nextLine();
        return customerOrder;
    }

    private void addMenuItemToFoodArray() {
       int choice =  customerOrderItem();

       switch (choice) {
        case 1:
            MenuItem chai = menuListItems.get(0);
            orderedMenuItemsArray.add(new MenuItem(chai.getId(), chai.getName(), chai.getPrice()));
            break;
        case 2: 
             MenuItem andazi = menuListItems.get(1);
            orderedMenuItemsArray.add(new MenuItem(andazi.getId(), andazi.getName(), andazi.getPrice()));
            break; 
        case 3: 
             MenuItem tosti = menuListItems.get(2);
            orderedMenuItemsArray.add(new MenuItem(tosti.getId(), tosti.getName(), tosti.getPrice()));
            break; 
        case 4: 
             MenuItem ndengu = menuListItems.get(3);
            orderedMenuItemsArray.add(new MenuItem(ndengu.getId(), ndengu.getName(), ndengu.getPrice()));
            break; 
        case 5: 
             MenuItem beans = menuListItems.get(4);
            orderedMenuItemsArray.add(new MenuItem(beans.getId(), beans.getName(), beans.getPrice()));
            break; 
        case 6: 
             MenuItem pilau = menuListItems.get(5);
            orderedMenuItemsArray.add(new MenuItem(pilau.getId(), pilau.getName(), pilau.getPrice()));
            break; 
        case 7: 
            exitSystem();
            break; 
       
        default:
        System.out.println("Invalid choice, choose between 1-7");
            break;
       }
    }

    private void promptUserChooseMealOrMakePayment() {
        System.out.print("Do you want enter another meal/drink option(Y/N); ");

        char orderAnotherMeal = scanner.next().toUpperCase().charAt(0);

        if (orderAnotherMeal == 'Y') {
            displayHotelMenu();
        } else if (orderAnotherMeal == 'N') {
            System.out.println();
            System.out.println("**************************");
            System.out.println();
            System.out.print("Proceed to payment? (Y/N): ");
            Character proceedToPayment = scanner.next().toUpperCase().charAt(0);
            if (proceedToPayment.equals('Y')) {
                payNow();
            }
        } else {
            System.out.println();
            System.out.println("Invalid choice, Choose between Y and N");
            System.out.println();
            // method to repeat itself
            promptUserChooseMealOrMakePayment();
        }
    }

    private void payNow() {
        System.out.println();
        System.out.println("Pay Now For");
        System.out.println();
        for (MenuItem foodItem : orderedMenuItemsArray) {
            System.out.println(foodItem.getName() + " ----------------- " + foodItem.getPrice());
            totalAmount = totalAmount + foodItem.getPrice();
        }

        System.out.println("Total: sh " + totalAmount);
        System.out.println();

        enterUserAmount();

        while (userAmount < totalAmount) {
            System.out.println();
            System.out.println("Insufficient amount, Kindly confirm user amount and try again");
            System.out.println();
            enterUserAmount();
        }

        System.out.println();
        double userChange = userAmount - totalAmount;

        System.out.println("Your balance is -------------------- sh: " + userChange);
        orderedMenuItemsArray.clear(); // Clear the order items
        System.out.println();

    }

    public void enterUserAmount() {
        System.out.print("Enter to pay: ");
        userAmount = scanner.nextInt();
    }

    public void exitSystem(){
        System.out.println();
        System.out.println("Exiting system..");
        System.exit(0);
        System.out.println();
    }

    public static void main(String[] args) {
        Main app = new Main();

        boolean userSignedIn = app.userLogin();
        if (userSignedIn) {
            System.out.println();
            System.out.println("Successfully signed in");
            app.displayHotelMenu();

        }

    }
}
