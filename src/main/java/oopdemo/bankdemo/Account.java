package oopdemo.bankdemo;

public class Account {
    private String number;
    private double balance;
    private String name;
    private String email;
    private String phoneNumber;

    public Account(String number, double balance, String name, String email, String phoneNumber){
        this.number = number;
        this.balance = balance;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public void depositMoney(double depositedMoney){
        this.balance = this.balance + depositedMoney;
        System.out.println("Deposit successful, new balance is: " + this.balance);
    }

    public void withdrawalMoney(double moneyToWithdrawal){
        if(this.balance - moneyToWithdrawal < 0){
            System.out.println("Withdrawal unsuccessful, you balance is " + this.balance);
        }else{
            this.balance = this.balance - moneyToWithdrawal;
            System.out.println("Withdrawal successful, current balance is " + this.balance);
        }
    }

    public String getNumber() {
        return number;
    }
    public void setNumber(String number) {
        this.number = number;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    
}
