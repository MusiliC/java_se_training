package com.java_se_training.atmSimulator;

import java.util.Scanner;

public class AtmServices {

    
    public void atmSimulatorServices(){

        
        final String password = "Admin123";
        boolean userSignedIn = false;
        double balance = 1000.00;
    
        
        Scanner sn= new Scanner(System.in);  
        
        System.out.println("Welcome to Musili Bank" );

        for (int passwordCount = 1; passwordCount <= 3 ; passwordCount++) {

            if(userSignedIn){
                break;
            }

            System.out.print("Enter password: " );
            String userPassword = sn.nextLine();

            if(userPassword.equals(password)){
                userSignedIn = true;

                while(true){                
                
                System.out.println("*********************\n");
                System.out.println("ATM SIMULATOR\n");
                System.out.println("*********************\n");
                System.out.println("ATM SERVICES\n");
                System.out.println("______________________\n");

                   try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

               

                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdrawal");
                System.out.println("4. Transfer Cash");
                System.out.println("5. QUIT");

                  System.out.print("\nChoose your option: ");
                  int option = sn.nextInt();

                switch (option) {
                    case 1:
                        System.out.println("Your balance is: Ksh " + balance);
                         break;
                    case 2:
                          System.out.print("\nKindly enter the amount to deposit: ");
                           double amountDeposit = sn.nextDouble();
                           balance = balance + amountDeposit;
                           System.out.println("You have deposited: " + amountDeposit + " your new balance is total: Ksh " + balance);
                        break;
                    case 3:
                          System.out.print("\nKindly enter the amount to withdrawal: ");
                           double amountWithdrawal = sn.nextDouble();
                           double  amountWithdrawalCharge = (amountWithdrawal * 2)/100;
                           double totalAmountWithdrawalWithCharges = amountWithdrawal + amountWithdrawalCharge; 
                           if(totalAmountWithdrawalWithCharges > balance){
                            System.out.println("Your have insufficient funds to withdrawal this  amount" + " ksh " + amountWithdrawal);
                            System.out.println("Kindly, go back to the main menu");
                           }else{
                               balance = balance - totalAmountWithdrawalWithCharges;
                               System.out.println("You have withdrew: " + totalAmountWithdrawalWithCharges + " your new balance is total: Ksh " + balance + " with a transaction cost of ksh " + amountWithdrawalCharge);
                           }
                       
                        break;

                        case 4:
                              System.out.println("Service not available at the moment! ");
                              break; 

                      case 5:
                          System.out.println("Thank you, Hope to see you later!"); 
                          sn.close(); // Close the scanner
                          return; // Exit the program                                                     
                
                    default:
                    System.out.println("Kindly choose a number between 1 - 5 , thankyou");
                    break;
                }
            } 
            }else {
                System.out.println("Invalid password, Try again!");
            }
        }

        if(!userSignedIn) {
            System.out.println("Exiting program.Try next time\n");
        } else{
            System.out.println("Always feel welcomed again, Thank you!");
        }
        
    }

    public static void main(String[] args) {
        AtmServices app = new AtmServices();
        app.atmSimulatorServices();
    }
}
