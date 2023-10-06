package com.systechafrica.atmsimulator;

import java.util.Scanner;

public class AtmServices {

    final String PASSWORD = "Admin123";
    final double RATE = 0.02;
    final double initialBalance = 1000.0;
    double workingBalance = initialBalance;

    Scanner scanner = new Scanner(System.in);

    public boolean userLogin() {

        int userPasswordCount = 1;
        boolean userSignedIn = false;

        System.out.println();

        while (userPasswordCount <= 3) {
            System.out.print("Enter your password - ");
            String userPassword = scanner.nextLine();

            if (userPassword.equals(PASSWORD)) {
                userSignedIn = true;
                break;
            }

            if (userPasswordCount == 3) {
                System.out.println("Wrong password, Maximum attempts Try again later!");
            } else {
                System.out.println("Wrong password, Try again");
            }

            userPasswordCount = userPasswordCount + 1;

        }

        return userSignedIn;

    }

    public void checkBalance() {
        System.out.println("Your balance is " + initialBalance);
    }

    public void depositCash() {

        System.out.print("Kindly enter the amount to deposit ");
        double deposit = scanner.nextDouble();
        // adding to the total balance
        workingBalance = workingBalance + deposit;
        System.out.println("Successfully deposited, Your new balance is ksh " + workingBalance);
    }

    public void withdrawalCash() {
        System.out.print("Kindly enter the amount to withdraw ");
        double amountToWithdrawal = scanner.nextDouble();
        double withdrawalFee = amountToWithdrawal * RATE;

        double totalAmountWithdrawalPlusCharges = amountToWithdrawal + withdrawalFee;

        if (totalAmountWithdrawalPlusCharges >= workingBalance) {
            System.out.println("Insufficient Balance, Available balance is ksh " + workingBalance);

        } else {
            System.out.println("Withdrawal successful, transaction cost was ksh " + withdrawalFee
                    + ", your new balance is ksh " + (workingBalance - totalAmountWithdrawalPlusCharges));
        }

    }

    public void transferCash() {
        System.out.print("Sorry, service not available at the moment");
    }

    public void printReceipt() {

    }

    public void displayMenu() {
        System.out.println();
        System.out.println("****************************");
        System.out.println();
        System.out.println("ATM SIMULATOR");
        System.out.println();
        System.out.println("****************************");
        System.out.println();
        System.out.println("ATM SERVICES");
        System.out.println();
        System.out.println("____________________________");
        System.out.println();
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdrawal");
        System.out.println("4. Transfer Cash");
        System.out.println("5. Quit");
        System.out.println();
        System.out.println("****************************");
        System.out.println();
    }

    public static void main(String[] args) {
        AtmServices app = new AtmServices();
        boolean loggedIn = app.userLogin();

        if (loggedIn) {
            System.out.println();
            System.out.println("Successfully logged in");

            boolean keepShowingMenu = true;

            

            while (keepShowingMenu) {
                app.displayMenu();

                try {
                    System.out.print("Choose your option: ");
                    int option = app.scanner.nextInt();

                    switch (option) {
                        case 1:
                            app.checkBalance();
                            break;
                        case 2:
                            app.depositCash();
                            break;
                        case 3:
                            app.withdrawalCash();
                            break;
                        case 4:
                            app.transferCash();
                            break;
                        case 5:
                            keepShowingMenu = false;
                            break;
                        default:
                            System.out.println("Invalid option");
                            break;
                    }

                    System.out.println();
                    System.out.println("Thank you, Always welcomed!");

                } catch (Exception e) {
                    // TODO: handle exception
                    app.scanner.nextLine();
                    System.out.println("Invalid input");
                }
            }

        }
    }
}
