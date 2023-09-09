package com.systechafrica.posquestiontwo;

import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);

    Item[] itemsArray = new Item[1000]; // ?initializing the array to hold 1000 items assuming its not expected user to
                                        // ? enter 1000 items
    int numberOfItems = 0;

    double totalPriceOfAllItems = 0;

    int userAmount = 0;

    public void addItem() {

        while (true) {

            Item item = new Item();

            System.out.print("Enter item code: ");

            String itemCode = scanner.nextLine();

            item.setItemCode(itemCode);

            System.out.print("Enter item quantity: ");

            int itemQuantity = scanner.nextInt();

            item.setItemQuantity(itemQuantity);

            System.out.print("Enter item Price: ");

            double itemPrice = scanner.nextDouble();

            itemsArray[numberOfItems] = item;
            numberOfItems = numberOfItems + 1;

            scanner.nextLine();

            item.setPrice(itemPrice);

            System.out.print("Do you want to add another item? (Y/N): ");
            String choice = scanner.nextLine();
            System.out.println();
            if (choice.equalsIgnoreCase("n")) {
                break;
            }
        }

        displayAllItems();
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

        enterUserAmount(); // I am using method to enter user amount so that when the cashier enters insufficient amount it can call the method again

        while (userAmount < totalPriceOfAllItems) {
        System.out.println();
        System.out.println("Insufficient amount, Kindly confirm user amount and try again");
        System.out.println();
        enterUserAmount();
        }

        System.out.println();

        double userChange = userAmount - totalPriceOfAllItems;

        System.out.println("Change: \t" + "sh: " + userChange);

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

    public static void main(String[] args) {
        Main app = new Main();

        app.addItem();
    }
}
